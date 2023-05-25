package com.ratingservice.controller;

import com.ratingservice.model.Rating;
import com.ratingservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/ratings")
    public String createRating(@RequestBody Rating rating){
        ratingService.saveRating(rating);
        return "rating saved";
    }

    @GetMapping("/ratings")
    public List<Rating> getRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("/ratings/user/{user_id}")
    public List<Rating> getRatingByUserId(@PathVariable("user_id") String id){
        return ratingService.getRatingsByUserId(id);
    }

    @GetMapping("/ratings/hotel/{hotel_id}")
    public List<Rating> getRatingByHotelId(@PathVariable("hotel_id") String id){
        return ratingService.getRatingsByHotelId(id);
    }
}
