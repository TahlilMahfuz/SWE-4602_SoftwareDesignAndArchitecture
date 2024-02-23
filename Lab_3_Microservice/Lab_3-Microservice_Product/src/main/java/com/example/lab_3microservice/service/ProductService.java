package com.example.lab_3microservice.service;

import com.example.lab_3microservice.entity.Product;
import com.example.lab_3microservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findProductById(String productId) {
        return productRepository.findProductById(productId);
    }
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
