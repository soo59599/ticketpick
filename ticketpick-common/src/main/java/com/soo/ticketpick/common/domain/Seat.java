package com.soo.ticketpick.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "seat")
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long gameId;
    
    @Column(nullable = false)
    private String section;
    
    @Column(nullable = false)
    private String seatNumber;
    
    @Column(nullable = false)
    private Integer price;
    
    @Column(nullable = false)
    private Boolean isReserved = false;
    
    public Seat(Long gameId, String section, String seatNumber, Integer price) {
        this.gameId = gameId;
        this.section = section;
        this.seatNumber = seatNumber;
        this.price = price;
        this.isReserved = false;
    }
    
    public void reserve() {
        if (this.isReserved) {
            throw new IllegalStateException("이미 예매된 좌석입니다.");
        }
        this.isReserved = true;
    }
    
    public void cancel() {
        if (!this.isReserved) {
            throw new IllegalStateException("예매되지 않은 좌석입니다.");
        }
        this.isReserved = false;
    }
}
