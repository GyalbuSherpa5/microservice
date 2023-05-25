package com.userservice.controller;

import com.userservice.dto.UserResponse;
import com.userservice.model.User;
import com.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public String saveUser(@RequestBody User user){
        userService.saveUser(user);
        return "saved successfully";
    }

    @GetMapping("/users/{id}")
    public UserResponse getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUser(){
        return userService.getAllUsers();
    }

}
