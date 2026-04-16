package com.example.library.menu;

import java.util.Scanner;

import org.hibernate.Session;

import com.example.library.service.BookService;

public class AdminMenu {

    private final BookService bookService = new BookService();

    public void show(Session session, Scanner scanner) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Back");
            System.out.print("Enter your choice: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1 -> addBook(session, scanner);
                case 2 -> removeBook(session, scanner);
                case 3 -> updateBook(session, scanner);
                case 4 -> searchBook(session, scanner);
                case 5 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addBook(Session session, Scanner scanner) {
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = readDouble(scanner);
        System.out.print("Enter status (Available/Issued): ");
        String status = scanner.nextLine();

        bookService.addBook(session, bookName, authorName, price, status);
    }

    private void removeBook(Session session, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = readInt(scanner);
        bookService.removeBook(session, bookId);
    }

    private void updateBook(Session session, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = readInt(scanner);
        System.out.print("Enter new book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter new author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter new price: ");
        double price = readDouble(scanner);
        System.out.print("Enter new status (Available/Issued): ");
        String status = scanner.nextLine();

        bookService.updateBook(session, bookId, bookName, authorName, price, status);
    }

    private void searchBook(Session session, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = readInt(scanner);
        bookService.searchBook(session, bookId);
    }

    private int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    private double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}