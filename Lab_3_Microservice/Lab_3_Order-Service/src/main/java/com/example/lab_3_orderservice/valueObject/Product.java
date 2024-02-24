package com.example.lab_3_orderservice.valueObject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Product {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String descruption;
}
