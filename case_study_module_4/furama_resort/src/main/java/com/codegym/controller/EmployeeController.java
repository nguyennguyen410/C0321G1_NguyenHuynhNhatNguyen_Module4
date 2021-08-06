package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    UserService userService;

    @GetMapping("/employee")
    public ModelAndView showHomeEmployee(@PageableDefault(value = 2) Pageable pageable){
        Page<Employee> employees = employeeService.findAll(pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/employee/homeEmployee");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/createEmployee")
    public String showCreateEmployeeForm(Model model){
        model.addAttribute("employeeDto",new EmployeeDto());
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("position", positions);
        model.addAttribute("educationDegree", educationDegrees);
        model.addAttribute("division", divisions);
        return "/employee/createEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute EmployeeDto employeeDto, RedirectAttributes redirect){
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setUsername(userService.findByUsername(employeeDto.getUsername()).get());
        employeeService.save(employee);
        redirect.addFlashAttribute("success", "Create customer successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/editEmployee/{employeeId}")
    public String showEditForm(@PathVariable String employeeId,
                               Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(employeeId).get(), employeeDto);
        employeeDto.setUsername(employeeService.findById(employeeId).get().getUsername().getUsername());
        model.addAttribute("employeeDto", employeeDto);
        List<Position> positions = positionService.findAll();
        List<EducationDegree> educationDegrees = educationDegreeService.findAll();
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("position", positions);
        model.addAttribute("educationDegree", educationDegrees);
        model.addAttribute("division", divisions);
        return "/employee/editEmployee";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam String employeeIdDelete){
        Optional<Employee> employee = employeeService.findById(employeeIdDelete);
        employee.get().setEmployeeStatus(1);
        employeeService.save(employee.get());
        return "redirect:/employee";
    }

    @GetMapping("/searchEmployee")
    public ModelAndView searchEmployee(@PageableDefault(value = 2) Pageable pageable,
                                       @RequestParam String searchName){
        Page<Employee> employees = employeeService.findAllByEmployeeNameContaining(searchName, pageable);
        ModelAndView modelAndView = null;
        modelAndView = new ModelAndView("/employee/homeEmployee");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}
