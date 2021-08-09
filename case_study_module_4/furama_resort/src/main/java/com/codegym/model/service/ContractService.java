package com.codegym.model.service;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    List<Contract> findAll();

    void save(Contract contract);

    Optional<Contract> findById(String id);

    Page<Contract> findAllByContractStartDate(Pageable pageable);
}
