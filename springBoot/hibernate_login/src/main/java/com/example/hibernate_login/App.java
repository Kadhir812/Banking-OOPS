package com.example.hibernate_login;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    Session ses;

    public App() {
        SessionFactory factory = new Configuration()
             .configure("hiberConfig.xml")
             .addAnnotatedClass(Login.class)
             .buildSessionFactory();
        ses = factory.openSession();
    }

    public void signUp(Scanner sc) {
        try {
            Transaction tx = ses.beginTransaction();

            Login u = new Login();
            System.out.print("Enter ID: ");
            u.setId(sc.nextInt());
            System.out.print("Enter Username: ");
            u.setUsername(sc.next());
            System.out.print("Enter Password: ");
            u.setPassword(sc.next());

            ses.persist(u);
            tx.commit();
            System.out.println("Registered!");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void signIn(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Password: ");
            String pass = sc.next();

            Login u = ses.find(Login.class, id);

            if (u != null && u.getPassword().equals(pass)) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Invalid Credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forgotPassword(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Login u = ses.find(Login.class, id);

            if (u != null) {
                System.out.println("Your password: " + u.getPassword());
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updatePassword(Scanner sc) {
        try {
            Transaction tx = ses.beginTransaction();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Login u = ses.find(Login.class, id);

            if (u != null) {
                System.out.print("Enter new password: ");
                u.setPassword(sc.next());

                ses.merge(u);
                tx.commit();

                System.out.println("Password Updated!");
            } else {
                System.out.println("User not found");

            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }

    }

    public void searchUser(Scanner sc) {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Login u = ses.find(Login.class, id);

            if (u != null) {
                System.out.println(u.getUsername());
            } else {
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteUser(Scanner sc) {
        Transaction tx = null;
        try {
            tx = ses.beginTransaction();

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            System.out.print("Enter Password: ");
            String pass = sc.next();
            Login u = ses.find(Login.class, id);

            if (u != null && u.getPassword().equals(pass)) {
                ses.remove(u);
                tx.commit();
                System.out.println("Account Deleted!");

            } else {
                System.out.println("Invalid ID or Password");
                tx.rollback();

            }

        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.SignUp 2.SignIn 3.ForgotPwd 4.UpdatePwd 5.Search 6.Delete 7.Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    app.signUp(sc);
                    break;
                case 2:
                    app.signIn(sc);
                    break;
                case 3:
                    app.forgotPassword(sc);
                    break;
                case 4:
                    app.updatePassword(sc);
                    break;
                case 5:
                    app.searchUser(sc);
                    break;
                case 6:
                    app.deleteUser(sc);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}