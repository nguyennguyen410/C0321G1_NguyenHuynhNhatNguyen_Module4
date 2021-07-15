package com.codegym.spices_for_sandwich.controller;

import com.codegym.spices_for_sandwich.model.service.SpicesSandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SpicesSandwichController {
    @Autowired
    SpicesSandwichService spicesSandwichService;

    @GetMapping("/index")
    public String displayIndex() {
        return "/index";
    }

    @GetMapping("/save")
    public String save(@RequestParam("spices") String[] spices, Model model) {
        List<String> list = spicesSandwichService.displaySpices(spices);
        model.addAttribute("list", list);
        return "/display";
    }
}
