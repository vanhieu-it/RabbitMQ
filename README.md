Request
```
curl --location 'http://localhost:8080/api/line/send' \
--header 'Content-Type: application/json' \
--data '{
  "message": "Hello from Notify via RabbitMQ!"
}'
```
Response
```
Message sent to queue: {
  "message": "Hello from Notify via RabbitMQ!"
}
```
