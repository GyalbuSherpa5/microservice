package com.userservice.dto;

import com.userservice.model.Rating;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private String name;
    private String email;
    private String about;
    private List<Rating> ratings;
}
