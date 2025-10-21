package com.soo.ticketpick.common.repository;

import com.soo.ticketpick.common.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
