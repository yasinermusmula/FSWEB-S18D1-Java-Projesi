package com.example.s18d1.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BurgerExceptions extends RuntimeException{
    private HttpStatus status;
    public BurgerExceptions(String message, HttpStatus status) {
        super(message);
        this.status=status;
    }
}
