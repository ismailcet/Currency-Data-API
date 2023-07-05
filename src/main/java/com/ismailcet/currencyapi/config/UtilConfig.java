package com.ismailcet.currencyapi.config;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UtilConfig {
    public HttpResponse<String> createHttpRequest(String uri, String apikey) throws IOException, InterruptedException {
        HttpClient client =
                HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uri))
                .headers("apikey",apikey)
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public String listToString(List<String> target) {
        return target.stream()
                .map(String::toString)
                .collect(Collectors.joining("%2C"));
    }
}
