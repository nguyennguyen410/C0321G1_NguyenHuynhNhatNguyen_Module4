package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
import com.codegym.model.dto.ServiceDto;
import com.codegym.model.entity.*;
import com.codegym.model.service.RentTypeService;
import com.codegym.model.service.ServiceService;
import com.codegym.model.service.ServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping("/service")
    public ModelAndView showHomeService(@PageableDefault(value = 2) Pageable pageable){
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/service/homeService");
        modelAndView.addObject("services", services);
        return modelAndView;
    }
    @GetMapping("/createService")
    public String showCreateServiceForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        List<ServiceType> serviceTypes = serviceTypeService.findAll();
        List<RentType> rentTypes = rentTypeService.findAll();
        model.addAttribute("serviceTypeList", serviceTypes);
        model.addAttribute("rentTypeList", rentTypes);
        return "/service/createService";
    }

    @PostMapping("/saveService")
    public String saveService(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult, Model model,
                              RedirectAttributes redirect){
        new ServiceDto().validate(serviceDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("serviceDto", serviceDto);
            List<ServiceType> serviceTypes = serviceTypeService.findAll();
            List<RentType> rentTypes = rentTypeService.findAll();
            model.addAttribute("serviceTypeList", serviceTypes);
            model.addAttribute("rentTypeList", rentTypes);
            return "/service/createService";
        }else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/service";
        }

    }
}
