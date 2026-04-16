package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;
    String bookName;
    String authorName;
    double price;
    String status;  

    public Book() {
    }

    public Book(String bookName, String authorName, double price, String status) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.status = status;
    }

    public Book(int bookId, String bookName, String authorName, double price, String status) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", price=" + price
                + ", status=" + status + "]";
    }
}
