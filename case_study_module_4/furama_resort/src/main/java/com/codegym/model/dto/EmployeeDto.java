package com.codegym.model.dto;

import com.codegym.model.entity.Division;
import com.codegym.model.entity.EducationDegree;
import com.codegym.model.entity.Position;
import com.codegym.model.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto implements Validator {
    @NotEmpty(message = "Input please!!!")
    private String employeeId;

    @NotEmpty(message = "Input please!!!")
    private String employeeName;

    private String employeeBirthday;

    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;

    @NotEmpty(message = "Input please!!!")
    private String employeeAddress;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    @NotEmpty(message = "Input please!!!")
    private String username;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeId, String employeeName, String employeeBirthday, String employeeIdCard,
                       double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress,
                       Position position, EducationDegree educationDegree, Division division, String username) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.username = username;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        String employeeIdCard = employeeDto.getEmployeeIdCard();
        double employeeSalary = employeeDto.getEmployeeSalary();
        String employeePhone = employeeDto.getEmployeePhone();
        String employeeEmail = employeeDto.getEmployeeEmail();

        ValidationUtils.rejectIfEmpty(errors, "employeePhone", "employeePhone.empty");
        if (!employeePhone.matches("(^\\([0-9]{2}\\)-[0-9]{9}$)")){
            errors.rejectValue("employeePhone", "employeePhone.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "employeeIdCard", "employeeIdCard.empty");
        if (!employeeIdCard.matches("(^[0-9]{9}$)")){
            errors.rejectValue("employeeIdCard", "employeeIdCard.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "employeeEmail", "employeeEmail.empty");
        if (!employeeEmail.matches("(^[a-z][a-zA-Z0-9\\.\\_]*+\\@[a-z0-9A-Z]+(\\.[a-z]{2,})+$)")){
            errors.rejectValue("employeeEmail", "employeeEmail.matches");
        }

        ValidationUtils.rejectIfEmpty(errors, "employeeSalary", "employeeSalary.matches");
        if (employeeSalary<=0){
            errors.rejectValue("employeeSalary", "employeeSalary.matches");
        }

    }
}

