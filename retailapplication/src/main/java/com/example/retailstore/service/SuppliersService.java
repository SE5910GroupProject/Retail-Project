package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.Supplier;

public interface SuppliersService {

	void insertSupplier(Supplier supplier);
	
	List<Supplier> retrieveAllSuppliers();
	
	List<Supplier> retrieveSuppliersBetweenIdRange(int startIndex, int endIndex);
	
	Supplier retrieveSupplierByID(int id);
	
	void updateSupplier(Supplier supplier);

	void deleteSupplier(int id);

}
