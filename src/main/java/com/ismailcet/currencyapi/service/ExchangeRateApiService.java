package com.ismailcet.currencyapi.service;

import com.ismailcet.currencyapi.dto.ExchangeRateRequest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@Service
public class ExchangeRateApiService {

    private final Environment env;

    public ExchangeRateApiService(Environment env) {
        this.env = env;
    }

    @Cacheable(value = "Exchange")
    public String exchangeRateApi(ExchangeRateRequest exchangeRateRequest) throws IOException, InterruptedException {
        String target = exchangeRateRequest.getTarget().stream().map(String::toString).collect(Collectors.joining("%2C"));
        String uri = env.getProperty("SERVER.PATH")+"/live?source=" +exchangeRateRequest.getSource()+"&currencies=" + target;
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
