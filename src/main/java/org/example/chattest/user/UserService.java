package org.example.chattest.user;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class UserService {
    private final MongoTemplate mongoTemplate;

    public UserDTO createUser(UserDTO userDTO){
        User user = mongoTemplate.save(User.builder().name(userDTO.name).build(), "user");
        return new UserDTO(user.getId(), user.getName());
    }

    public List<UserDTO> readUser(){

        List<User> userList = mongoTemplate.findAll(User.class, "user");
        return userList.stream()
                .map(user-> new UserDTO(user.getId(), user.getName()))
                .collect(Collectors.toList());
    }

}
