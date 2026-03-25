package entity;

import java.time.LocalDate;

public class Member {
    private static int idCounter = 1;
    private int memberId;
    private String name;
    private Book issuedBook;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public Member(String name) {
        this.memberId = idCounter++;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public Book getIssuedBook() {
        return issuedBook;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void issueBook(Book book, LocalDate issueDate, LocalDate dueDate) {
        this.issuedBook = book;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public void returnBook() {
        this.issuedBook = null;
        this.issueDate = null;
        this.dueDate = null;
    }
}
