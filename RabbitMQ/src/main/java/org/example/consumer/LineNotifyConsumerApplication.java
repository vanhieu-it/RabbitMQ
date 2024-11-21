package org.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LineNotifyConsumerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LineNotifyConsumerApplication.class);
        app.setAdditionalProfiles("consumer");
        app.run(args);
        System.out.println("Consumer application is running and listening to RabbitMQ queue");
    }
}
