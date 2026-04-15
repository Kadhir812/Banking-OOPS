package spring.auto_wired.src.main.java.com.example.auto_wired;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Employee {
    private int empId;
    private String name;

    public Employee() {

    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void start() {
        System.out.println("Employee bean is initialized");
    }

    @PreDestroy
    public void stop() {
        System.out.println("Employee bean is destroyed");
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", name=" + name + "]";
    }

    
}
