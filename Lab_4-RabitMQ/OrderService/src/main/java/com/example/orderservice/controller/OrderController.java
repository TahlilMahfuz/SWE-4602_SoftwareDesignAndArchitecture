package com.example.orderservice.controller;

import com.example.orderservice.Constants;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("/{restaurantName}/{productid}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName,@PathVariable String productid) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS",
                "Order Successfully Placed to "+ restaurantName + " for the product id "+ productid, productid);
        System.out.println("Order Status: "+ orderStatus);

        rabbitTemplate.convertAndSend(Constants.EXCHANGE,Constants.ROUTING_KEY, orderStatus);
        return "success!!";
    }

}
