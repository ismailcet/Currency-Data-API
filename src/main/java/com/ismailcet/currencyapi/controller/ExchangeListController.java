package com.ismailcet.currencyapi.controller;

import com.ismailcet.currencyapi.dto.ExchangeListRequest;
import com.ismailcet.currencyapi.service.ExchangeListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/list")
public class ExchangeListController {
    private final ExchangeListService exchangeListService;

    public ExchangeListController(ExchangeListService exchangeListService) {
        this.exchangeListService = exchangeListService;
    }

    @PostMapping()
    public ResponseEntity<String> exchangeList(@RequestBody ExchangeListRequest exchangeListRequest, @RequestHeader String apikey) throws IOException, InterruptedException {
        System.out.println(apikey);
        return ResponseEntity.ok(
          exchangeListService.exchangeList(exchangeListRequest, apikey)
        );
    }
}
