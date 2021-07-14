package com.codegym.convert_currency.model.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertServiceImpl implements CurrencyConvertService{
    @Override
    public float convert(float usd) {
        float total= 23000 * usd;
        return total;
    }
}
