package com.hotelservice.exception;

import com.hotelservice.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ApiResponse> hotelNotFound(HotelNotFoundException exception){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setError("HOTEL_NOT_FOUND");
        apiResponse.setMessage(exception.getMessage());

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
