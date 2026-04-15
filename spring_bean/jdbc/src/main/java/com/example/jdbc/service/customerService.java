package com.example.jdbc.service;

import java.util.List;

import com.example.jdbc.dao.CustomerDao;
import com.example.jdbc.model.Customer;

public class customerService {
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public int addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	public int deposit(int accountNumber, double amount) {
		if (amount <= 0) {
			return 0;
		}
		return customerDao.deposit(accountNumber, amount);
	}

	public int withdraw(int accountNumber, double amount) {
		if (amount <= 0) {
			return 0;
		}
		return customerDao.withdraw(accountNumber, amount);
	}

	public int transfer(int fromAccountNumber, int toAccountNumber, double amount) {
		if (amount <= 0) {
			return 0;
		}

		return customerDao.transfer(fromAccountNumber, toAccountNumber, amount);
	}

	public Customer findByAccountNumber(int accountNumber) {
		return customerDao.findByAccountNumber(accountNumber);
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	}
}
