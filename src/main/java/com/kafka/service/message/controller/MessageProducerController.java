package com.kafka.service.message.controller;

import com.kafka.service.message.model.Message;
import com.kafka.service.message.producer.MessageProducer;
import com.kafka.service.message.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageProducerController {

    @Autowired
    private MessageProducer messageProducer;

    @Autowired
    private MessageProducerService messageProducerService;

    @PostMapping("/produce")
    public String produceMessage(@RequestBody Message message) {
        try {
            messageProducerService.sendMessage(message);
            return "Message sent to Kafka topic!";
        } catch (Exception e) {
            return "Error while sending message: " + e.getMessage();
        }
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody Message message) {
        try {
            messageProducer.sendMessage(message);
            return ResponseEntity.ok("Message published successfully to Kafka topic!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while publishing message: " + e.getMessage());
        }
    }
}
