package com.soo.ticketpick.query.controller;

import com.soo.ticketpick.common.domain.Seat;
import com.soo.ticketpick.common.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/seats")
@RequiredArgsConstructor
public class SeatQueryController {
    
    private final SeatRepository seatRepository;
    
    @GetMapping
    public List<Seat> getSeatsByGameId(@RequestParam Long gameId) {
        return seatRepository.findByGameId(gameId);
    }
    
    @GetMapping("/{id}")
    public Seat getSeat(@PathVariable Long id) {
        return seatRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("좌석을 찾을 수 없습니다."));
    }
}
