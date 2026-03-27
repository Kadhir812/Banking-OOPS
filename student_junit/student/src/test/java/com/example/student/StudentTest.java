package com.example.student;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.student.Student;

public class StudentTest {
    @Test
    void testMarks() {
        Student service = new Student();
        assertEquals(80, service.getMarks());
    }

    @Test
    void testName() {
        Student service = new Student();
        assertNotNull(service.getName());
    }

    @Test
    void testCity() {
        Student service = new Student();
        assertNull(service.getCity());
    }

    @Test
    void testPass() {
        Student service = new Student();
        assertTrue(service.isPassed(50));
    }

    @Test
    void testFailPass() {
        Student service = new Student();
        assertFalse(service.isPassed(30));
    }
}
