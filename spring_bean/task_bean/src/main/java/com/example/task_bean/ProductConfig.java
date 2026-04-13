package com.example.task_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean(name = "pr")
    public Product getName(){
        Product p = new Product();

        p.setName("Fiama");
        p.setCategory("BWash");
        p.setQuantity(5);
        p.setPrice(245.34);

        return p;
    }

    @Bean(name = "str")
    public Store getStoreName() {
        Store s = new Store();

        s.setStoreName("Los Pollos Hermanos");
        s.setLocation("Albaquerque");
        s.setOwnerName("Gustavo Fring");

        return s;
    }
}
