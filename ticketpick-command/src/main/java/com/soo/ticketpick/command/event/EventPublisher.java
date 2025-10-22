package com.soo.ticketpick.command.event;

import com.soo.ticketpick.command.config.RabbitMQConfig;
import com.soo.ticketpick.common.event.ReservationCancelledEvent;
import com.soo.ticketpick.common.event.ReservationCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EventPublisher {
    
    private final RabbitTemplate rabbitTemplate;
    
    public void publishReservationCreated(ReservationCreatedEvent event) {
        log.info("Publishing ReservationCreatedEvent: {}", event.getReservationId());
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.RESERVATION_CREATED_QUEUE,
            event
        );
    }
    
    public void publishReservationCancelled(ReservationCancelledEvent event) {
        log.info("Publishing ReservationCancelledEvent: {}", event.getReservationId());
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.RESERVATION_CANCELLED_QUEUE,
            event
        );
    }
}
