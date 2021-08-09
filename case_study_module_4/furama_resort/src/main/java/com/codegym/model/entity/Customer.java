package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String customerId;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "Date")
    private String customerBirthday;

    @ManyToOne(targetEntity = Gender.class)
    @JoinColumn(name = "customer_gender", referencedColumnName = "genderId")
    private Gender customerGender;

    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    private int customerStatus;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contract;


    public Customer() {
    }

    public Customer(String customerId, CustomerType customerType, String customerName, String customerBirthday,
                    Gender customerGender, String customerIdCard, String customerPhone, String customerEmail,
                    String customerAddress, int customerStatus) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerStatus = customerStatus;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Gender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Gender customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(int customerStatus) {
        this.customerStatus = customerStatus;
    }

    public List<Contract> getContract() {
        return contract;
    }

    public void setContract(List<Contract> contract) {
        this.contract = contract;
    }
}
