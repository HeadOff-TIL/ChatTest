package org.example.chattest.chatRoom;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/chatRoom")
    public ChatRoomDTO createChatRoom(ChatRoomDTO chatRoomDTO) {
        return chatRoomService.createChatRoom(chatRoomDTO);
    }

    @GetMapping("/chatRoom")
    public List<ChatRoomDTO> readChatRoomList() {
        return chatRoomService.readChatRoomList();
    }
}
