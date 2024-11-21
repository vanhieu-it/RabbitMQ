package org.example.producer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LineNotifyProducerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LineNotifyProducerApplication.class);
        app.setAdditionalProfiles("producer");
        app.run(args);
        System.out.println("Producer application is running on http://localhost:8080");
    }
}
