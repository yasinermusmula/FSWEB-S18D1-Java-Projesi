package com.example.s18d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BurgerErrorResponse {
    private int status;
    private String message;
    private LocalDateTime localDateTime;
}
