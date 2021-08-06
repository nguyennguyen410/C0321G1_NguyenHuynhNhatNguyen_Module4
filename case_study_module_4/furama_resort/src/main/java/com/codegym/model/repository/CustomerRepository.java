package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query("SELECT e FROM Customer e WHERE e.customerStatus=0")
    Page<Customer> findAllByCustomerStatus(Pageable pageable);

    Page<Customer> findAllByCustomerNameContaining(String customerName, Pageable pageable);
    Page<Customer> findAllByCustomerType_CustomerTypeId(int customerTypeId, Pageable pageable);
}
