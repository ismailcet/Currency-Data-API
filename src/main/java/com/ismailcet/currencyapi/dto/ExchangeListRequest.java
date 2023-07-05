package com.ismailcet.currencyapi.dto;

public class ExchangeListRequest {

    private String date;

    public ExchangeListRequest() {
    }

    public ExchangeListRequest(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ExchangeListRequest{" +
                "date='" + date + '\'' +
                '}';
    }
}
