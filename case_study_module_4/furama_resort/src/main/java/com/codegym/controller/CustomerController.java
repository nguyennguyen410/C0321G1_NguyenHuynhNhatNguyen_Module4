package com.codegym.controller;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.Customer;
import com.codegym.model.dto.CustomerDto;
import com.codegym.model.entity.CustomerType;
import com.codegym.model.entity.Gender;
import com.codegym.model.service.ContractService;
import com.codegym.model.service.CustomerService;
import com.codegym.model.service.CustomerTypeService;
import com.codegym.model.service.GenderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @Autowired
    GenderService genderService;

    @Autowired
    ContractService contractService;


    @GetMapping({"/", "/home"})
    public String showIndex(){
        return "index";
    }
    @GetMapping("/customer")
    public ModelAndView showHomeCustomer(@PageableDefault(value = 2) Pageable pageable){
        Page<Customer> customers = customerService.findAll(pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/customer/homeCustomer");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/createCustomer")
    public String showCreateCustomerForm(Model model){
        model.addAttribute("customerDto",new CustomerDto());
        List<CustomerType> customerType = customerTypeService.findAll();
        List<Gender> genders = genderService.findAll();
        model.addAttribute("customerTypeList", customerType);
        model.addAttribute("gender", genders);
        return "/customer/createCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model,
                               RedirectAttributes redirect){
        new CustomerDto().validate(customerDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customerDto", customerDto);
            List<CustomerType> customerType = customerTypeService.findAll();
            List<Gender> genders = genderService.findAll();
            model.addAttribute("customerTypeList", customerType);
            model.addAttribute("gender", genders);
            return "/customer/createCustomer";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customer.setCustomerStatus(0);
            customerService.save(customer);
            redirect.addFlashAttribute("success", "Create customer successfully!");
            return "redirect:/customer";
        }

    }

    @GetMapping("/editCustomer/{customerId}")
    public String showEditForm(@PathVariable String customerId,
                               Model model){
        model.addAttribute("customer", customerService.findById(customerId));
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        List<Gender> genders = genderService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("gender", genders);
        return "/customer/editCustomer";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam String customerIdDelete, Model model){
        Optional<Customer> customer = customerService.findById(customerIdDelete);
        customer.get().setCustomerStatus(1);
        customerService.save(customer.get());
        model.addAttribute("success", "Delete customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public ModelAndView searchCustomer(@PageableDefault(value = 2) Pageable pageable,
                                 @RequestParam String searchName){
        /*Page<Customer> customers = customerService.findAllByNameContaining(searchName, pageable);*/
        Page<Customer> customers = customerService.searchByNameOrId(searchName, pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/customer/homeCustomer");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/customerUsingService")
    public ModelAndView usingServiceCustomer(@PageableDefault(value = 2) Pageable pageable){
        Page<Contract> contracts = contractService.findAllByContractStartDate(pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/customer/usingServiceCustomer");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }
}
