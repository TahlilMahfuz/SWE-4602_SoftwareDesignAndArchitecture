package com.example.lab_3microservice.controller;

import com.example.lab_3microservice.entity.Employee;
import com.example.lab_3microservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String getEmployee(){
        return "Hello";
    }

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable("id") String employeeId){
        return employeeService.findEmployeeById(employeeId);
    }
}
