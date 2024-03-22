package org.example.chattest.service;

import org.example.chattest.domain.dto.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @KafkaListener(topics = "hanchattest", groupId = "chat")
    public void listenGroupChat(Message message){
        System.out.println("Received Message in group 'chat: " + message.getMessage());
    }
}
