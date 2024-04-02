package org.example.chattest.user;

import org.apache.kafka.common.protocol.types.Field;

public class UserDTO {
    public String id;
    public String name;

    public UserDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
