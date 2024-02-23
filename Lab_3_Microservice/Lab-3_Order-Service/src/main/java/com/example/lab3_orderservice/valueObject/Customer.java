package com.example.lab3_orderservice.valueObject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Customer {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String address;
    @Field
    private int age;
}
