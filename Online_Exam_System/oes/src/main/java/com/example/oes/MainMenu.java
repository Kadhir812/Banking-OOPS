package com.example.oes;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                   AdminMenu.main(new String[]{});
                    break;
                case "2":
                    UserMenu.main(new String[]{});
                    break;
                case "3":
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
