package org.example.chattest.chatMessage;

import org.example.chattest.chatMessage.Domain.ChatMessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessageDTO sendMessage(@Payload ChatMessageDTO chatMessageDTO){

        return chatMessageDTO;
    }

    @MessageMapping("/newUser")
    @SendTo("/topic/messages")
    public ChatMessageDTO newUser(@Payload ChatMessageDTO chatMessageDTO, SimpMessageHeaderAccessor headerAccessor) {
        // Add a user in the WebSocket session
        headerAccessor.getSessionAttributes().put("username", chatMessageDTO.getSenderName());
        return chatMessageDTO;
    }
}
