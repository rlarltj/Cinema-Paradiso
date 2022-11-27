package com.prgrms.movieprj.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeExceptionHandler(RuntimeException e) {

        Map body = Map.of(
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "status", HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity(body, HttpStatus.BAD_REQUEST);
    }
}
