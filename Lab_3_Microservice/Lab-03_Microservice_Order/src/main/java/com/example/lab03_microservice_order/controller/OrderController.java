package com.example.lab03_microservice_order.controller;

import com.example.lab03_microservice_order.entity.Order;
import com.example.lab03_microservice_order.service.OrderService;
import com.example.lab03_microservice_order.valueObject.Product;
import com.example.lab03_microservice_order.valueObject.ResponseValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public Iterable<Order> getOrder(){
        return orderService.getAllOrders();
    }

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping("/orderDetails/{id}")
    public ResponseValueObject getOrderDetails(@PathVariable("id") String orderId) {
        return orderService.getOrderDetailsByID(orderId);
    }
}
