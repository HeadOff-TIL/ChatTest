package org.example.chattest.chatRoomUser;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatRoomUserService {
    private final MongoTemplate mongoTemplate;

    public ChatRoomUserDTO createChatRoomUser(ChatRoomUserDTO chatRoomUserDTO){
        ChatRoomUser chatRoomUser = mongoTemplate.save(
                ChatRoomUser.builder()
                        .roomId(chatRoomUserDTO.roomId)
                        .userId(chatRoomUserDTO.userId).build(),
                "chat_room_user");
        return new ChatRoomUserDTO(chatRoomUser.getId(), chatRoomUser.getRoomId(), chatRoomUser.getUserId());
    }

}
