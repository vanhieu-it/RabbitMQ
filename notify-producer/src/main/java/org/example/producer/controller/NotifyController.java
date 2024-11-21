package org.example.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/line")
public class NotifyController {

    private final RabbitTemplate rabbitTemplate;

    public NotifyController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/send")
    public String sendNotification(@RequestBody String message) {
        rabbitTemplate.convertAndSend("notify-exchange", "notify-routingKey", message);
        return "Message sent to queue: " + message;
    }
}
