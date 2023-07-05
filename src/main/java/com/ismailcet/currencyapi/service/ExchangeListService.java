package com.ismailcet.currencyapi.service;

import com.ismailcet.currencyapi.config.UtilConfig;
import com.ismailcet.currencyapi.dto.ExchangeListRequest;
import com.ismailcet.currencyapi.exception.ExchangeException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpResponse;

@Service
public class ExchangeListService {

    private final Environment env;
    private final UtilConfig utilConfig;
    public ExchangeListService(Environment env, UtilConfig utilConfig) {
        this.env = env;
        this.utilConfig = utilConfig;
    }

    @Cacheable(value = "Exchange")
    public String exchangeList(ExchangeListRequest exchangeListRequest,String apikey) throws IOException, InterruptedException {
        String uri =
                env.getProperty("SERVER.PATH") + "/historical?date=" + exchangeListRequest.getDate();

        HttpResponse<String> response =
                utilConfig.createHttpRequest(uri, apikey);

        if (response.statusCode() == 200){
            return response.body();
        }
        throw new ExchangeException("ApiKey is Wrong or Not Exist ! ");
    }
}
