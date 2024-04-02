package org.example.chattest.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }


    @GetMapping("/user")
    public List<UserDTO> readUsers() {
        return userService.readUser();
    }
}
