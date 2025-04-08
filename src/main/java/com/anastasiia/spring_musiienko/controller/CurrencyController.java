package com.anastasiia.spring_musiienko.controller;

import com.anastasiia.spring_musiienko.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/get-dollar-rate")
    public String getDollarRate() {
        return currencyService.getDollarExchangeRate();
    }
}

