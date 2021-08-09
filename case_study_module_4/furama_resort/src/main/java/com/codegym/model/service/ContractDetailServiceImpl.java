package com.codegym.model.service;

import com.codegym.model.entity.ContractDetail;
import com.codegym.model.repository.ContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailServiceImpl implements ContractDetailService{
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}
