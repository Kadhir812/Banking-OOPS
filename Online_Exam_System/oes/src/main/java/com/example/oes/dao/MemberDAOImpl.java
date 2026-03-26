package com.example.oes.dao;

import com.example.oes.dto.Member;
import com.example.oes.utils.DBConnection;
import java.sql.*;

public class MemberDAOImpl implements MemberDAO {
    Connection con;
    PreparedStatement stmt;

    public MemberDAOImpl() {
        try {
            con = DBConnection.getConnection();
            System.out.println("connection done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addMember(Member m) {
        try {
            stmt = con.prepareStatement("insert into member (name, email) values (?, ?)");
            stmt.setString(1, m.getName());
            stmt.setString(2, m.getEmail());
            int c = stmt.executeUpdate();
            if (c > 0) {
                System.out.println("Member registered successfully.");
            } else {
                System.out.println("Registration failed.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
