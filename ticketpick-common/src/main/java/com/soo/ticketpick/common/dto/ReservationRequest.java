package com.soo.ticketpick.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Long seatId;
    private String customerName;
    private String phoneNumber;
}
