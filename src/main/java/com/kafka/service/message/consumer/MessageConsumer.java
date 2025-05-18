package com.kafka.service.message.consumer;

import com.kafka.service.message.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @KafkaListener(topics = "${topic.name}", groupId = "test-group")
    public void listen(Message message) {
        System.out.println("Consumed message: " + message);
    }
}
