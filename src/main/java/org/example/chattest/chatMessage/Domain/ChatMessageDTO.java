package org.example.chattest.chatMessage.Domain;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDTO implements Serializable {

    private String id;
    private Long chatRoomId;
    private Long senderId;
    private String senderName;
    private String message;
    private boolean isDeleted;
    private long created_at;

    public void setSendTimeAndSender(LocalDateTime created_at, Long senderId, String senderName) {
        this.senderName = senderName;
        this.created_at = created_at.atZone(ZoneId.of("Asia/Seoul")).toInstant().toEpochMilli();
        this.senderId = senderId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChatMessage convertEntity() {
        return ChatMessage.builder()
                .senderName(senderName)
                .chatRoomId(chatRoomId)
                .created_at(Instant.ofEpochMilli(created_at).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime())
                .message(message)
                .isDeleted(false)
                .build();
    }
}