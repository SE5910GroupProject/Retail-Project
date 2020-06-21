package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.Customer;

public interface CustomersService {

	void insertCustomer(Customer customer);
	
	List<Customer> retrieveAllCustomers();
	
	Customer retrieveCustomerByID(int id);
	
	void updateCustomer(Customer customer);

	void deleteCustomer(int id);

}
