package com.example.library.service;

import org.hibernate.Session;

import com.example.library.dao.MemberOperations;
import com.example.library.model.Member;

public class MemberService {

    public Member registerMember(Session session, String memberName, String emailId, String password,
            String phoneNumber) {
        if (memberName == null || memberName.isBlank()) {
            System.out.println("Member name cannot be empty!");
            return null;
        }
        if (emailId == null || emailId.isBlank()) {
            System.out.println("Email cannot be empty!");
            return null;
        }
        if (password == null || password.isBlank()) {
            System.out.println("Password cannot be empty!");
            return null;
        }

        return MemberOperations.registerMember(session, memberName.trim(), emailId.trim(), password, phoneNumber);
    }

    public Member loginMember(Session session, int memberId, String password) {
        if (memberId <= 0) {
            System.out.println("Member ID must be greater than 0!");
            return null;
        }
        if (password == null || password.isBlank()) {
            System.out.println("Password cannot be empty!");
            return null;
        }

        return MemberOperations.authenticateMember(session, memberId, password);
    }

    public void issueBook(Session session, int memberId, int bookId) {
        if (memberId <= 0) {
            System.out.println("Member ID must be greater than 0!");
            return;
        }
        if (bookId <= 0) {
            System.out.println("Book ID must be greater than 0");
            return;
        }

        MemberOperations.issueBook(session, memberId, bookId);
    }

    public void returnBook(Session session, int memberId, int bookId) {
        if (memberId <= 0) {
            System.out.println("Member ID must be greater than 0!");
            return;
        }
        if (bookId <= 0) {
            System.out.println("Book ID must be greater than 0!");
            return;
        }

        MemberOperations.returnBook(session, memberId, bookId);
    }

    public void searchBook(Session session, int bookId) {
        if (bookId <= 0) {
            System.out.println("Book ID must be greater than 0!");
            return;
        }

        MemberOperations.searchBook(session, bookId);
    }
}
