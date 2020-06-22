package com.example.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.Customer;
import com.example.retailstore.repositories.CustomersRepository;
import com.example.retailstore.service.CustomersService;

@Service("customersService")
public class CustomersServiceImpl implements CustomersService {

	@Autowired
	CustomersRepository customersRepository;
	
	@Override
	public void insertCustomer(Customer customer) {
		//Can return, maybe do something with it?
		if( !customersRepository.existsById(customer.getCustomerID()) ) {
			customersRepository.save(customer);
		}
	}

	@Override
	public List<Customer> retrieveAllCustomers() { 
		return customersRepository.findAll();
	}
	
	@Override
	public List<Customer> retrieveCustomersBetweenIdRange(int startIndex, int endIndex) {
		return customersRepository.findCustomersBetweenIdRange(startIndex, endIndex);
	}
	
	@Override
	public Customer retrieveCustomerByID(int id) {
		Optional<Customer> customer = customersRepository.findById(id);
		
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		//ADD CONFIRMATION TO NOT ALLOW INSERTING
		Optional<Customer> customer2 = customersRepository.findById(customer.getCustomerID());
		
		if( customer2.isPresent() ) {
			customer.setVersion(customer2.get().getVersion());
			customersRepository.save(customer);
		}
		
	}

	@Override
	public void deleteCustomer(int id) {
		if(customersRepository.existsById(id)) {
			customersRepository.deleteById(id);
		}
	}

}
