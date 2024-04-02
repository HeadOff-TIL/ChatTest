package org.example.chattest.chatMessage;

import org.example.chattest.chatMessage.Domain.ChatMessageDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    @KafkaListener(topics = "chat-topic", groupId = "chat")
    public void listenGroupChat(ChatMessageDTO chatMessageDTO){
        System.out.println("Received Message in group 'chat: " + chatMessageDTO.getMessage());
    }
}
