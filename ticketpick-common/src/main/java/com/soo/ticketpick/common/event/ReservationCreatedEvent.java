package com.soo.ticketpick.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationCreatedEvent implements Serializable {
    private Long reservationId;
    private Long seatId;
    private String customerName;
    private String phoneNumber;
    private LocalDateTime createdAt;
}
