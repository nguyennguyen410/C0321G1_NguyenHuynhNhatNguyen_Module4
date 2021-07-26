package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserDto implements Validator {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        int age = userDto.getAge();
        String email = userDto.getEmail();
        String phoneNumber = userDto.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
        if (!firstName.matches("(^[a-zA-z]{5,45}$)")){
            errors.rejectValue("firstName", "firstName.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");
        if (!lastName.matches("(^[a-zA-Z]{5,45}$)")){
            errors.rejectValue("lastName", "lastName.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");
        if (age<18){
            errors.rejectValue("age", "age.error");
        }
        ValidationUtils.rejectIfEmpty(errors, "email", "email.empty");
        if (!email.matches("(^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$)")){
            errors.rejectValue("email", "email.matches");
        }
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (!phoneNumber.matches("(^[0-9]{10}$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
    }
}
