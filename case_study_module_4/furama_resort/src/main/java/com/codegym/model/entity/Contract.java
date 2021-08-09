package com.codegym.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    private String contractId;

    @Column(name = "contract_start_date", columnDefinition = "Date")
    private String contractStartDate;

    @Column(name = "contract_end_date", columnDefinition = "Date")
    private String contractEndDate;
    private double contractDeposit;
    private double contractTotalMoney;

    @JsonIgnore
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_contract", referencedColumnName = "employeeId")
    private Employee employee;

    @JsonIgnore
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_contract", referencedColumnName = "customerId")
    private Customer customer;

    @JsonIgnore
    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_contract", referencedColumnName = "serviceId")
    private Service service;

    @JsonIgnore
    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetails;

    public Contract() {
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
