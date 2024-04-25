package com.example.inventoryservice.entity;

public class Product {
    private String id;
    private String name;
    private int quantity;

    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public String productId() {
        return id;
    }
    public String productName() {
        return name;
    }
    public int productQuantity() {
        return quantity;
    }
}
