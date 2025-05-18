package com.kafka.service.message.producer;

import com.kafka.service.message.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${topic.name}")
    private String topicName;

    public MessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message) {
//        String value = "{\"name\":\"" + message.getName() + "\", \"message\":\"" + message.getMessage() + "\"}";
        kafkaTemplate.send(topicName, message);
    }
}
