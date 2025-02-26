package com.example.Users_microservices.Controller;

import com.example.Users_microservices.Services.UserService;
import com.example.Users_microservices.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @GetMapping("/get")
    public List<UserEntity> getUsers() {
        return userService.getAllUsers();
    }
}
