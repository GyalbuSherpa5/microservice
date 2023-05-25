package com.userservice.service;

import com.userservice.dto.UserResponse;
import com.userservice.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();
}
