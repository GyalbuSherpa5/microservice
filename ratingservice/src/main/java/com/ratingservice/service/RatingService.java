package com.ratingservice.service;

import com.ratingservice.model.Rating;

import java.util.List;

public interface RatingService {
    void saveRating(Rating rating);
    List<Rating> getAllRatings();

    List<Rating> getRatingsByUserId(String id);

    List<Rating> getRatingsByHotelId(String id);

}
