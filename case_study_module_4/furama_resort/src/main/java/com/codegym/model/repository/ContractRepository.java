package com.codegym.model.repository;

import com.codegym.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, String> {
    @Query(value = "Select * from Contract where contract.contract_End_Date > current_date ", nativeQuery = true)
    Page<Contract> findAllByContractStartDate(Pageable pageable);
}
