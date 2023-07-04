package com.ismailcet.currencyapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping()
    public String demo() throws IOException, InterruptedException {

        String uri = "https://api.apilayer.com/currency_data/historical?date=2023-07-03&source=TRY";
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .headers("apikey", "z1XEd2LDyNx5h99uGNnVCmRFFKujD62D")
                .build();

        HttpResponse<String> response =client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
