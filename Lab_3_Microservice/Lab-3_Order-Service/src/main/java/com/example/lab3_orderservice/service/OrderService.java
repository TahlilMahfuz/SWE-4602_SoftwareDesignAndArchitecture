package com.example.lab3_orderservice.service;

import com.example.lab3_orderservice.entity.Order;
import com.example.lab3_orderservice.repository.OrderRepository;
import com.example.lab3_orderservice.valueObject.Customer;
import com.example.lab3_orderservice.valueObject.Employee;
import com.example.lab3_orderservice.valueObject.Product;
import com.example.lab3_orderservice.valueObject.ResponseValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
    public Order findOrderById(String orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Autowired
    private RestTemplate restTemplate;
    public ResponseValueObject getOrderDetailsByID(String orderId) {
        ResponseValueObject ResponseValueObject = new ResponseValueObject();
        Order order = orderRepository.findOrderById(orderId);
        System.out.println("ProductID" +order.getProductId());

        Product product = restTemplate.getForObject("http://localhost:9002/products/65d89823832f644eee4a2543", Product.class);
//        Customer customer = restTemplate.getForObject("http://localhost:8765/customer-service/customers/" + order.getCustomerId(), Customer.class);
//        Employee employee = restTemplate.getForObject("http://localhost:8765/employee-service/employees/" + order.getEmployeeId(), Employee.class);

//        ResponseValueObject.setCustomer(customer);
//        ResponseValueObject.setProduct(product);
//        ResponseValueObject.setEmployee(employee);
//        ResponseValueObject.setOrder(order);
        return ResponseValueObject;
    }
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
