package com.camere.blue.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String NOME_FILA = "hotel.queue";
    public static final String NOME_EXCHANGE = "hotel.exchange";
    public static final String ROUTING_KEY = "hotel.routingkey";

    @Bean
    public Queue hotelQueue() {
        return new Queue(NOME_FILA, true);
    }

    @Bean
    public DirectExchange hotelExchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    @Bean
    public Binding hotelBinding(Queue hotelQueue, DirectExchange hotelExchange) {
        return BindingBuilder.bind(hotelQueue).to(hotelExchange).with(ROUTING_KEY);
    }
}
