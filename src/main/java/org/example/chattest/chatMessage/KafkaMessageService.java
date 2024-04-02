package org.example.chattest.chatMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.chattest.chatMessage.Domain.ChatMessageDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageService {
    private final KafkaTemplate<String, ChatMessageDTO> kafkaTemplate;

    public void sendMessage(String topic, ChatMessageDTO chatMessageDTO){
        log.info("Send Message: " +chatMessageDTO.getMessage());
        kafkaTemplate.send(topic, chatMessageDTO);
    }
}
