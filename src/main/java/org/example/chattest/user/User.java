package org.example.chattest.user;

import lombok.*;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String name;
}
