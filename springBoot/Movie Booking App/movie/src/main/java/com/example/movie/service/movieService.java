package com.example.movie.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.movie.dao.movieOperations;
import com.example.movie.utils.hibernateUtil;

public class movieService {

    private final SessionFactory sessionFactory;

    public movieService() {
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    public movieService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addMovie(String movieName, double price, int seats) {
        if (movieName == null || movieName.isEmpty()) {
           System.out.println("Movie name cannot be empty");
              return;
        }

        try (Session session = sessionFactory.openSession()) {
            movieOperations.addMovie(session, movieName, price, seats);
        }
    }

    public void showAllMovies() {
        try (Session session = sessionFactory.openSession()) {
            movieOperations.showAllMovie(session);
        }
    }

    public void searchMovieById(int id) {
        if (id <= 0) {
            System.out.println("Id must be greater than 0");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            movieOperations.searchMoviebyId(session, id);
        }
    }

    public void updateMoviePrice(int id, double newPrice) {
        if (newPrice < 0) {
            System.out.println("Price cannot be negative");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            movieOperations.updateMoviePrice(session, id, newPrice);
        }
    }

    public void deleteMovie(int id) {
        if (id <= 0) {
            System.out.println("Id must be greater than 0");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            movieOperations.deleteMovie(session, id);
        }
    }
}
