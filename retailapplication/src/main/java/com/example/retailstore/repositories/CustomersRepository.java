package com.example.retailstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Customer;

@Repository("customersRepository")
public interface CustomersRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "SELECT * FROM customers c WHERE c.customer_id >= ?1 AND c.customer_id <= ?2", nativeQuery = true)
	List<Customer> findCustomersBetweenIdRange(int startIndex, int endIndex);
	
	
}
