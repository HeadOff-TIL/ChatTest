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
public class KafkaMessageDTO implements Serializable {

    private String chatRoomId;
    private Long senderId;
    private String senderName;
    private String message;
    private long created_at;

}