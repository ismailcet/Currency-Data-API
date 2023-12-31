package com.ismailcet.currencyapi.service;

import com.ismailcet.currencyapi.config.UtilConfig;
import com.ismailcet.currencyapi.dto.ExchangeRateRequest;
import com.ismailcet.currencyapi.exception.ExchangeException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExchangeRateApiService {

    private final Environment env;
    private final UtilConfig utilConfig;

    public ExchangeRateApiService(Environment env, UtilConfig utilConfig) {
        this.env = env;
        this.utilConfig = utilConfig;
    }

    @Cacheable(value = "Exchange")
    public String exchangeRateApi(ExchangeRateRequest exchangeRateRequest, String apikey) throws IOException, InterruptedException {
        String target = utilConfig.listToString(exchangeRateRequest.getTarget());

        String uri = env.getProperty("SERVER.PATH")+"/live?source=" +exchangeRateRequest.getSource()+"&currencies=" + target;

        HttpResponse<String> response =
                utilConfig.createHttpRequest(uri, apikey);

        if (response.statusCode() == 200){
            return response.body();
        }
        throw new ExchangeException("ApiKey is Wrong or Not Exist ! ");
    }


}
