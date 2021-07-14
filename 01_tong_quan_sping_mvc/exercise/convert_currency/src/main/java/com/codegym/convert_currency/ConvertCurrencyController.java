package com.codegym.convert_currency;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrencyController {
    @PostMapping("/convert")
    public String convert(@RequestParam String usd, Model model) {
        float rate = 23000;
        float total = Float.parseFloat(usd) * rate;
        model.addAttribute("total", total);
        model.addAttribute("usd", usd);
        return "/value";
    }
}
