package com.ismailcet.currencyapi.dto;

import java.util.List;

public class ExchangeApiRequest {
    private String endDate;
    private String startDate;
    private List<String> currencies;
    private String source;

    public ExchangeApiRequest() {
    }

    public ExchangeApiRequest(String endDate, String startDate, List<String> currencies, String source) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.currencies = currencies;
        this.source = source;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<String> currencies) {
        this.currencies = currencies;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return "ExchangeApiRequest{" +
                "endDate='" + endDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", currencies=" + currencies +
                ", source='" + source + '\'' +
                '}';
    }
}
