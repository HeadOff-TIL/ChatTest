package org.example.chattest.chatMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.chattest.chatMessage.Domain.KafkaMessageDTO;
import org.example.chattest.chatMessage.config.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageService {
    private final KafkaTemplate<String, KafkaMessageDTO> kafkaTemplate;
    private final SimpMessageSendingOperations sendingOperations;
    private final SimpMessagingTemplate template;


    public void produceMessage(KafkaMessageDTO kafkaMessageDTO) {
        log.info("Room ID: " + kafkaMessageDTO.getChatRoomId() + " / Send Message: " + kafkaMessageDTO.getMessage());
        kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, kafkaMessageDTO);
    }

    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC)
    public void consumeMessage(KafkaMessageDTO kafkaMessageDTO) throws IOException {

        String destination = "/topic/" + kafkaMessageDTO.getChatRoomId();
        log.info("Destination: " + destination + " / Subscribe Message: " + kafkaMessageDTO.getMessage());
        template.convertAndSend(destination, kafkaMessageDTO);
    }
}
