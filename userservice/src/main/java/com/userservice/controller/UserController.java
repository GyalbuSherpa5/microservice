package com.userservice.controller;

import com.userservice.dto.UserResponse;
import com.userservice.model.User;
import com.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "saved successfully";
    }

    @GetMapping("/users/{id}")
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> ratingHotelFallback(Long id, Exception exception) {
        log.info("Fallback is executed because " + exception);
        UserResponse userResponse = UserResponse.builder()
                .name("dummy")
                .about("Service is down")
                .email("dummy@gmail.com")
                .build();
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUser() {
        return userService.getAllUsers();
    }

}
