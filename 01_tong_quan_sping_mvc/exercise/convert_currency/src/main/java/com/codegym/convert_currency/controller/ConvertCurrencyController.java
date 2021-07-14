package com.codegym.convert_currency.controller;

import com.codegym.convert_currency.model.service.CurrencyConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrencyController {
    @Autowired
    CurrencyConvertService currencyConvertService;

    @PostMapping("/convert")
    public String convert(@RequestParam String usd, Model model) {
        float total = currencyConvertService.convert(Float.parseFloat(usd));
        model.addAttribute("total", total);
        model.addAttribute("usd", usd);
        return "/value";
    }
}
