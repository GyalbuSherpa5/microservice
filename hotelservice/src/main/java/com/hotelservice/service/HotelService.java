package com.hotelservice.service;

import com.hotelservice.dto.HotelResponse;
import com.hotelservice.model.Hotel;

import java.util.List;

public interface HotelService {
    void createHotel(Hotel hotel);

    HotelResponse getHotelById(Long id);

    List<HotelResponse> getAllHotels();
}
