package com.example.oes;

import com.example.oes.utils.*;
import com.example.oes.service.*;
import com.example.oes.dto.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.sql.*;



public class oesTests {
    static Connection connection;
    



    @BeforeAll
    static void beforeAll() {
        try {
            connection = DBConnection.getConnection();
            System.out.println("Database connection initialized");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to initialize database connection: " + e.getMessage());
        }
    }

    @BeforeEach
    void beforeEach() {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate("delete from member");
            stmt.executeUpdate("delete from question");
            stmt.executeUpdate("insert into member(userId, name, email) values (1, 'Test User', 'test@example.com')");
            stmt.executeUpdate(
                    "INSERT INTO question (questionId, questionText, optionA, optionB, optionC, optionD, correctAnswer) "
                            +
                            "VALUES (1, 'What is 2+2?', '3', '4', '5', '6', 'B')");
            stmt.close();
            System.out.println("Database cleared");
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to clear database: " + e.getMessage());
        }
    }

    @Test
    void testGetAllQuestions() {
        UserService service = new UserService();
        List<Question> questions = service.getAllQuestions();

        assertEquals(1, questions.size(), "Should return one question");
        Question q = questions.get(0);
        assertEquals(1, q.getQuestionId());
        assertEquals("What is 2+2?", q.getQuestionText());
        assertEquals("3", q.getOptionA());
        assertEquals("4", q.getOptionB());
        assertEquals("5", q.getOptionC());
        assertEquals("6", q.getOptionD());
        assertEquals("B", q.getCorrectAnswer());
    }

    @Test
    void testRegisterMember() throws SQLException {
        UserService service = new UserService();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM member WHERE userId = 1");
        assertTrue(rs.next(), "Member should be inserted");
        assertEquals("Alice", rs.getString("name"));
        assertEquals("alice@example.com", rs.getString("email"));
        rs.close();
        stmt.close();
    }

    @Test
    void testMemberInserted() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM member WHERE userId = 1");
        assertTrue(rs.next(), "Default member should be present");
        assertEquals("Test User", rs.getString("name"));
        assertEquals("test@example.com", rs.getString("email"));
        rs.close();
        stmt.close();
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }
}
