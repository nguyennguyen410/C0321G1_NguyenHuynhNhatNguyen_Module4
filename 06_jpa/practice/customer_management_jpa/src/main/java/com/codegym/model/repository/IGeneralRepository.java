package com.codegym.model.repository;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface IGeneralRepository<Customer> {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
