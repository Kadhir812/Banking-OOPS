package com.example.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.example.hiber.model.Product;

public class query {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hiberConfig.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        // Select

        // Transaction tx = session.beginTransaction();

        // Query<Product> q = session.createNativeQuery(
        //         "select * from Product where productId = ?1",
        //         Product.class);

        // q.setParameter(1, 22);

        // List<Product> list = q.list();

        // for (Product i : list) {
        //     System.out.println(i);
        // }

        // tx.commit();
        // session.close();
        // factory.close();


        // Insert
        // Transaction tx = session.beginTransaction();

        // Query iq = session.createNativeQuery(
        //     "insert into Product (productId, productName, price) values (?1, ?2, ?3)");
        // iq.setParameter(1, 105);
        // iq.setParameter(2, "Mouse");
        // iq.setParameter(3, 599.0);

        // int rows = iq.executeUpdate();

        // tx.commit();
        

        // // Update
        // Transaction tx = session.beginTransaction();

        // Query uq = session.createNativeQuery(
        //     "update Product set productName = ?1, price = ?2 where productId = ?3");
        // uq.setParameter(1, "Wireless Mouse");
        // uq.setParameter(2, 799.0);
        // uq.setParameter(3, 22);

        // int updatedRows = uq.executeUpdate();
        // System.out.println("Rows updated: " + updatedRows);
        
        // tx.commit();
       
        //Delete
        Transaction tx = session.beginTransaction();

        Query dq = session.createNativeQuery("delete from Product where productId = ?1");
        dq.setParameter(1, 105);

        int deletedRows = dq.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);

        tx.commit();
        session.close();
        factory.close();
        

    

        
    }

}


