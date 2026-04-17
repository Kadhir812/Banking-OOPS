package com.example.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.movie.model.Movie;

public class movieOperations {

    // Add Movie
    // Show All Movies
    // Search Movie by Id
    // Update Price
    // Delete Movie
    public static void addMovie(Session session, String movieName, double price, int seats) {
        Transaction tx = session.beginTransaction();
        try {
            Movie movie = new Movie(movieName, price, seats);
            session.persist(movie);

            tx.commit();
            System.out.println("Movie added successfully!");
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void showAllMovie(Session session) {
    Transaction tx = session.beginTransaction();
    try {
         Query<Movie> q1 = session.createQuery("from Movie", Movie.class);
         List<Movie> list = q1.list();
         
         for (Movie m : list) {
            System.out.println(m);
        }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void searchMoviebyId(Session session, int id) {
        Transaction tx = session.beginTransaction();
        try {
            Query<Movie> q2 = session.createQuery("from Movie where movieId = :id", Movie.class);
            q2.setParameter("id", id);
            Movie p = q2.uniqueResult();
            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Movie Not Found");
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void updateMoviePrice(Session session, int id, double newPrice) {
        Transaction tx = session.beginTransaction();
        try {
            int c = session.createQuery("update Movie set price = :pr where movieId = :id")
                    .setParameter("id", id)
                    .setParameter("pr", newPrice)
                    .executeUpdate();

            if (c > 0) {
                tx.commit();
                System.out.println("Movie price updated successfully!");
            } else {
                tx.rollback();
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void deleteMovie(Session session, int id) {
        Transaction tx = session.beginTransaction();
        try {
            int c = session.createQuery("delete from Movie where movieId = :id")
                    .setParameter("id", id)
                    .executeUpdate();

            if (c > 0) {
                tx.commit();
                System.out.println("Movie deleted successfully!");
            } else {
                tx.rollback();
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }
}
