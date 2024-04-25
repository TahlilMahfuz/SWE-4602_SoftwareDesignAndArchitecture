package com.example.inventoryservice.controller;


import com.example.inventoryservice.entity.OrderStatus;
import com.example.inventoryservice.entity.Product;
import com.example.orderservice.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class InventoryController {
    @RabbitListener(queues = Constants.QUEUE )
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message Received from queues: " +orderStatus);
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", "Product 1", 10));
        products.add(new Product("2", "Product 2", 20));
        products.add(new Product("3", "barger", 50));
        for (Product product : products) {
            if(product.productId().equals(orderStatus.getProductID())){
                if(product.productQuantity() > orderStatus.getOrder().getQty()){
                    System.out.println("Product is available");
                }else{
                    System.out.println("Product is not available");
                }
            }
        }
    }
}
