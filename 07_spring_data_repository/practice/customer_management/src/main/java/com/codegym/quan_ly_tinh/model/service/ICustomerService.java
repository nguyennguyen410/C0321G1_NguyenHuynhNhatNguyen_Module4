package com.codegym.quan_ly_tinh.model.service;

import com.codegym.quan_ly_tinh.model.bean.Customer;
import com.codegym.quan_ly_tinh.model.bean.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
