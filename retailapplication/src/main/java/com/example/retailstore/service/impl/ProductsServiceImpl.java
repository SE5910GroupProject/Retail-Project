package com.example.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.Product;
import com.example.retailstore.repositories.ProductsRepository;
import com.example.retailstore.service.ProductsService;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductsRepository productsRepository;
	
	/**
	 * Attempts to create a new row in the Products table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param product the object to be inserted into the database
	 */
	@Override
	public void insertProduct(Product product) {
		if( !productsRepository.existsById(product.getProductID()) ) {
			productsRepository.save(product);
		}
	}

	/**
	 * Retrieves all rows from the Products table.
	 * 
	 * @return List
	 */
	@Override
	public List<Product> retrieveAllProducts() { 
		return productsRepository.findAll();
	}
	
	/**
	 * Retrieves all rows from the Products table contained between the provided indexes.
	 *
	 * @param startIndex The starting index (inclusive) to be retrieved
	 * @param endIndex   The ending index (inclusive) to be retrieved
	 * @return Collection
	 */
	@Override
	public List<Product> retrieveProductsBetweenIdRange(int startIndex, int endIndex) {
		//In the future, this should throw an exception, but for the time being, this is fine as is.
		if(endIndex < startIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			startIndex = temp;
		}
		
		return productsRepository.findProductsBetweenIdRange(startIndex, endIndex);
	}
	
	/**
	 * Retrieves a specific row from the Products table by the ID provided
	 *
	 * @param id The primary key of the row being searched for.
	 * @return Product if found, null if not found
	 */
	@Override
	public Product retrieveProductByID(int id) {
		Optional<Product> product = productsRepository.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}

	/**
	 * Updates a specific row in the Products table.
	 * If present, changes the version number and updates the row, otherwise, it does not update.
	 *
	 * @param product The object being updated
	 */
	@Override
	public void updateProduct(Product product) {
		Optional<Product> product2 = productsRepository.findById(product.getProductID());
		
		if( product2.isPresent() ) {
			product.setVersion(product2.get().getVersion());
			productsRepository.save(product);
		}
		
	}

	/**
	 * Performs a hard-delete on a row in the Products table by a specific ID.
	 * Checks if a row corresponds with the given ID first. If so, continue, otherwise do nothing.
	 * 
	 * @param id The id of the row to be removed
	 */
	@Override
	public void deleteProduct(int id) {
		if(productsRepository.existsById(id)) {
			productsRepository.deleteById(id);
		}
	}

}
