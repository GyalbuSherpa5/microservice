package com.hotelservice.controller;

import com.hotelservice.dto.HotelResponse;
import com.hotelservice.model.Hotel;
import com.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping("/hotels")
    public String createHotel(@RequestBody Hotel hotel){
        hotelService.createHotel(hotel);
        return "hotel created successfully";
    }

    @GetMapping("/hotels/{id}")
    public HotelResponse getHotelById(@PathVariable Long id){
        return hotelService.getHotelById(id);
    }

    @GetMapping("/hotels")
    public List<HotelResponse> getAllHotels(){
        return hotelService.getAllHotels();
    }
}
