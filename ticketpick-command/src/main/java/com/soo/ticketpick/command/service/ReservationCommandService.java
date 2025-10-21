package com.soo.ticketpick.command.service;

import com.soo.ticketpick.common.domain.Reservation;
import com.soo.ticketpick.common.domain.Seat;
import com.soo.ticketpick.common.dto.ReservationRequest;
import com.soo.ticketpick.common.dto.ReservationResponse;
import com.soo.ticketpick.common.repository.ReservationRepository;
import com.soo.ticketpick.common.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationCommandService {
    
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;
    
    public ReservationResponse reserve(ReservationRequest request) {
        // 좌석 조회
        Seat seat = seatRepository.findById(request.getSeatId())
            .orElseThrow(() -> new IllegalArgumentException("좌석을 찾을 수 없습니다."));
        
        // 예매 처리
        seat.reserve();
        
        // 예매 정보 저장
        Reservation reservation = Reservation.builder()
            .seatId(seat.getId())
            .customerName(request.getCustomerName())
            .phoneNumber(request.getPhoneNumber())
            .build();
        
        Reservation saved = reservationRepository.save(reservation);
        
        return ReservationResponse.from(saved);
    }
    
    public void cancel(Long reservationId) {
        // 예매 정보 조회
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new IllegalArgumentException("예매를 찾을 수 없습니다."));
        
        // 좌석 조회
        Seat seat = seatRepository.findById(reservation.getSeatId())
            .orElseThrow(() -> new IllegalArgumentException("좌석을 찾을 수 없습니다."));
        
        // 예매 취소
        seat.cancel();
        reservationRepository.delete(reservation);
    }
}
