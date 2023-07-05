package com.ismailcet.currencyapi.controller;

import com.ismailcet.currencyapi.dto.ExchangeApiRequest;
import com.ismailcet.currencyapi.service.ExchangeApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/change")
public class ExchangeApiController {
    private final ExchangeApiService exchangeApiService ;

    public ExchangeApiController(ExchangeApiService exchangeApiService) {
        this.exchangeApiService = exchangeApiService;
    }

    @PostMapping()
    public ResponseEntity<String> change(@RequestBody ExchangeApiRequest exchangeApiRequest, @RequestHeader String apikey) throws IOException, InterruptedException {
        return ResponseEntity.ok(
                exchangeApiService.change(exchangeApiRequest, apikey)
        );
    }
}
