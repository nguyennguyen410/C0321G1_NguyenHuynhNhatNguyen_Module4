package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/employee")
    public String showHomeEmployee(){
        return "/employee/homeEmployee";
    }

    @GetMapping("/createEmployee")
    public String showCreateEmployeeForm(){
        return "/employee/createEmployee";
    }
}
