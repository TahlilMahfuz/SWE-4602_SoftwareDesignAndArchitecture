package com.example.lab3_orderservice.repository;

import com.example.lab3_orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findOrderById(String orderId);
}
