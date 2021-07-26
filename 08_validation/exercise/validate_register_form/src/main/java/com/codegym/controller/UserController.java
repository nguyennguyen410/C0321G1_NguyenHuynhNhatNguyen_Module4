package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.entity.User;
import com.codegym.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("userDto",new UserDto());
        return "/create";
    }

    @PostMapping("/save")
    public String checkValidation(@Valid @ModelAttribute UserDto userDto,
                     BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("userDto", userDto);
            return "/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userService.save(user);
            return "/result";
        }

    }
}
