package com.example.lab3_orderservice.valueObject;

import com.example.lab3_orderservice.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseValueObject{
    private Customer customer;
    private Product product;
    private Employee employee;
    private Order order;
}
