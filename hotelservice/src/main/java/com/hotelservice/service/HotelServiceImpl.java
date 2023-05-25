package com.hotelservice.service;

import com.hotelservice.dto.HotelResponse;
import com.hotelservice.dto.HotelResponseMapper;
import com.hotelservice.exception.HotelNotFoundException;
import com.hotelservice.model.Hotel;
import com.hotelservice.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelResponseMapper hotelResponseMapper;

    @Override
    public void createHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public HotelResponse getHotelById(Long id) {
        return hotelRepository.findById(id)
                .map(hotelResponseMapper)
                .orElseThrow(() -> new HotelNotFoundException("Hotel with id " + id + " doesn't exist"));
    }

    @Override
    public List<HotelResponse> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(hotelResponseMapper)
                .collect(Collectors.toList());
    }


}
