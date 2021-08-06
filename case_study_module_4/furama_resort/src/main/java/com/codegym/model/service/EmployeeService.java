package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Optional<Employee> findById(String employeeId);

    void delete(Employee employee);

    Page<Employee> findAllByEmployeeNameContaining(String employeeName, Pageable pageable);

    /*Page<Employee> findAllByCustomerType_CustomerTypeId(int customerTypeId, Pageable pageable);*/
}
