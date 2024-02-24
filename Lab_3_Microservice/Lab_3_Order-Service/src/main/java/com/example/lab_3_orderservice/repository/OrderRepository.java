package com.example.lab_3_orderservice.repository;


import com.example.lab_3_orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findOrderById(String orderId);
}
