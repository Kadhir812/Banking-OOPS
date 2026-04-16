package com.example.library.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.library.model.Book;
import com.example.library.model.Member;

import java.util.List;

public class MemberOperations {

    public static Member registerMember(Session session, String memberName, String emailId, String password,
            String phoneNumber) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Member member = new Member(memberName, emailId, password, phoneNumber);
            session.persist(member);

            tx.commit();
            return member;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Error registering member: " + e.getMessage());
            return null;
        }
    }

    public static Member authenticateMember(Session session, int memberId, String password) {
        try {
            Member member = session.find(Member.class, memberId);
            if (member == null) {
                System.out.println("Member not found! Please register first.");
                return null;
            }

            if (!member.getPassword().equals(password)) {
                System.out.println("Invalid password!");
                return null;
            }

            return member;
        } catch (Exception e) {
            System.err.println("Error during member login: " + e.getMessage());
            return null;
        }
    }

    public static void issueBook(Session session, int memberId, int bookId) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Member member = session.find(Member.class, memberId);

            if (member == null) {
                System.out.println("Only registered members can issue books.");
                tx.rollback();
                return;
            }

            Book book = session.find(Book.class, bookId);

            if (book == null) {
                System.out.println("Book not found!");
                tx.rollback();
                return;
            }

            if (!"Available".equalsIgnoreCase(book.getStatus())) {
                System.out.println("Book is already issued!");
                tx.rollback();
                return;
            }

            book.setStatus("Issued");
            session.merge(book);

            tx.commit();
            System.out.println("Book issued successfully to member: " + member.getMemberName());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Error issuing book: " + e.getMessage());
        }
    }

    public static void returnBook(Session session, int memberId, int bookId) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Member member = session.find(Member.class, memberId);
            Book book = session.find(Book.class, bookId);

            if (member == null) {
                System.out.println("Member not found!");
                tx.rollback();
                return;
            }

            if (book == null) {
                System.out.println("Book not found!");
                tx.rollback();
                return;
            }

            if ("Available".equalsIgnoreCase(book.getStatus())) {
                System.out.println("Book is already available!");
                tx.rollback();
                return;
            }

            book.setStatus("Available");
            session.merge(book);

            tx.commit();
            System.out.println("Book returned successfully by member: " + member.getMemberName());
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Error returning book: " + e.getMessage());
        }
    }

    public static void searchBook(Session session, int bookId) {
        try {
            Book book = session.find(Book.class, bookId);
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("Book not found!");
            }
        } catch (Exception e) {
            System.err.println("Error searching book: " + e.getMessage());
        }
    }
}