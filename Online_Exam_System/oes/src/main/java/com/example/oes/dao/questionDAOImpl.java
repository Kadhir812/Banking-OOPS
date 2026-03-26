package com.example.oes.dao;

import java.sql.*;
import java.util.*;
import com.example.oes.dto.Question;
import com.example.oes.utils.DBConnection;

public class questionDAOImpl implements questionDAO {
    PreparedStatement stmt;
    Connection con;

    public questionDAOImpl() {
        try {
            con = DBConnection.getConnection();
            System.out.println("connection done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addQuestion(Question q) {
        try {

            String sql = "INSERT INTO question (questionText, optionA, optionB, optionC, optionD, correctAnswer) VALUES (?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);

            stmt.setString(1, q.getQuestionText());
            stmt.setString(2, q.getOptionA());
            stmt.setString(3, q.getOptionB());
            stmt.setString(4, q.getOptionC());
            stmt.setString(5, q.getOptionD());
            stmt.setString(6, q.getCorrectAnswer());

            stmt.executeUpdate();
            System.out.println("Saved");

            stmt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM question");
            while (rs.next()) {
                Question q = new Question();
                q.setQuestionId(rs.getInt("questionId"));
                q.setQuestionText(rs.getString("questionText"));
                q.setOptionA(rs.getString("optionA"));
                q.setOptionB(rs.getString("optionB"));
                q.setOptionC(rs.getString("optionC"));
                q.setOptionD(rs.getString("optionD"));
                q.setCorrectAnswer(rs.getString("correctAnswer"));
                list.add(q);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateQuestion(int id, String text) {
        try {
            String sql = "UPDATE question SET questionText=? WHERE questionId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, text);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
