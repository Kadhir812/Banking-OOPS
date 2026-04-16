package com.example.library.menu;

import java.util.Scanner;

import org.hibernate.Session;

import com.example.library.service.MemberService;

public class MemberMenu {

    private final MemberService memberService = new MemberService();

    public void show(Session session, int memberId, Scanner scanner) {
        while (true) {
            System.out.println("\nMember Menu:");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. Search Book");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1 -> issueBook(session, memberId, scanner);
                case 2 -> returnBook(session, memberId, scanner);
                case 3 -> searchBook(session, scanner);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void issueBook(Session session, int memberId, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = readInt(scanner);
        memberService.issueBook(session, memberId, bookId);
    }

    private void returnBook(Session session, int memberId, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = readInt(scanner);
        memberService.returnBook(session, memberId, bookId);
    }

    private void searchBook(Session session, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = readInt(scanner);
        memberService.searchBook(session, bookId);
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
}