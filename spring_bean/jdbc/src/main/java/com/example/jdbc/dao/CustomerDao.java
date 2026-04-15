package com.example.jdbc.dao;

import java.util.List;

import com.example.jdbc.model.Customer;

public interface CustomerDao {
	int addCustomer(Customer customer);

	int deposit(int accountNumber, double amount);

	int withdraw(int accountNumber, double amount);

	int transfer(int fromAccountNumber, int toAccountNumber, double amount);

	Customer findByAccountNumber(int accountNumber);

	List<Customer> findAll();
}
