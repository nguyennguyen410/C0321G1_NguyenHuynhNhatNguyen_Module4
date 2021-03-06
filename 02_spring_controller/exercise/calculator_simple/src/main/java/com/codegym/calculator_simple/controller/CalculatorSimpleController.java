package com.codegym.calculator_simple.controller;

import com.codegym.calculator_simple.model.service.CalculatorSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CalculatorSimpleController {
    @Autowired
    CalculatorSimpleService calculatorSimpleService;

    @GetMapping("/index")
    public String displayIndex() {
        return "/index";
    }


    @GetMapping("/result")
    public String save(@RequestParam("firstParameter") float firstParameter,
                       @RequestParam("secondParameter") float secondParameter,
                       @RequestParam("operator") String operator,
                       Model model) {

        float result = calculatorSimpleService.calculator(firstParameter,secondParameter,operator);
        model.addAttribute("result", result);
        model.addAttribute("firstParameter", firstParameter);
        model.addAttribute("secondParameter", secondParameter);
        return "/result";
    }
}
