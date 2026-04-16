package com.example.library.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.library.model.Book;

public class BookOperations {
    
    public static void addBook(Session session, String bookName, String authorName, double price, String status) {
        Book book = new Book(bookName, authorName, price, status);
        Transaction tx = session.beginTransaction();
        try {
            session.persist(book);
            tx.commit();
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error adding book: " + e.getMessage());
        }
    }
    
    public static void removeBook(Session session, int bookId) {
        Transaction tx = session.beginTransaction();
        try {
            Book book = session.find(Book.class, bookId);
            if (book != null) {
                session.remove(book);
                tx.commit();
                System.out.println("Book removed successfully!");
            } else {
                tx.rollback();
                System.out.println("Book not found!");
            }
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error removing book: " + e.getMessage());
        }
    }
    
    public static void updateBook(Session session, int bookId, String bookName, String authorName, double price, String status) {
        Transaction tx = session.beginTransaction();
        try {
            Book book = session.find(Book.class, bookId);
            if (book != null) {
                book.setBookName(bookName);
                book.setAuthorName(authorName);
                book.setPrice(price);
                book.setStatus(status);
                tx.commit();
                System.out.println("Book updated successfully!");
            } else {
                tx.rollback();
                System.out.println("Book not found!");
            }
        } catch (Exception e) {
            tx.rollback();
            System.err.println("Error updating book: " + e.getMessage());
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
