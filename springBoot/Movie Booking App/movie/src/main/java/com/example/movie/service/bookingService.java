package com.example.movie.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.movie.dao.bookingOperations;
import com.example.movie.model.Member;
import com.example.movie.model.Movie;
import com.example.movie.utils.hibernateUtil;

public class bookingService {

    private final SessionFactory sessionFactory;

    public bookingService() {
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    public bookingService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void bookTicket(int memberId, int movieId, int ticketCount) {
        if (memberId <= 0 || movieId <= 0 || ticketCount <= 0) {
            System.out.println("Invalid input");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            double amount = bookingOperations.bookTicket(session, memberId, movieId, ticketCount);
            if (amount >= 0) {
                System.out.println("Ticket booked successfully. Total amount: " + amount);
            }
        }
    }

    public void cancelTicket(int memberId, int ticketCount) {
        if (memberId <= 0 || ticketCount <= 0) {
            System.out.println("Invalid input");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            double refund = bookingOperations.cancelTicket(session, memberId, ticketCount);
            if (refund >= 0) {
                System.out.println("Ticket cancelled successfully. Refund amount: " + refund);
            }
        }
    }

    public void showBooking() {
        try (Session session = sessionFactory.openSession()) {
            bookingOperations.showBooking(session);
        }
    }

    public void detailsTotalAmount(int memberId) {
        if (memberId <= 0) {
            System.out.println("Invalid input");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            Member member = bookingOperations.getMemberById(session, memberId);
            if (member == null) {
                System.out.println("Member not found");
                return;
            }

            if (member.getTickets() <= 0 || member.getMovieId() <= 0) {
                System.out.println("No active booking found for this member");
                return;
            }


            Movie movie = bookingOperations.getMovieById(session, member.getMovieId());
            if (movie == null) {
                System.out.println("Movie not found for this booking");
                return;
            }

            double totalAmount = member.getTickets() * movie.getPrice();
            System.out.println("Total amount for member " + memberId + ": " + totalAmount);
        }
    }

}
