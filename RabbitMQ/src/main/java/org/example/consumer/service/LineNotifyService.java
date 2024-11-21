package org.example.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Service
public class LineNotifyService {

    private static final String LINE_NOTIFY_API = "https://notify-api.line.me/api/notify";

    @RabbitListener(queues = "line_notify_queue")
    public void handleLineNotifyRequest(Map<String, String> lineRequest) {
        String accessToken = lineRequest.get("access_token");
        String message = lineRequest.get("message");

        if (accessToken == null || message == null) {
            System.out.println("Invalid request! Missing 'access_token' or 'message'.");
            return;
        }

        try {
            sendLineNotification(accessToken, message);
            System.out.println("Notification sent successfully!");
        } catch (Exception e) {
            System.out.println("Failed to send notification: " + e.getMessage());
        }
    }

    private void sendLineNotification(String accessToken, String message) {
        RestTemplate restTemplate = new RestTemplate();

        // Tạo header Authorization
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBearerAuth(accessToken);

        // Tạo body cho yêu cầu
        HttpEntity<String> request = new HttpEntity<>("message=" + message, headers);

        // Gửi yêu cầu đến LINE Notify API
        ResponseEntity<String> response = restTemplate.postForEntity(LINE_NOTIFY_API, request, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("LINE Notify API returned error: " + response.getBody());
        }
    }
}

