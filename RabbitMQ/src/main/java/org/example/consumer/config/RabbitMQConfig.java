package org.example.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue lineNotifyQueue() {
        return new Queue("line_notify_queue", true);
    }
}
