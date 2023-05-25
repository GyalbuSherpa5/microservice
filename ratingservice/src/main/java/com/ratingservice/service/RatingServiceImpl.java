package com.ratingservice.service;

import com.ratingservice.model.Rating;
import com.ratingservice.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{
    private final RatingRepository ratingRepository;

    @Override
    public void saveRating(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String id) {
        return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String id) {
        return ratingRepository.findByHotelId(id);
    }
}
