package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.hiber.model.Product;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration()
                .configure("hiberConfig.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

            try (sessionFactory; Session session = sessionFactory.openSession()) {
                System.out.println("Connected");
                Menu menu = new Menu(session);
                menu.displayMenu();
            }
            
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
            int c = session.createQuery("update Product set price = :pr where productId = :id")
                .setParameter("id", id)
                .setParameter("pr", newPrice)
                .executeUpdate();

            if (c > 0) {
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
            int c = session.createQuery("delete from Product where productId = :id")
                .setParameter("id", id)
                .executeUpdate();

            if (c > 0) {
                tx.commit();
                System.out.println("Product deleted successfully!");
            } else {
                tx.rollback();
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    static void findProduct(Session session, int id) {
        Transaction tx = session.beginTransaction();
        try {
            Query<Product> q2 = session.createQuery("from Product where productId = :id", Product.class);
            q2.setParameter("id", id);
            Product p = q2.uniqueResult();
            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Not Found");
            }
            tx.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    static void selectPage(Session session, int pageNo) {
        int pageSize = 3; 

        Transaction tx = session.beginTransaction();
        try {
            int start = (pageNo - 1) * pageSize;

            Query<Product> q = session.createQuery(
                "from Product order by productId",
                Product.class
            );
            q.setFirstResult(start);
            q.setMaxResults(pageSize);

            List<Product> list = q.list();

            if (list.isEmpty()) {
                System.out.println("No products found for this page.");
            } else {
                for (Product p : list) {
                    System.out.println(p);
                }
            }

            tx.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    
}

