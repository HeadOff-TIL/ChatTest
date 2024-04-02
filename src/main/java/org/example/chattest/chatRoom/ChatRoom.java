package org.example.chattest.chatRoom;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chat_room")
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ChatRoom {
    @Id
    private String id;
    private String roomName;
    private LocalDateTime createdAt;
}
