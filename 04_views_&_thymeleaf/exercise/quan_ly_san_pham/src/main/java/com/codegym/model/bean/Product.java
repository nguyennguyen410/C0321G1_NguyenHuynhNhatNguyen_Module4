package com.codegym.model.bean;

public class Product {
    private int id;
    private String name;
    private double price;
    private String detail;
    private String manufacturing;

    public Product() {
    }

    public Product(int id, String name, double price, String detail, String manufacturing) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.manufacturing = manufacturing;
    }

    public Product(String name, double price, String detail, String manufacturing) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.manufacturing = manufacturing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getManufacturing() {
        return manufacturing;
    }

    public void setManufacturing(String manufacturing) {
        this.manufacturing = manufacturing;
    }
}
