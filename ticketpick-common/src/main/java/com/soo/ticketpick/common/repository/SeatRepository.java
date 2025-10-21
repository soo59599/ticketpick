package com.soo.ticketpick.common.repository;

import com.soo.ticketpick.common.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByGameId(Long gameId);
}
