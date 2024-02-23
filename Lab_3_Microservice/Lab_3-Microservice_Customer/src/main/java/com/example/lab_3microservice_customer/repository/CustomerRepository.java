package com.example.lab_3microservice_customer.repository;

import com.example.lab_3microservice_customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findCustomerById(String userId);
}
