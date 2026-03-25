package service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import entity.Book;
import entity.Member;

public class Library implements LibraryOperations {
    private Map<Integer, Member> members = new HashMap<>();
    private Map<Integer, Book> books = new HashMap<>();

    @Override
    public void createMember(String name) {
        Member member = new Member(name);
        members.put(member.getMemberId(), member);
        System.out.println("Member added successfully. Member ID: " + member.getMemberId());
    }

    @Override
    public void addBook(int bookId, String title, String author) {
        if (books.containsKey(bookId)) {
            System.out.println("Book ID already exists.");
            return;
        }
        books.put(bookId, new Book(bookId, title, author));
        System.out.println("Book added successfully.");
    }

    @Override
    public void issueBook(int memberId, int bookId) {
        Member member = members.get(memberId);
        Book book = books.get(bookId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }
        if (member.getIssuedBook() != null) {
            System.out.println("Member already has a book issued.");
            return;
        }
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(7);
        member.issueBook(book, issueDate, dueDate);
        book.setIssued(true);
        System.out.println("Book issued successfully. Due date: " + dueDate);
    }

    @Override
    public void returnBook(int memberId) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        Book book = member.getIssuedBook();
        if (book == null) {
            System.out.println("No book to return.");
            return;
        }
        LocalDate dueDate = member.getDueDate();
        LocalDate returnDate = LocalDate.now();
        long lateDays = 0;
        if (returnDate.isAfter(dueDate)) {
            lateDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        }
        member.returnBook();
        book.setIssued(false);
        if (lateDays > 0) {
            System.out.println("Book returned late. Fine: ₹" + (lateDays * 10));
        } else {
            System.out.println("Book returned on time. No fine.");
        }
    }

    @Override
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("ID\tTitle\tAuthor\tStatus");
        books.values().stream()
            .sorted(Comparator.comparing(Book::getBookId))
            .forEach(book -> System.out.println(book.getBookId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + (book.isIssued() ? "Issued" : "Available")));
    }

    @Override
    public void removeBook(int bookId) {
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Cannot remove: Book is currently issued.");
            return;
        }
        books.remove(bookId);
        System.out.println("Book removed successfully.");
    }

    @Override
    public void updateBook(int bookId, String newTitle, String newAuthor) {
        Book book = books.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        System.out.println("Book updated successfully.");
    }

    @Override
    public void removeMember(int memberId) {
        Member member = members.get(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (member.getIssuedBook() != null) {
            System.out.println("Cannot remove: Member has a book issued.");
            return;
        }
        members.remove(memberId);
        System.out.println("Member removed successfully.");
    }
}
