package com.ismailcet.currencyapi.controller;

import com.ismailcet.currencyapi.dto.ExchangeRateRequest;
import com.ismailcet.currencyapi.service.ExchangeRateApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/rate")
public class ExchangeRateApiController {
    private final ExchangeRateApiService exchangeRateApiService;

    public ExchangeRateApiController(ExchangeRateApiService exchangeRateApiService) {
        this.exchangeRateApiService = exchangeRateApiService;
    }

    @PostMapping()
    public ResponseEntity<String> exchangeRateApi(@RequestBody ExchangeRateRequest exchangeRateRequest) throws IOException, InterruptedException {
        return ResponseEntity.ok(
                exchangeRateApiService.exchangeRateApi(exchangeRateRequest)
        );
    }
}

