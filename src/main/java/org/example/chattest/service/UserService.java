package org.example.chattest.service;

import lombok.AllArgsConstructor;
import org.example.chattest.domain.User;
import org.example.chattest.domain.dto.UserDTO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final MongoTemplate mongoTemplate;

    public void createUser(UserDTO userDTO){
        mongoTemplate.save(User.builder().name(userDTO.name), "user");
    }

}
