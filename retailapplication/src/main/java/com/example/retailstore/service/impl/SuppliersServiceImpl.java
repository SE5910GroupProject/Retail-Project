package com.example.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.Supplier;
import com.example.retailstore.repositories.SuppliersRepository;
import com.example.retailstore.service.SuppliersService;

@Service("suppliersService")
public class SuppliersServiceImpl implements SuppliersService {

	@Autowired
	SuppliersRepository suppliersRepository;
	
	@Override
	public void insertSupplier(Supplier supplier) {
		//Can return, maybe do something with it?
		if( !suppliersRepository.existsById(supplier.getSupplierID()) ) {
			suppliersRepository.save(supplier);
		}
	}

	@Override
	public List<Supplier> retrieveAllSuppliers() { 
		return suppliersRepository.findAll();
	}
	
	@Override
	public List<Supplier> retrieveSuppliersBetweenIdRange(int startIndex, int endIndex) {
		return suppliersRepository.findSuppliersBetweenIdRange(startIndex, endIndex);
	}
	
	@Override
	public Supplier retrieveSupplierByID(int id) {
		Optional<Supplier> supplier = suppliersRepository.findById(id);
		
		if(supplier.isPresent()) {
			return supplier.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void updateSupplier(Supplier supplier) {
		//ADD CONFIRMATION TO NOT ALLOW INSERTING
		if( suppliersRepository.existsById(supplier.getSupplierID()) ) {
			suppliersRepository.save(supplier);
		}
		
	}

	@Override
	public void deleteSupplier(int id) {
		if(suppliersRepository.existsById(id)) {
			suppliersRepository.deleteById(id);
		}
	}

}
