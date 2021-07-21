package com.codegym.model.service;

import com.codegym.model.bean.Customer;

import java.util.List;

public interface IGeneralService<Customer> {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
