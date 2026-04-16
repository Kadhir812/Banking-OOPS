package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hiberConfig.xml")
                .buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            System.out.println("Connected");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

