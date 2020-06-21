package com.example.retailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Supplier;

@Repository("supplierRepository")
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
