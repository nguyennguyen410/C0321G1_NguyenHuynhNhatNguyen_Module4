package com.codegym.email_settings.controller;

import com.codegym.email_settings.model.bean.Email;
import com.codegym.email_settings.model.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
    /*String[] languagesArray = {"English", "Viet Nam"};*/
    @Autowired
    EmailService emailService;
    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index", "email", emailService.setEmailDefault());
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView editSetting(@ModelAttribute("email") Email email) {
        Email emailEdited = emailService.editSettings(email);
        ModelAndView modelAndView = new ModelAndView("email-edited");
        modelAndView.addObject("emailEdited", emailEdited);
        return modelAndView;
    }

}
