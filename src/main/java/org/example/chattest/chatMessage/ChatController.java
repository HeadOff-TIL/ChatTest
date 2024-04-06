package org.example.chattest.chatMessage;

import lombok.RequiredArgsConstructor;
import org.example.chattest.chatMessage.Domain.KafkaMessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final KafkaMessageService kafkaMessageService;

    @MessageMapping("/sendMessage")
    public void sendMessage(@Payload KafkaMessageDTO kafkaMessageDTO){
        kafkaMessageService.produceMessage(kafkaMessageDTO);
        //return kafkaMessageDTO;
    }

//    @MessageMapping("/newUser")
//    @SendTo("/topic/messages")
//    public KafkaMessageDTO newUser(@Payload KafkaMessageDTO kafkaMessageDTO, SimpMessageHeaderAccessor headerAccessor) {
//        // Add a user in the WebSocket session
//        headerAccessor.getSessionAttributes().put("username", kafkaMessageDTO.getSenderName());
//        return kafkaMessageDTO;
//    }
}
