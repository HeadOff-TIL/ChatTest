package org.example.chattest.controller;

import lombok.AllArgsConstructor;
import org.example.chattest.domain.dto.Message;
import org.example.chattest.service.UserService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class userController {

    private final UserService userService;
    @PostMapping("/user")
    public Message createUser(@Payload Message message){
        return message;
    }

}
