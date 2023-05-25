package com.userservice.service;

import com.userservice.dto.UserResponse;
import com.userservice.dto.UserToResponseMapper;
import com.userservice.exception.UserNotFoundException;
import com.userservice.fiegnClient.HotelService;
import com.userservice.model.User;
import com.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserToResponseMapper userMapper;
    private final HotelService hotelService;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        UserResponse userResponse = userRepository.findById(id).map(userMapper)
                .orElseThrow(() -> new UserNotFoundException("This user with id " + id + " doesn't exist"));

        userResponse.setRatings(hotelService.getRatings());
        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper)
                .collect(Collectors.toList());
    }
}
