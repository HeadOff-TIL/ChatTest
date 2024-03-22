package org.example.chattest.service;

import lombok.RequiredArgsConstructor;
import org.example.chattest.domain.dto.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessageService {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void sendMessage(String topic, Message message){
        kafkaTemplate.send(topic,message);
    }
}
