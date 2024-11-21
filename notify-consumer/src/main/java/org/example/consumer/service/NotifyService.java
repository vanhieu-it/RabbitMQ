package org.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    @RabbitListener(queues = "notify-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message from queue: " + message);
        // Bạn có thể tích hợp Line Notify tại đây
    }
}
