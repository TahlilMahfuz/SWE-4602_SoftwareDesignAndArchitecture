package com.example.inventoryservice.controller;

import com.example.inventoryservice.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class InitializeProduct {
    public List<Product> initialize(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Laptop", 100));
        products.add(new Product("2", "Mobile", 50));
        products.add(new Product("3", "barger", 10));
        products.add(new Product("4", "Mouse", 20));
        return products;
    }
}
