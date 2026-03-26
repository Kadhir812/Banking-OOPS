package com.example.crud;

import com.example.crud.service.productService;
import com.example.crud.dto.Product;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        productService service = new productService();
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        System.out.println("Connection successful");

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Insert Product");
            System.out.println("2. Get All Products");
            System.out.println("3. Remove Product");
            System.out.println("4. Update Product");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    service.insert();
                    break;

                case "2":
                    List<Product> products = service.getData();
                        
                        for (Product p : products) {
                            System.out.println(p);
                        }
                    break;

                case "3":
                    service.remove();
                    break;

                case "4":
                    service.update();
                    break;
                
                case "5":
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}