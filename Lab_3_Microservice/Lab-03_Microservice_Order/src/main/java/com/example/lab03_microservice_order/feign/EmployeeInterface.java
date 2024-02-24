package com.example.lab03_microservice_order.feign;

import com.example.lab03_microservice_order.valueObject.Employee;
import com.example.lab03_microservice_order.valueObject.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service")
public interface EmployeeInterface {
    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable("id") String employeeId);
}
