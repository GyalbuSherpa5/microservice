package com.hotelservice.dto;

import com.hotelservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class HotelResponseMapper implements Function<Hotel,HotelResponse> {
    @Override
    public HotelResponse apply(Hotel hotel) {
        return new HotelResponse(
                hotel.getName(),
                hotel.getAbout(),
                hotel.getLocation()
        );
    }
}
