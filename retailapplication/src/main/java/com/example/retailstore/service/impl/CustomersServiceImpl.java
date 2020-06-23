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
	
	/**
	 * Attempts to create a new row in the Customer table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param customer the object to be inserted into the database
	 */
	@Override
	public void insertCustomer(Customer customer) {
		if( !customersRepository.existsById(customer.getCustomerID()) ) {
			customersRepository.save(customer);
		}
	}

	/**
	* Retrieves all rows from the Customers table.
	* 
	* @return List
	*/
	@Override
	public List<Customer> retrieveAllCustomers() { 
		return customersRepository.findAll();
	}
	
	/**
	* Retrieves all rows from the Customers table contained between the provided indexes.
	*
	* @param startIndex The starting index (inclusive) to be retrieved
	* @param endIndex   The ending index (inclusive) to be retrieved
	* @return List
	*/
	@Override
	public List<Customer> retrieveCustomersBetweenIdRange(int startIndex, int endIndex) {
		//In the future, this should throw an exception, but for the time being, this is fine as is.
		if(endIndex < startIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			startIndex = temp;
		}
		
		return customersRepository.findCustomersBetweenIdRange(startIndex, endIndex);
	}
	
	
	/**
	* Retrieves a specific row from the Customers table by the ID provided
	*
	* @param id The primary key of the row being searched for. 
	* @return Customer if found, null if not found
	*/
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

	/**
	* Updates a specific row in the Customers table.
	* If present, changes the version number and updates, otherwise, it does not update.
	*
	* @param customer The object being updated
	*/
	@Override
	public void updateCustomer(Customer customer) {
		Optional<Customer> customer2 = customersRepository.findById(customer.getCustomerID());
		
		if( customer2.isPresent() ) {
			customer.setVersion(customer2.get().getVersion());
			customersRepository.save(customer);
		}
		
	}

	/**
	* Performs a hard-delete on a row in the Customer table by a specific ID.
	* Checks if a row corresponds with the given ID first. If so, continue, otherwise do nothing.
	* 
	* @param id The id of the Category being deleted
	*/
	@Override
	public void deleteCustomer(int id) {
		if(customersRepository.existsById(id)) {
			customersRepository.deleteById(id);
		}
	}

}
