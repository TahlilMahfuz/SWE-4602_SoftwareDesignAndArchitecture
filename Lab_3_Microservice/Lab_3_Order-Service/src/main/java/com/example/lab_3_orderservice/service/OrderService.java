package com.example.lab_3_orderservice.service;

import com.example.lab_3_orderservice.entity.Order;
import com.example.lab_3_orderservice.repository.OrderRepository;
import com.example.lab_3_orderservice.valueObject.Product;
import com.example.lab_3_orderservice.valueObject.ResponseValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

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

        try {
            String productURL="http://localhost:9002/products/65d89823832f644eee4a2543";
            System.out.println("productURL: "+productURL);
            Product product = this.restTemplate.getForObject( productURL, Product.class);
            ResponseValueObject.setProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseValueObject;
    }
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
