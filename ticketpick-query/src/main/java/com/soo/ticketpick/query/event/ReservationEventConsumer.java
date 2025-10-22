package com.soo.ticketpick.query.event;

import com.soo.ticketpick.common.event.ReservationCancelledEvent;
import com.soo.ticketpick.common.event.ReservationCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReservationEventConsumer {
    
    @RabbitListener(queues = "reservation.created")
    public void handleReservationCreated(ReservationCreatedEvent event) {
        log.info("Received ReservationCreatedEvent: reservationId={}, seatId={}, customer={}", 
            event.getReservationId(), 
            event.getSeatId(), 
            event.getCustomerName());
        
        // TODO: Query DB 업데이트 로직
        // 예: 예매 내역 캐시 갱신, 통계 업데이트 등
    }
    
    @RabbitListener(queues = "reservation.cancelled")
    public void handleReservationCancelled(ReservationCancelledEvent event) {
        log.info("Received ReservationCancelledEvent: reservationId={}, seatId={}", 
            event.getReservationId(), 
            event.getSeatId());
        
        // TODO: Query DB 업데이트 로직
        // 예: 예매 내역 캐시 갱신, 통계 업데이트 등
    }
}
