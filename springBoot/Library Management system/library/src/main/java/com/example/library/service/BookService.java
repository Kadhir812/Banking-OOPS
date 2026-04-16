package com.example.library.service;

import org.hibernate.Session;
import com.example.library.model.Book;
import com.example.library.dao.BookOperations;

public class BookService {
    
    public void addBook(Session session, String bookName, String authorName, double price, String status) {
        if (bookName == null || bookName.isEmpty()) {
            System.out.println("Error: Book name cannot be empty!");
            return;
        }
        if (price <= 0) {
            System.out.println("Error: Price must be greater than 0!");
            return;
        }
        
       
        BookOperations.addBook(session, bookName, authorName, price, status);
    }
    
    public void removeBook(Session session, int bookId) {
        BookOperations.removeBook(session, bookId);
    }
    
    public void updateBook(Session session, int bookId, String bookName, String authorName, double price, String status) {
        if (bookName == null || bookName.isEmpty()) {
            System.out.println("Error: Book name cannot be empty!");
            return;
        }
        
        BookOperations.updateBook(session, bookId, bookName, authorName, price, status);
    }
    
    public void searchBook(Session session, int bookId) {
        BookOperations.searchBook(session, bookId);
    }
}
