
package com.example.junitlifecycle;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class BankTest {
    
    Bank bank;
    
	@BeforeAll
	static void connectToDatabase() {
        System.out.println("Connecting to database...");
	}
    
	@BeforeEach
	void setUp() {
        bank = new Bank(1500, "123456", "John Doe", "john@example.com");
	}
    
    @Test
    void testOpenAccount() {
        assertEquals(1500, bank.getBalance(), "Account should open with minimum balance 1500");
    }

    @Test
    void testDeposit() {
        bank.deposit(500);
        assertEquals(2000, bank.getBalance(), "Deposit should increase balance to 2000");
    }

    @Test
    void testWithdraw() {
        bank.withdraw(200);
        assertEquals(1300, bank.getBalance(), "Withdraw should decrease balance to 1300");
    }

    @AfterEach
    void cleanup() {
        bank = null;
        System.out.println(" Account Data Cleared ---");
    }

    @AfterAll
    static void tearDown() {
        System.out.println(" Database Connection Closed ---");
    }
}
