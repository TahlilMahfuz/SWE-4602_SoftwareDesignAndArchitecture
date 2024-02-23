package com.example.lab_3serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lab3ServiceRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab3ServiceRegistryApplication.class, args);
    }

}
