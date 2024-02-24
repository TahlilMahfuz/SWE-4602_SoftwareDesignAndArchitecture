package com.example.lab03_microservice_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Lab03MicroserviceOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab03MicroserviceOrderApplication.class, args);
    }

}
