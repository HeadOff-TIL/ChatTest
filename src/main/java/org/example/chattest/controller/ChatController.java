package org.example.chattest.controller;

import org.example.chattest.domain.ChatMessage;
import org.example.chattest.domain.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public Message sendMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/newUser")
    @SendTo("/topic/messages")
    public Message newUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
        // Add a user in the WebSocket session
        headerAccessor.getSessionAttributes().put("username", message.getSenderName());
        return message;
    }
}
