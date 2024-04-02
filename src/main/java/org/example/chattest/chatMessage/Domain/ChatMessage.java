package org.example.chattest.chatMessage.Domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "chat_message")
@Getter @ToString @Setter
@AllArgsConstructor @Builder
@NoArgsConstructor
public class ChatMessage {
    @Id
    private String id;
    private Long chatRoomId;
    private Long senderId;
    private String senderName;
    private String message;
    private boolean isDeleted;
    private LocalDateTime created_at;
}
