package com.anastasiia.spring_musiienko.service;

import com.anastasiia.spring_musiienko.model.ExchangeRate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDollarExchangeRate() {
        String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";

        ResponseEntity<ExchangeRate[]> response = restTemplate.getForEntity(url, ExchangeRate[].class);

        if (response.getBody() != null) {
            for (ExchangeRate rate : response.getBody()) {
                if ("USD".equals(rate.getCcy())) {
                    return "Current USD rate: " + rate.getBuy() + " UAH";
                }
            }
        }

        return "It was not possible to get the dollar rate.";
    }
}
