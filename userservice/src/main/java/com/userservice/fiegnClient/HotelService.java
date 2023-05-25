package com.userservice.fiegnClient;

import com.userservice.model.HotelResponse;
import com.userservice.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "rating-service",url="")
public interface HotelService {
    @GetMapping("/hotels/{id}")
    HotelResponse getHotelById(@PathVariable Long id);

    @GetMapping("/ratings")
    List<Rating> getRatings();
}
