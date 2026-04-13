package com.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean(name = "st1")
    public Student getStudentName(){
        Student s = new Student();

        s.setStudentId(101);
        s.setStudentName("Kadhir S");
        s.setAge(18);
        s.setCourse("Maths");
        return s;
    }

    @Bean(name = "clg1")
    public College getCollege() {
        College college = new College();
        college.setC_id(1);
        college.setC_name("ABC College");
        return college;
    }
}
