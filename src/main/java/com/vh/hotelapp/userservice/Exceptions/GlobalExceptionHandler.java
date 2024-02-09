package com.vh.hotelapp.userservice.Exceptions;

import com.vh.hotelapp.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){

      String message =   ex.getMessage();
      ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);

    }

}
