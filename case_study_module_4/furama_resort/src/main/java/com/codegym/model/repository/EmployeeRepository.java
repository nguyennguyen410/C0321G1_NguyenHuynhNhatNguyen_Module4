package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("SELECT e FROM Employee e WHERE e.employeeStatus=0")
    Page<Employee> findAllByEmployeeStatus(Pageable pageable);
    public Page<Employee> findAllByEmployeeNameContaining(String employeeName, Pageable pageable);
}
