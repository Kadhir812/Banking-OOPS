package com.example.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.example.jdbc.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int addCustomer(Customer customer) {
		String sql = "insert into icic (customer_id, customer_name, account_number, balance) values (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, customer.getCustomerId(), customer.getCustomerName(), customer.getAccountNumber(),
				customer.getBalance());
	}

	@Override
	public int deposit(int accountNumber, double amount) {
		String sql = "update icic set balance = balance + ? where account_number = ?";
		return jdbcTemplate.update(sql, amount, accountNumber);
	}

	@Override
	public int withdraw(int accountNumber, double amount) {
		String sql = "update icic set balance = balance - ? where account_number = ? and balance >= ?";
		return jdbcTemplate.update(sql, amount, accountNumber, amount);
	}

	@Override
	public int transfer(int fromAccountNumber, int toAccountNumber, double amount) {
		int debited = withdraw(fromAccountNumber, amount);
		if (debited == 0) {
			return 0;
		}

		int credited = deposit(toAccountNumber, amount);
		if (credited == 0) {
			return 0;
		}

		return 1;
	}

	@Override
	public Customer findByAccountNumber(int accountNumber) {
		String sql = "select customer_id, customer_name, account_number, balance from icic where account_number = ?";
		return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setCustomerName(rs.getString("customer_name"));
			customer.setAccountNumber(rs.getInt("account_number"));
			customer.setBalance(rs.getDouble("balance"));
			return customer;
		}, accountNumber);
	}

	@Override
	public List<Customer> findAll() {
		String sql = "select customer_id, customer_name, account_number, balance from icic order by customer_id";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customer_id"));
			customer.setCustomerName(rs.getString("customer_name"));
			customer.setAccountNumber(rs.getInt("account_number"));
			customer.setBalance(rs.getDouble("balance"));
			return customer;
		});
	}
}
