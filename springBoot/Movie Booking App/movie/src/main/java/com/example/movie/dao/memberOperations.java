package com.example.movie.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.movie.model.Member;
import org.hibernate.query.Query;

import java.util.List;


public class memberOperations {
    // Add Member
    // Show All Members
    // Search Member by Id
    // Delete Member

    public static void addMember(Session session, String memberName) {
        Transaction tx = session.beginTransaction();
        try {
            Member member = new Member(memberName, 0, 0);
            session.persist(member);

            tx.commit();
            System.out.println("Member added successfully!");
            } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void showAllMembers(Session session) {
        Transaction tx = session.beginTransaction();
        try {
            Query<Member> q1 = session.createQuery("from Member", Member.class);
            List<Member> list = q1.list();

            for (Member m : list) {
                System.out.println(m);
            }

            tx.commit();
         } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void searchMemberbyId(Session session, int id) {
        Transaction tx = session.beginTransaction();
        try {
            Query<Member> q2 = session.createQuery("from Member where memberId = :id", Member.class);
            q2.setParameter("id", id);
            Member p = q2.uniqueResult();
            if (p != null) {
                System.out.println(p);
            } else {
                System.out.println("Member Not Found");
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

    public static void deleteMember(Session session, int id) {
        Transaction tx = session.beginTransaction();
        try {
            int c = session.createQuery("delete from Member where memberId = :id")
                    .setParameter("id", id)
                    .executeUpdate();

            if (c > 0) {
                tx.commit();
                System.out.println("Member deleted successfully!");
            } else {
                tx.rollback();
                System.out.println("Not Found");
            }
        } catch (Exception e) {
            tx.rollback();
            System.err.println(e.getMessage());
        }
    }

}
