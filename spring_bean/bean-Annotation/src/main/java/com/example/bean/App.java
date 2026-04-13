package com.example.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
            Student student = (Student) context.getBean("st1");
            College college = (College) context.getBean("clg1");

            System.out.println(student.toString());
            System.out.println(college.toString());
        
    }
}
