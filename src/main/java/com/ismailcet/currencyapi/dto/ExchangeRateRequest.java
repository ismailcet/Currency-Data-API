package com.ismailcet.currencyapi.dto;

import java.util.List;

public class ExchangeRateRequest {
    private String source;

    private List<String> target;

    public ExchangeRateRequest() {
    }

    public ExchangeRateRequest(String source, List<String> target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getTarget() {
        return target;
    }

    public void setTarget(List<String> target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "ExchangeRateRequest{" +
                "source='" + source + '\'' +
                ", target=" + target +
                '}';
    }
}
