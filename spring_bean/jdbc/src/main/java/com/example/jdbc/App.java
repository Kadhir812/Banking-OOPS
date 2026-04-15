package com.example.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.jdbc.model.Customer;
import com.example.jdbc.service.customerService;

public class App {
	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				Scanner sc = new Scanner(System.in)) {

			customerService service = context.getBean("customerService", customerService.class);
			boolean running = true;

			while (running) {
				System.out.println("\n=== Banking Menu ===");
				System.out.println("1. Add New Customer");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Transfer");
				System.out.println("5. Show All Customers");
				System.out.println("6. Enquire ");
				System.out.println("7. Exit");

				int choice = readInt(sc, "Enter choice: ");

				switch (choice) {
				case 1 -> {
					Customer customer = new Customer();
					customer.setCustomerId(readInt(sc, "Enter Customer ID: "));
					System.out.print("Enter Customer Name: ");
					customer.setCustomerName(sc.nextLine().trim());
					customer.setAccountNumber(readInt(sc, "Enter Account Number: "));
					customer.setBalance(readDouble(sc, "Enter Opening Balance: "));

					int rows = service.addCustomer(customer);
					System.out.println(rows > 0 ? "Customer added successfully." : "Failed to add customer.");
				}
				case 2 -> {
					int accountNumber = readInt(sc, "Enter Account Number: ");
					double amount = readDouble(sc, "Enter Deposit Amount: ");
					int rows = service.deposit(accountNumber, amount);
					System.out.println(rows > 0 ? "Amount deposited successfully." : "Deposit failed.");
				}
				case 3 -> {
					int accountNumber = readInt(sc, "Enter Account Number: ");
					double amount = readDouble(sc, "Enter Withdraw Amount: ");
					int rows = service.withdraw(accountNumber, amount);
					System.out.println(rows > 0 ? "Amount withdrawn successfully." : "Withdraw failed.");
				}
				case 4 -> {
					int fromAccount = readInt(sc, "Enter From Account Number: ");
					int toAccount = readInt(sc, "Enter To Account Number: ");
					double amount = readDouble(sc, "Enter Transfer Amount: ");
					int rows = service.transfer(fromAccount, toAccount, amount);
					System.out.println(rows > 0 ? "Amount transferred successfully." : "Transfer failed.");
				}
				case 5 -> {
					List<Customer> customers = service.findAll();
					if (customers.isEmpty()) {
						System.out.println("No customers found.");
					} else {
						customers.forEach(System.out::println);
					}
				}
				case 6 -> {
					int accountNumber = readInt(sc, "Enter Account Number: ");
					Customer customer = service.findByAccountNumber(accountNumber);
					System.out.println(customer != null ? customer : "Customer not found.");
				}
				case 7 -> {
					running = false;
					System.out.println("Exiting application...");
				}
				default -> System.out.println("Invalid choice. Try again.");
				}
			}
		}
	}

	private static int readInt(Scanner sc, String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException ex) {
				System.out.println("Invalid number. Try again.");
			}
		}
	}

	private static double readDouble(Scanner sc, String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Double.parseDouble(sc.nextLine().trim());
			} catch (NumberFormatException ex) {
				System.out.println("Invalid amount. Try again.");
			}
		}
	}
}
