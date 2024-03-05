package com.example.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(BurgerExceptions.class)
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerExceptions burgerExceptions){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(burgerExceptions.getStatus().value(),
                burgerExceptions.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(burgerErrorResponse,burgerExceptions.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception){
        BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(burgerErrorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
