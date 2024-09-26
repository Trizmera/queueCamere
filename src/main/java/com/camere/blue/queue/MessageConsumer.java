package com.camere.blue.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "hotel.queue")
    public void receive(String message) {
        System.out.println("Message received from queue: " + message);
        forwardToFrontDesk(message);
    }

    private void forwardToFrontDesk(String message) {
        System.out.println("Message received from frontDesk: " + message);
    }
}
