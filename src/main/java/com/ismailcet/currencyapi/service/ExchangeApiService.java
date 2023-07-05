package com.ismailcet.currencyapi.service;

import com.ismailcet.currencyapi.config.UtilConfig;
import com.ismailcet.currencyapi.dto.ExchangeApiRequest;
import com.ismailcet.currencyapi.exception.ExchangeException;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.stream.Collectors;

@Service
public class ExchangeApiService {

    private final Environment env;
    private final UtilConfig utilConfig;

    public ExchangeApiService(Environment env, UtilConfig utilConfig) {
        this.env = env;
        this.utilConfig = utilConfig;
    }


    public String change(ExchangeApiRequest exchangeApiRequest, String apikey) throws IOException, InterruptedException {
        String target = utilConfig.listToString(exchangeApiRequest.getCurrencies());
        String uri =
                env.getProperty("SERVER.PATH") +
                        "/change?start_date=" + exchangeApiRequest.getStartDate() +
                        "&end_date="+exchangeApiRequest.getEndDate()+"&source="+exchangeApiRequest.getSource()+"&currencies="+target;

        //"https://api.apilayer.com/currency_data/change?start_date=2023-05-03&end_date=2023-05-04"

        HttpResponse<String> response =
                utilConfig.createHttpRequest(uri, apikey);
        if (response.statusCode() == 200){
            return response.body();
        }
        throw new ExchangeException("ApiKey is Wrong or Not Exist ! ");
    }
}
