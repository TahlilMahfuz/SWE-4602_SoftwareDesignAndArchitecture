package com.example.inventoryservice.controller;


import com.example.inventoryservice.Constants;
import com.example.inventoryservice.entity.OrderStatus;
import com.example.inventoryservice.entity.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryController {
    @RabbitListener(queues = Constants.QUEUE )
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message Received from queues: " +orderStatus);
        List<Product> products = new InitializeProduct().initialize();
        boolean isNotFound = true;
        System.out.println("Product ID: "+orderStatus.getProductID());
        System.out.println("Order Quantity: "+orderStatus.getOrder().getQty());
        for (Product product : products) {
            if(product.productId().equals(orderStatus.getProductID())){
                isNotFound = false;
                if(product.productQuantity() > orderStatus.getOrder().getQty()){
                    System.out.println("Product is available");
                }else{
                    System.out.println("Product is not available");
                }
            }
        }
        if(isNotFound){
            System.out.println("Product not found in the inventory");
        }
    }
}
