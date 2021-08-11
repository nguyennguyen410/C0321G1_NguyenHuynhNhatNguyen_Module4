package com.codegym.model.dto;

import com.codegym.model.entity.CustomerType;
import com.codegym.model.entity.Gender;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

public class CustomerDto implements Validator {
    private String customerId;
    private CustomerType customerType;

    @NotEmpty(message = "Input please!!!")
    private String customerName;

    private String customerBirthday;
    private Gender customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;

    @NotEmpty(message = "Input please!!!")
    private String customerAddress;

    public CustomerDto() {
    }

    public CustomerDto(String customerId, CustomerType customerType, String customerName, String customerBirthday,
                       Gender customerGender, String customerIdCard, String customerPhone, String customerEmail,
                       String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
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

    public Gender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Gender customerGender) {
        this.customerGender = customerGender;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String customerId = customerDto.getCustomerId();
        String customerPhone = customerDto.getCustomerPhone();
        String customerIdCard = customerDto.getCustomerIdCard();
        String customerEmail = customerDto.getCustomerEmail();
        ValidationUtils.rejectIfEmpty(errors, "customerId", "customerId.empty");
        if (!customerId.matches("(^[K][H][-]([0-9]{4})$)")){
            errors.rejectValue("customerId", "customerId.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "customerPhone", "customerPhone.empty");
        if (!customerPhone.matches("(^\\([0-9]{2}\\)-[0-9]{9}$)")){
            errors.rejectValue("customerPhone", "customerPhone.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "customerIdCard", "customerIdCard.empty");
        if (!customerIdCard.matches("(^[0-9]{9}$)")){
            errors.rejectValue("customerIdCard", "customerIdCard.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "customerEmail", "customerEmail.empty");
        if (!customerEmail.matches("(^[a-z][a-zA-Z0-9\\.\\_]*+\\@[a-z0-9A-Z]+(\\.[a-z]{2,})+$)")){
            errors.rejectValue("customerEmail", "customerEmail.matches");
        }
    }
}
