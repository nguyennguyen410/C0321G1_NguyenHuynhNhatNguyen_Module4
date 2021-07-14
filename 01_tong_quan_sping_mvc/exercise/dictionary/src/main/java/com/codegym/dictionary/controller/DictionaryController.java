package com.codegym.dictionary.controller;

import com.codegym.dictionary.model.service.DictionaryService;
import com.codegym.dictionary.model.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping("/translate")
    public String translate(@RequestParam String input, Model model) {
        Map<String, String> list = dictionaryService.findAll();
        String result = list.get(input);
        if(result!=null){
            model.addAttribute("result", result);
            model.addAttribute("input", input);
        } else {
            model.addAttribute("input", input);
            model.addAttribute("result", "Not Found");
        }
        /*model.addAttribute("total", total);
        model.addAttribute("usd", usd);*/
        return "/value";
    }
}
