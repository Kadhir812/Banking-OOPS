package com.example.library.menu;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.library.model.Member;
import com.example.library.service.MemberService;
import com.example.library.utils.HibernateUtil;

public class MainMenu {

    private final AdminMenu adminMenu = new AdminMenu();
    private final MemberMenu memberMenu = new MemberMenu();
    private final MemberService memberService = new MemberService();

    public static void main(String[] args) {
        new MainMenu().show(HibernateUtil.getSessionFactory());
    }

    public void show(SessionFactory sessionFactory) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Admin Login");
                System.out.println("2. Member Login");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                int choice = readInt(scanner);

                switch (choice) {
                    case 1 -> adminLogin(sessionFactory, scanner);
                    case 2 -> memberLogin(sessionFactory, scanner);
                    case 3 -> {
                        System.out.println("Exiting..");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }

    private void adminLogin(SessionFactory sessionFactory, Scanner scanner) {
        System.out.print("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if ("admin".equals(username) && "admin123".equals(password)) {
            try (Session session = sessionFactory.openSession()) {
                adminMenu.show(session, scanner);
            }
        } else {
            System.out.println("Invalid admin credentials!");
        }
    }

    private void memberLogin(SessionFactory sessionFactory, Scanner scanner) {
        try (Session session = sessionFactory.openSession()) {
            while (true) {
                System.out.println("\nMember Access:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Back");
                System.out.print("Enter your choice: ");

                int choice = readInt(scanner);

                switch (choice) {
                    case 1 -> registerMember(session, scanner);
                    case 2 -> {
                        Member member = loginMember(session, scanner);
                        if (member != null) {
                            memberMenu.show(session, member.getMemberId(), scanner);
                        }
                    }
                    case 3 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }

    private void registerMember(Session session, Scanner scanner) {
        System.out.println("\nMember Registration:");
        System.out.print("Enter member name: ");
        String memberName = scanner.nextLine();
        System.out.print("Enter email: ");
        String emailId = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        Member member = memberService.registerMember(session, memberName, emailId, password, phoneNumber);
        if (member != null) {
            System.out.println("Registration successful! Your member ID is: " + member.getMemberId());
        }
    }

    private Member loginMember(Session session, Scanner scanner) {
        System.out.print("Enter member ID: ");
        int memberId = readInt(scanner);
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Member member = memberService.loginMember(session, memberId, password);
        if (member != null) {
            System.out.println("Login successful! Welcome, " + member.getMemberName() + ".");
        }

        return member;
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




// mvn compile exec:java -Dexec.mainClass=com.example.library.menu.MainMenu