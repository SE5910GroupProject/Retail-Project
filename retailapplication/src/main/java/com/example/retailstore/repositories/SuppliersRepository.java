package com.example.retailstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Supplier;

@Repository("suppliersRepository")
public interface SuppliersRepository extends JpaRepository<Supplier, Integer> {

	@Query(value = "SELECT * FROM suppliers c WHERE c.suppliers_id >= ?1 AND c.suppliers_id <= ?2", nativeQuery = true)
	List<Supplier> findSuppliersBetweenIdRange(int startIndex, int endIndex);
	
	
}
