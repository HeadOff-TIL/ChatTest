package org.example.chattest.chatRoom;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChatRoomService {
    private final MongoTemplate mongoTemplate;

    public ChatRoomDTO createChatRoom(ChatRoomDTO chatRoomDTO){
        ChatRoom chatRoom = mongoTemplate.save(ChatRoom.builder().roomName(chatRoomDTO.roomName).build(), "chat_room");
        return new ChatRoomDTO(chatRoom.getId(), chatRoom.getRoomName());
    }

    public List<ChatRoomDTO> readChatRoomList(){
        List<ChatRoom> chatRoomList = mongoTemplate.findAll(ChatRoom.class, "chat_room");
        return chatRoomList.stream()
                .map(chatRoom -> new ChatRoomDTO(chatRoom.getId(), chatRoom.getRoomName()))
                .collect(Collectors.toList());

    }

}
