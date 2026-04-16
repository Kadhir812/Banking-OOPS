package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration()
                .configure("hiberConfig.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
            
                

            System.out.println("Connected");
            
            Menu menu = new Menu(session);
            menu.displayMenu();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    static void addProduct(Session session, int id, String name, double price) {
        Product p = new Product(id, name, price);
        Transaction tx = session.beginTransaction();
        try {
            session.persist(p);
            tx.commit();
            System.out.println("Product added successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    static void updateProductPrice(Session session, int id, double newPrice) {
        Transaction tx = session.beginTransaction();
        try {
            Product p = session.find(Product.class, id);
            if (p != null) {
                p.setPrice(newPrice);
                tx.commit();
                System.out.println("Product updated successfully!");
            } else {
                tx.rollback();
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    static void deleteProduct(Session session, int id) {
        Transaction tx = session.beginTransaction();
        try {
            Product p = session.find(Product.class, id);
            if (p != null) {
                session.remove(p);
                tx.commit();
                System.out.println("Product deleted successfully!");
            } else {
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    static void findProduct(Session session, int id) {
        try {
            Product p = session.find(Product.class, id);
            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

