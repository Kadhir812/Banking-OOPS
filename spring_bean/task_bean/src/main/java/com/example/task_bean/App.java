package com.example.task_bean;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App{
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductConfig.class);

        Product product = (Product)context.getBean("pr");
        Store store = (Store)context.getBean("str");

        System.out.println(product.toString());
        System.out.println(store.toString());
        context.close();
    }
}