package com.soo.ticketpick.command.controller;

import com.soo.ticketpick.command.service.ReservationCommandService;
import com.soo.ticketpick.common.dto.ReservationRequest;
import com.soo.ticketpick.common.dto.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/command/reservations")
@RequiredArgsConstructor
public class ReservationCommandController {
    
    private final ReservationCommandService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse createReservation(@RequestBody ReservationRequest request) {
        return service.reserve(request);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelReservation(@PathVariable Long id) {
        service.cancel(id);
    }
}
