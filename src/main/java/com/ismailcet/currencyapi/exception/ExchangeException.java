package com.ismailcet.currencyapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExchangeException extends RuntimeException{
    public ExchangeException(String message) {
        super(message);
    }
}
