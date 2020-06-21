package com.example.retailstore.service.temp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.temp.Product;
import com.example.retailstore.repositories.temp.ProductsRepository;

//@Service
public class ProductsServiceImpl {

	@Autowired
	private ProductsRepository productRepository;
	
	public void insertProduct(
			  int supplierID
			, int categoryID
			, String productName
			, BigDecimal unitPrice
			, String quantityPerUnit
			, int unitsInStock
			, int discountPercent
			, int productStatus) {
		productRepository.insertProduct(supplierID, categoryID, productName, unitPrice, quantityPerUnit, unitsInStock, discountPercent, productStatus);
	}
	
	public List<Product> retrieveProducts() {
		
		List<Product> products = productRepository.retrieveProducts();
		
		return products;
	}
	
	public void updateProduct(
			  int productID
			, int supplierID
			, int categoryID
			, String productName
			, BigDecimal unitPrice
			, String quantityPerUnit
			, int unitsInStock
			, int discountPercent
			, int productStatus) {
		productRepository.updateProduct(productID, supplierID, categoryID, productName, unitPrice, quantityPerUnit, unitsInStock, discountPercent, productStatus);
	}
	
	public void deleteProduct(int productID) {
		productRepository.deleteProduct(productID);
	}
	
}
