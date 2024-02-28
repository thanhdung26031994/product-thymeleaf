package org.example.productthymeleaf.model;

public class Product {
    private Integer id;
    private String name;
    private Float price;
    private String describe;
    private String address;

    public Product() {
    }

    public Product(Integer id, String name, Float price, String describe, String address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
