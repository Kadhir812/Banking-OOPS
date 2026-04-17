package com.example.movie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.movie.model.Member;
import com.example.movie.model.Movie;

public class bookingOperations {
// Book Ticket
// Cancel Ticket
// Show Booking
// Details Total Amount

public static Member getMemberById(Session session, int memberId) {
    return session.get(Member.class, memberId);
}

public static Movie getMovieById(Session session, int movieId) {
    return session.get(Movie.class, movieId);
}

public static double bookTicket(Session session, int memberId, int movieId, int ticketCount) {
    Transaction tx = session.beginTransaction();
    try {
        Movie movie = session.get(Movie.class, movieId);
        Member member = session.get(Member.class, memberId);

        if (movie == null || member == null) {
            System.out.println("Member or Movie not found");
            tx.rollback();
            return -1;
        }

        if (ticketCount <= 0) {
            System.out.println("Ticket count must be greater than 0");
            tx.rollback();
            return -1;
        }

        if (movie.getSeats() < ticketCount) {
            System.out.println("Not enough seats available");
            tx.rollback();
            return -1;
        }

        movie.setSeats(movie.getSeats() - ticketCount);
        member.setMovieId(movieId);
        member.setTickets(member.getTickets() + ticketCount);

        double amount = ticketCount * movie.getPrice();
        tx.commit();
        return amount;
    } catch (Exception e) {
        tx.rollback();
        System.err.println(e.getMessage());
        return -1;
    }
}

public static double cancelTicket(Session session, int memberId, int ticketCount) {
    Transaction tx = session.beginTransaction();
    try {
        Member member = session.get(Member.class, memberId);

        if (ticketCount <= 0) {
            System.out.println("Ticket count must be greater than 0");
            tx.rollback();
            return -1;
        }

        if (member.getTickets() < ticketCount) {
            System.out.println("Cannot cancel more tickets than booked");
            tx.rollback();
            return -1;
        }

        Movie movie = session.get(Movie.class, member.getMovieId());
        if (movie == null) {
            System.out.println("Movie not found for this booking");
            tx.rollback();
            return -1;
        }

        member.setTickets(member.getTickets() - ticketCount);
        movie.setSeats(movie.getSeats() + ticketCount);

        double refund = ticketCount * movie.getPrice();
        tx.commit();
        return refund;
    } catch (Exception e) {
        tx.rollback();
        System.err.println(e.getMessage());
        return -1;
    }
}

public static void showBooking(Session session) {
    Transaction tx = session.beginTransaction();
    try {
        List<Member> bookedMembers = session.createQuery("from Member where tickets > 0", Member.class).list();

        if (bookedMembers.isEmpty()) {
            System.out.println("No active bookings found");
            tx.commit();
            return;
        }

        System.out.println("------ Booking Details ------");
        for (Member member : bookedMembers) {
            Movie movie = session.get(Movie.class, member.getMovieId());
            if (movie == null) {
                continue;
            }

            double amount = member.getTickets() * movie.getPrice();
            System.out.println(
                    "MemberId: " + member.getMemberId()
                            + ", MemberName: " + member.getMemberName()
                            + ", MovieId: " + movie.getMovieId()
                            + ", MovieName: " + movie.getMovieName()
                            + ", Tickets: " + member.getTickets()
                            + ", Total Amount: " + amount);
        }
        tx.commit();
    } catch (Exception e) {
        tx.rollback();
        System.err.println(e.getMessage());
    }
}

}
