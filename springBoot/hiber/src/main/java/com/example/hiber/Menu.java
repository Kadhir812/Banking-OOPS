package com.example.hiber;

import org.hibernate.Session;
import java.util.Scanner;

public class Menu {
    private Session session;
    private Scanner scanner;
    
    public Menu(Session session) {
        this.session = session;
        this.scanner = new Scanner(System.in);
    }
    
    public void displayMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\n===== Product menu =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Price");
            System.out.println("3. Delete Product");
            System.out.println("4. Find Product");
            System.out.println("5. Select Page");
          
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addProductMenu();
                    break;
                case 2:
                    updateProductPriceMenu();
                    break;
                case 3:
                    deleteProductMenu();
                    break;
                case 4:
                    findProductMenu();
                    break;
                case 5:
                    selectPageMenu();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
    
    private void addProductMenu() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        App.addProduct(session, id, name, price);
    }
    
    private void updateProductPriceMenu() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        App.updateProductPrice(session, id, newPrice);
    }

    private void deleteProductMenu() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        App.deleteProduct(session, id);
    }

    private void findProductMenu() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        App.findProduct(session, id);
    }

    private void selectPageMenu() {
        System.out.print("Enter page number: ");
        int pageNo = scanner.nextInt();
        scanner.nextLine();

        App.selectPage(session, pageNo);
    }
   
}
