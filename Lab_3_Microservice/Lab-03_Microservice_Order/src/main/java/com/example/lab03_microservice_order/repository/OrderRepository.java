package com.example.lab03_microservice_order.repository;


import com.example.lab03_microservice_order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
    Order findOrderById(String orderId);
}
