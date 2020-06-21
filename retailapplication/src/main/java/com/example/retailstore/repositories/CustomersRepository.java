package com.example.retailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Customer;

@Repository("customersRepository")
public interface CustomersRepository extends JpaRepository<Customer, Integer> {

}
