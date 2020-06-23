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
	
	/**
	 * Attempts to create a new row in the Suppliers table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param supplier the object to be inserted into the database
	 */
	@Override
	public void insertSupplier(Supplier supplier) {
		//Can return, maybe do something with it?
		if( !suppliersRepository.existsById(supplier.getSupplierID()) ) {
			suppliersRepository.save(supplier);
		}
	}

	/**
	 * Retrieves all rows from the Suppliers table.
	 * 
	 * @return List
	 */
	@Override
	public List<Supplier> retrieveAllSuppliers() { 
		return suppliersRepository.findAll();
	}
	
	/**
	 * Retrieves all rows from the Suppliers table contained between the provided indexes.
	 *
	 * @param startIndex The starting index (inclusive) to be retrieved
	 * @param endIndex   The ending index (inclusive) to be retrieved
	 * @return Collection
	 */
	@Override
	public List<Supplier> retrieveSuppliersBetweenIdRange(int startIndex, int endIndex) {
		//In the future, this should throw an exception, but for the time being, this is fine as is.
		if(endIndex < startIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			startIndex = temp;
		}
		
		return suppliersRepository.findSuppliersBetweenIdRange(startIndex, endIndex);
	}
	
	/**
	 * Retrieves a specific row from the Suppliers table by the ID provided
	 *
	 * @param id The primary key of the row being searched for.
	 * @return Supplier if found, null if not found
	 */
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

	/**
	 * Updates a specific row in the Suppliers table.
	 * If present, changes the version number and updates the row, otherwise, it does not update.
	 *
	 * @param supplier The object being updated
	 */
	@Override
	public void updateSupplier(Supplier supplier) {
		Optional<Supplier> supplier2 = suppliersRepository.findById(supplier.getSupplierID());
		
		if( supplier2.isPresent() ) {
			supplier.setVersion(supplier2.get().getVersion());
			suppliersRepository.save(supplier);
		}
		
	}

	/**
	 * Performs a hard-delete on a row in the Suppliers table by a specific ID.
	 * Checks if a row corresponds with the given ID first. If so, continue, otherwise do nothing.
	 * 
	 * @param id The id of the row to be removed
	 */
	@Override
	public void deleteSupplier(int id) {
		if(suppliersRepository.existsById(id)) {
			suppliersRepository.deleteById(id);
		}
	}

}
