package com.codegym.controller;

import com.codegym.model.dto.ContractDetailDto;
import com.codegym.model.dto.ContractDto;
import com.codegym.model.dto.EmployeeDto;
import com.codegym.model.entity.*;
import com.codegym.model.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;

    @GetMapping("/contract")
    public ModelAndView showHomeContract(@PageableDefault(value = 2) Pageable pageable){
        Page<Contract> contracts = contractService.findAll(pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/contract/homeContract");
        modelAndView.addObject("contracts", contracts);
        return modelAndView;
    }
    @GetMapping("/createContract")
    public String showCreateContractForm(Model model){
        model.addAttribute("contractDto",new ContractDto());
        List<Employee> employees = employeeService.findAll();
        List<Customer> customers = customerService.findAll();
        List<Service> services = serviceService.findAll();
        model.addAttribute("employee", employees);
        model.addAttribute("customerList", customers);
        model.addAttribute("serviceList", services);
        return "/contract/createContract";
    }

    @PostMapping("/saveContract")
    public String saveEmployee(@ModelAttribute ContractDto contractDto, RedirectAttributes redirect){
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        redirect.addFlashAttribute("success", "Create customer successfully!");
        return "redirect:/contract";
    }

    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    AttachServiceService attachServiceService;

    @GetMapping("/contractDetail")
    public ModelAndView showHomeContractDetail(@PageableDefault(value = 2) Pageable pageable){
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/contract_detail/homeContractDetail");
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }
    @GetMapping("/createContractDetail")
    public String showCreateServiceForm(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        List<Contract> contracts = contractService.findAll();
        List<AttachService> attachServices = attachServiceService.findAll();
        model.addAttribute("contractList", contracts);
        model.addAttribute("attachServiceList", attachServices);
        return "/contract_detail/createContractDetail";
    }

    @PostMapping("/saveContractDetail")
    public String saveService(@ModelAttribute ContractDetailDto contractDetailDto){
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.save(contractDetail);
        return "redirect:/contractDetail";
    }
}
