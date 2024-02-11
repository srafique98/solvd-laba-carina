package com.solvd.carinaexample.api.assignment.domain;

import java.util.Date;
import java.util.List;

public class Cart {
    private int id;
    private int userId;
    private String date;
    private List<Product> products;
    private int __v;

    public Cart(int id, int userId, String date, int __v) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.__v = __v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
