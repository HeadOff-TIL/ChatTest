package org.example.chattest.chatRoomUser;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatRoomUserController {
    private final ChatRoomUserService chatRoomUserService;

    @PostMapping("/chatRoomUser")
    public ChatRoomUserDTO createChatRoomUser(ChatRoomUserDTO chatRoomUserDTO){
        return chatRoomUserService.createChatRoomUser(chatRoomUserDTO);
    }
}
