package com.challenge.meli.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e){
        Map<String, String> error = new HashMap<>();
        error.put("error", "Product not found");
        error.put("status", HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleException(Exception e){
        Map<String, String> error = new HashMap<>();
        error.put("message", "Error processing request, please contact support");
        error.put("cause", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.name());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> ArumentException(Exception e){
        Map<String, String> error = new HashMap<>();
        error.put("message", "Error processing request, please contact support");
        error.put("cause", e.getMessage());
        error.put("status", HttpStatus.BAD_REQUEST.name());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
