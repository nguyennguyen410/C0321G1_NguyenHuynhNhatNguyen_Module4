package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContractController {

    @GetMapping("/contract")
    public String showHomeContract(){
        return "/contract/homeContract";
    }
    @GetMapping("/createContract")
    public String showCreateContractForm(){
        return "/contract/createContract";
    }
}
