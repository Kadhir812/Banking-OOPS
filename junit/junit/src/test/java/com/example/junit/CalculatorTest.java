package com.example.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
       
    @Test
    void testAdd() {
         Calculator cal = new Calculator();
        int r = cal.add(10, 4);
        assertEquals(14, r);
    }

    @Test
    void testSubtract() {
        Calculator cal = new Calculator();
        int r = cal.subtract(10, 4);
        assertEquals(6, r);
    }

    @Test
    void testGrade(){
        Calculator cal = new Calculator();
        assertEquals("PASS", cal.calculateGrade(90));
    }

    @Test
    void ageTest() {
        Calculator cal1 = new Calculator();
        boolean f = cal1.checkAge(21);
        assertEquals(true, f);
    }

    @Test
    void expTest() {
        Calculator cal = new Calculator();
        boolean f = cal.checkExperience(2);
        assertEquals(true,f);
    }

    @Test
    void testNull() {
        Calculator cal = new Calculator();
        String nameNull = null;
        String nameNonNull = "kad";
        assertNull(cal.checkName(nameNull));
        assertEquals("kad", cal.checkName(nameNonNull));
    }
}
