package com.exltial.furniture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class FurnitureApplication {
    public static void main(String[] args) {
        SpringApplication.run(FurnitureApplication.class, args);
    }
}
