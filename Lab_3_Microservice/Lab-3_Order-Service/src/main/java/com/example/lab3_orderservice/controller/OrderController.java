package com.example.lab3_orderservice.controller;

import com.example.lab3_orderservice.entity.Order;
import com.example.lab3_orderservice.service.OrderService;
import com.example.lab3_orderservice.valueObject.ResponseValueObject;
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
