package com.example.library.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.library.model.Book;
import com.example.library.model.Member;

public final class HibernateUtil {

    private static final SessionFactory session_factory = buildSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure("hiberConfig.xml")
                .addAnnotatedClass(Member.class)
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return session_factory;
    }

}