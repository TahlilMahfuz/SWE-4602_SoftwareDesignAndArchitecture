package com.example.lab03_microservice_order.feign;

import com.example.lab03_microservice_order.valueObject.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerInterface {
    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable("id") String customerId);
}
