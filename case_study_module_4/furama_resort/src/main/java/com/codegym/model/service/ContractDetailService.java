package com.codegym.model.service;

import com.codegym.model.entity.Contract;
import com.codegym.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);

    void save(ContractDetail contractDetail);
}
