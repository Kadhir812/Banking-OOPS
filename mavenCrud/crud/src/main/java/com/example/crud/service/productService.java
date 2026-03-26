package com.example.crud.service;

import java.util.*;
import java.util.List;
import java.util.Scanner;
import com.example.crud.dto.Product;
import com.example.crud.dao.productDAOImpl;

public class productService {
    Scanner sc;
    productDAOImpl dao;

    public productService() {
        sc = new Scanner(System.in);
        dao = new productDAOImpl();
    }

    public void insert() {
        System.out.println("Enter the Id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the Name: ");
        String name = sc.nextLine();
        System.out.println("Enter the Price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.println("Enter the City: ");
        String city = sc.nextLine();

        Product p = new Product(id, name, price, city);
        dao.saveData(p);
        System.out.println("Product created and saved: " + p);
    }

    public List<Product> getData(){
        return dao.showAll();
    }

    public void remove(){
        int id = Integer.parseInt(sc.nextLine());
        dao.removeById(id);
    }

    public void update(){
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter the new city: ");
        String city = sc.nextLine();
        dao.updateCityById(id, city);
    }
}
