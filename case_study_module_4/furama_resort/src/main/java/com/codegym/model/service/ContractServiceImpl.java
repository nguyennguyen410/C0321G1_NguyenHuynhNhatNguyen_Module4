package com.codegym.model.service;

import com.codegym.model.entity.Contract;
import com.codegym.model.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(String id) {
        return contractRepository.findById(id);
    }

    @Override
    public Page<Contract> findAllByContractStartDate(Pageable pageable) {
        return contractRepository.findAllByContractStartDate(pageable);
    }
}
