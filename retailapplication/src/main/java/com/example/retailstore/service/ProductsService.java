package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.Product;

public interface ProductsService {

	void insertProduct(Product product);
	
	List<Product> retrieveAllProducts();
	
	List<Product> retrieveProductsBetweenIdRange(int startIndex, int endIndex);
	
	Product retrieveProductByID(int id);
	
	void updateProduct(Product product);

	void deleteProduct(int id);

}
