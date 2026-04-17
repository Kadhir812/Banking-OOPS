package com.example.movie.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.movie.model.Member;
import com.example.movie.model.Movie;

public final class hibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private hibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration()
                .configure("hiberConfig.xml")
                .addAnnotatedClass(Member.class)
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
