package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
