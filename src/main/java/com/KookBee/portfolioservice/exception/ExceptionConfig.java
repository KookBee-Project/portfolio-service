package com.KookBee.portfolioservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(ProjectCodeCheckException.class)
    public ResponseEntity<String> loginException(ProjectCodeCheckException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProjectUserCheckException.class)
    public ResponseEntity<String> loginException(ProjectUserCheckException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ProjectJoinStatusCheckException.class)
    public ResponseEntity<String> loginException(ProjectJoinStatusCheckException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
