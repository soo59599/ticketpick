package com.soo.ticketpick.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "game")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String homeTeam;
    
    @Column(nullable = false)
    private String awayTeam;
    
    @Column(nullable = false)
    private LocalDateTime gameDate;
    
    @Column(nullable = false)
    private String stadium;
    
    public Game(String homeTeam, String awayTeam, LocalDateTime gameDate, String stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.gameDate = gameDate;
        this.stadium = stadium;
    }
}
