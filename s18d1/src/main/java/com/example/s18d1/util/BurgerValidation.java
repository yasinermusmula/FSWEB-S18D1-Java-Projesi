package com.example.s18d1.util;

import com.example.s18d1.exceptions.BurgerExceptions;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static final String BURGER_NAME_NOT_VALID= "Burger name can't be null or empty";
    public static void isNameExist(String name){
        if (name == null || name.isEmpty()){
            throw new BurgerExceptions(BURGER_NAME_NOT_VALID, HttpStatus.BAD_REQUEST);
        }
    }
}
