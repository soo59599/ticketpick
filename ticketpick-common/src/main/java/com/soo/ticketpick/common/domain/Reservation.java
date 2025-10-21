package com.soo.ticketpick.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reservation")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long seatId;
    
    @Column(nullable = false)
    private String customerName;
    
    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    @Builder
    public Reservation(Long seatId, String customerName, String phoneNumber) {
        this.seatId = seatId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.createdAt = LocalDateTime.now();
    }
}
