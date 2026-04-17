package com.example.movie.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.movie.utils.hibernateUtil;
import com.example.movie.dao.memberOperations;


public class memberService {
    private final SessionFactory sessionFactory;

    public memberService() {
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    public memberService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addMember(String memberName) {
        if (memberName == null || memberName.isBlank()) {
            System.out.println("Member name cannot be empty");
            return;
        }

        try (Session session = sessionFactory.openSession()) {
            memberOperations.addMember(session, memberName);
        }
    }

    public void showAllMembers() {
        try (Session session = sessionFactory.openSession()) {
            memberOperations.showAllMembers(session);
        }
    }

    public void searchMemberById(int id) {
        if (id <= 0) {
            System.out.println("Id must be greater than 0");
        }

        try (Session session = sessionFactory.openSession()) {
            memberOperations.searchMemberbyId(session, id);
        }
    }

    public void deleteMember(int id) {
        if (id <= 0) {
            System.out.println("Id must be greater than 0");
        }

        try (Session session = sessionFactory.openSession()) {
            memberOperations.deleteMember(session, id);
        }
    }
}