package com.example.lab3_employeeservice.service;

import com.example.lab3_employeeservice.entity.Employee;
import com.example.lab3_employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(String userId) {
        return employeeRepository.findEmployeeById(userId);
    }
    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
