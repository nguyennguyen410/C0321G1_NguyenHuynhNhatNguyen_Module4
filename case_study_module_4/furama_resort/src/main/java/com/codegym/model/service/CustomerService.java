package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    void save(Customer customer);

    Optional<Customer> findById(String customerId);

    void delete(Customer customer);

    Page<Customer> findAllByNameContaining(String customerName, Pageable pageable);

    Page<Customer> findAllByCustomerType_CustomerTypeId(int customerTypeId, Pageable pageable);
}
