package org.example;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
    private final static String QUEUE_NAME = "hello_queue";

    public static void main(String[] args) {
        // Tạo kết nối đến RabbitMQ
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // RabbitMQ chạy trên localhost

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // Khai báo một hàng đợi
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // Thông điệp cần gửi
            String message = "Hello, RabbitMQ!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
