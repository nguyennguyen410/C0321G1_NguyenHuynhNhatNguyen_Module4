package com.codegym.model.service;

import com.codegym.model.bean.Customer;

public interface ICustomerService extends IGeneralService<Customer>{
    boolean insertWithStoredProcedure(Customer customer);
}
