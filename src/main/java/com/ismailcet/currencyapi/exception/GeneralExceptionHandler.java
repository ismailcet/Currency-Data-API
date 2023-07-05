package com.ismailcet.currencyapi.exception;

import com.ismailcet.currencyapi.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(ExchangeException.class)
    public ResponseEntity<Object> handlerUserNotFoundException(ExchangeException ex){
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());

        ExceptionResponse response = new ExceptionResponse(
                        LocalDateTime.now(),
                        HttpStatus.UNAUTHORIZED,
                        "ApiKey is Wrong or Not Exist ! ",
                        details);

        return new ResponseEntity<>(response, response.getStatus());
    }
}
