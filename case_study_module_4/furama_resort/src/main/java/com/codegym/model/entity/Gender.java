package com.codegym.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genderId;
    private String genderName;

    @OneToMany(mappedBy = "customerGender")
    private List<Customer> customers;

    public Gender() {
    }

    public Gender(int genderId, String genderName, List<Customer> customers) {
        this.genderId = genderId;
        this.genderName = genderName;
        this.customers = customers;
    }

    public int getGenderId() {
        return genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
