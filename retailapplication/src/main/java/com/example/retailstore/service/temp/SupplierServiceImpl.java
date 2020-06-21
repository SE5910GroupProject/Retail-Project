package com.example.retailstore.service.temp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.temp.Supplier;
import com.example.retailstore.repositories.temp.SupplierRepository;

//@Service
public class SupplierServiceImpl {

	@Autowired
	private SupplierRepository supplierRepository;
	
	public void insertSupplier(
			String companyName
			, String contactName
			, String contactDesignation
			, int phoneNumber
			, String address
			, String city
			, int zipCode
			, String country) {
		supplierRepository.insertSupplier(companyName, contactName, contactDesignation, phoneNumber, address, city, zipCode, country);
	}
	
	public List<Supplier> retrieveSuppliers() {
		
		List<Supplier> suppliers = supplierRepository.retrieveSuppliers();
		
		return suppliers;
	}
	
	public void updateSupplier(
			int supplierID
			, String companyName
			, String contactName
			, String contactDesignation
			, int phoneNumber
			, String address
			, String city
			, int zipCode
			, String country) {
		supplierRepository.updateSupplier(supplierID, companyName, contactName, contactDesignation, phoneNumber, address, city, zipCode, country);
	}
	
	public void deleteSupplier(int supplierID) {
		supplierRepository.deleteSupplier(supplierID);
	}
	
}
