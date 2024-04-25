package com.example.inventoryservice.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    @Getter
    private String orderId;
    private String name;
    private int qty;
    private double price;
}
