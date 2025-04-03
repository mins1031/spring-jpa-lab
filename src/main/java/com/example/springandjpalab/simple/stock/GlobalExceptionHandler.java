package com.example.springandjpalab.simple.stock;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public void Exception(Exception e) {
        System.out.println(e.getClass() + ": " + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
    }
}
