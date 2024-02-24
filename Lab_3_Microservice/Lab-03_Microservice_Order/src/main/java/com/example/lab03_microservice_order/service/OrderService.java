package com.example.lab03_microservice_order.service;

import com.example.lab03_microservice_order.entity.Order;
import com.example.lab03_microservice_order.feign.CustomerInterface;
import com.example.lab03_microservice_order.feign.EmployeeInterface;
import com.example.lab03_microservice_order.feign.ProductInterface;
import com.example.lab03_microservice_order.repository.OrderRepository;
import com.example.lab03_microservice_order.valueObject.Customer;
import com.example.lab03_microservice_order.valueObject.Employee;
import com.example.lab03_microservice_order.valueObject.Product;
import com.example.lab03_microservice_order.valueObject.ResponseValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    ProductInterface productInterface;
    @Autowired
    CustomerInterface customerInterface;
    @Autowired
    EmployeeInterface employeeInterface;
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order findOrderById(String orderId) {
        return orderRepository.findOrderById(orderId);
    }
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public ResponseValueObject getOrderDetailsByID(String orderId) {
        Product product = new Product();
        Employee employee = new Employee();
        Customer customer = new Customer();
        ResponseValueObject responseValueObject = new ResponseValueObject();
        try {
            Order order = orderRepository.findOrderById(orderId);
            product = productInterface.findProductById(order.getProductId());
            employee = employeeInterface.findEmployeeById(order.getEmployeeId());
            customer = customerInterface.findCustomerById(order.getCustomerId());
            responseValueObject.setProduct(product);
            responseValueObject.setEmployee(employee);
            responseValueObject.setCustomer(customer);
            responseValueObject.setOrder(order);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return responseValueObject;
    }
}
