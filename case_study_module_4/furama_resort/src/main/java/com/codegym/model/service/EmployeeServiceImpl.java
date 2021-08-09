package com.codegym.model.service;

import com.codegym.model.entity.Employee;
import com.codegym.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAllByEmployeeStatus(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(String employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(String employeeName, Pageable pageable) {
        return employeeRepository.findAllByEmployeeNameContaining(employeeName, pageable);
    }
}
