package com.codegym.quan_ly_tinh.model.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<Customer> {
    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
