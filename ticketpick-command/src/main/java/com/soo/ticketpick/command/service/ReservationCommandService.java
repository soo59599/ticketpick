package com.soo.ticketpick.command.service;

import com.soo.ticketpick.command.event.EventPublisher;
import com.soo.ticketpick.common.domain.Reservation;
import com.soo.ticketpick.common.domain.Seat;
import com.soo.ticketpick.common.dto.ReservationRequest;
import com.soo.ticketpick.common.dto.ReservationResponse;
import com.soo.ticketpick.common.event.ReservationCancelledEvent;
import com.soo.ticketpick.common.event.ReservationCreatedEvent;
import com.soo.ticketpick.common.repository.ReservationRepository;
import com.soo.ticketpick.common.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationCommandService {
    
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;
    private final EventPublisher eventPublisher;
    
    public ReservationResponse reserve(ReservationRequest request) {
        Seat seat = seatRepository.findById(request.getSeatId())
            .orElseThrow(() -> new IllegalArgumentException("좌석을 찾을 수 없습니다."));
        
        seat.reserve();
        
        Reservation reservation = Reservation.builder()
            .seatId(seat.getId())
            .customerName(request.getCustomerName())
            .phoneNumber(request.getPhoneNumber())
            .build();
        
        Reservation saved = reservationRepository.save(reservation);
        
        // Event 발행
        eventPublisher.publishReservationCreated(
            new ReservationCreatedEvent(
                saved.getId(),
                saved.getSeatId(),
                saved.getCustomerName(),
                saved.getPhoneNumber(),
                saved.getCreatedAt()
            )
        );
        
        return ReservationResponse.from(saved);
    }
    
    public void cancel(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new IllegalArgumentException("예매를 찾을 수 없습니다."));
        
        Seat seat = seatRepository.findById(reservation.getSeatId())
            .orElseThrow(() -> new IllegalArgumentException("좌석을 찾을 수 없습니다."));
        
        seat.cancel();
        reservationRepository.delete(reservation);
        
        // Event 발행
        eventPublisher.publishReservationCancelled(
            new ReservationCancelledEvent(
                reservation.getId(),
                reservation.getSeatId(),
                LocalDateTime.now()
            )
        );
    }
}
