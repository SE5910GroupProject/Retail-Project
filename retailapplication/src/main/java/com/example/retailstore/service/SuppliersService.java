package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.Supplier;

public interface SuppliersService {

	void insertSupplier(Supplier supplier);
	
	List<Supplier> retrieveAllSuppliers();
	
	Supplier retrieveSupplierByID(int id);
	
	void updateSupplier(Supplier supplier);

	void deleteSupplier(int id);

}
