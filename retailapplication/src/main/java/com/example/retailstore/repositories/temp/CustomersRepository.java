package com.example.retailstore.repositories.temp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.temp.Customer;

//@Repository
public class CustomersRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
	public void insertCustomer(String firstName
			, String lastName
			, String address
			, String city
			, String zipCode
			, String country
			, int phoneNumber
			, Date birthDate) {
    	String sql = "INSERT INTO customers VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				ps.setString(1, firstName);
				ps.setString(2, lastName);
				ps.setString(3, address);
				ps.setString(4, city);
				ps.setString(5, zipCode);
				ps.setString(6, country);
				ps.setInt(7, phoneNumber);
				ps.setObject(8, birthDate);
				return ps.execute();
			}
    		
    	});
	}
	
	public List<Customer> retrieveCustomers() {
		String sql = "SELECT customer_id AS customerID "
				+ ", customer_name AS customerName"
				+ ", first_name AS firstName"
				+ ", last_name AS lastName"
				+ ", address AS address"
				+ ", city AS city"
				+ ", zip_code AS zipCode"
				+ ", country AS country"
				+ ", phone_number AS phoneNumber"
				+ ", birth_date AS birthDate"
				+ " FROM customers";
		
		List<Customer> customers = jdbcTemplate.queryForList(sql, Customer.class);
		
		return customers;
	}
	
	public void updateCustomer(int customerID
			, String firstName
			, String lastName
			, String address
			, String city
			, String zipCode
			, String country
			, int phoneNumber
			, Date birthDate) {
		String sql = "UPDATE customers SET "
				+ "first_name = ?"
				+ ", last_name = ?"
				+ ", address = ?"
				+ ", city= ?"
				+ ", zip_code= ?"
				+ ", country = ?"
				+ ", phone_number = ?"
				+ ", birth_date = ?"
				+ " WHERE customer_id = ?";
	
		jdbcTemplate.update(sql, firstName, lastName, address, city, zipCode, country, phoneNumber, birthDate, customerID);
	
	}
	
	public void deleteCustomer(int customerID) {
		String sql = "DELETE FROM customers WHERE customer_id = ?";
		jdbcTemplate.update(sql, customerID);
	}
	
}
