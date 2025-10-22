package com.soo.ticketpick.command.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    
    public static final String RESERVATION_CREATED_QUEUE = "reservation.created";
    public static final String RESERVATION_CANCELLED_QUEUE = "reservation.cancelled";
    
    @Bean
    public Queue reservationCreatedQueue() {
        return new Queue(RESERVATION_CREATED_QUEUE, true);
    }
    
    @Bean
    public Queue reservationCancelledQueue() {
        return new Queue(RESERVATION_CANCELLED_QUEUE, true);
    }
    
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
