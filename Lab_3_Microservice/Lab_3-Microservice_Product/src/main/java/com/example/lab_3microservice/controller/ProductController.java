package com.example.lab_3microservice.controller;

import com.example.lab_3microservice.entity.Product;
import com.example.lab_3microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public Iterable<Product> getProduct(){
        return productService.getAllProducts();
    }
    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") String productID){
        return productService.findProductById(productID);
    }
}
