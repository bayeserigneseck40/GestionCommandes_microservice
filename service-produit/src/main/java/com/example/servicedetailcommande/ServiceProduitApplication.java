package com.example.servicedetailcommande;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProduitApplication.class, args);
    }

}
