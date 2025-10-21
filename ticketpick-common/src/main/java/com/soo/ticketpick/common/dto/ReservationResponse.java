package com.soo.ticketpick.common.dto;

import com.soo.ticketpick.common.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReservationResponse {
    private Long id;
    private Long seatId;
    private String customerName;
    private String phoneNumber;
    private LocalDateTime createdAt;
    
    public static ReservationResponse from(Reservation reservation) {
        return new ReservationResponse(
            reservation.getId(),
            reservation.getSeatId(),
            reservation.getCustomerName(),
            reservation.getPhoneNumber(),
            reservation.getCreatedAt()
        );
    }
}
