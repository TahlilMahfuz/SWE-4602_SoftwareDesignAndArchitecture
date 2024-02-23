package com.example.lab_3microservice_customer.service;

import com.example.lab_3microservice_customer.entity.Customer;
import com.example.lab_3microservice_customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Customer findCustomerById(String userId) {
        return customerRepository.findCustomerById(userId);
    }
    public Iterable<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
