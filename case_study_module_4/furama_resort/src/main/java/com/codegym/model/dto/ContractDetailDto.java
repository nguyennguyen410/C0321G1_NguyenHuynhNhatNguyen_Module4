package com.codegym.model.dto;

import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Contract;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ContractDetailDto {
    private String contractDetailId;
    private Contract contract;
    private AttachService attachService;
    private int quantity;
    private double totalMoney;

    public ContractDetailDto() {
    }

    public String getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(String contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
