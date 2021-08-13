package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(String customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String customerName, Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(customerName, pageable);
    }

    @Override
    public Page<Customer> searchByNameOrId(String customerNameOrId, Pageable pageable) {
        return customerRepository.searchByNameOrId(customerNameOrId,pageable);
    }

    @Override
    public Page<Customer> findAllByCustomerType_CustomerTypeId(int customerTypeId, Pageable pageable) {
        return customerRepository.findAllByCustomerType_CustomerTypeId(customerTypeId, pageable);
    }
}
