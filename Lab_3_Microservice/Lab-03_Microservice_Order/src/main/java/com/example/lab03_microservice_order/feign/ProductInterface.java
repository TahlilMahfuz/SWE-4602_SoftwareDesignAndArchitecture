package com.example.lab03_microservice_order.feign;

import com.example.lab03_microservice_order.valueObject.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductInterface {
    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable("id") String productID);
}
