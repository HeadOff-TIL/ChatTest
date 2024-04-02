package org.example.chattest.chatRoomUser;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat_room_user")
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ChatRoomUser {
    @Id
    private String id;
    private String roomId;
    private String userId;
}
