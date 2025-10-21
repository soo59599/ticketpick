package com.soo.ticketpick.query.controller;

import com.soo.ticketpick.common.domain.Game;
import com.soo.ticketpick.common.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/query/games")
@RequiredArgsConstructor
public class GameQueryController {
    
    private final GameRepository gameRepository;
    
    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {
        return gameRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("경기를 찾을 수 없습니다."));
    }
}
