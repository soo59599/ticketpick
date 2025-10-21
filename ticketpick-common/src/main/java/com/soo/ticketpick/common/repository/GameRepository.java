package com.soo.ticketpick.common.repository;

import com.soo.ticketpick.common.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
