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
	
	@Override
	public void insertProduct(Product product) {
		//Can return, maybe do something with it?
		if( !productsRepository.existsById(product.getProductID()) ) {
			productsRepository.save(product);
		}
	}

	@Override
	public List<Product> retrieveAllProducts() { 
		return productsRepository.findAll();
	}
	
	@Override
	public List<Product> retrieveProductsBetweenIdRange(int startIndex, int endIndex) {
		return productsRepository.findProductsBetweenIdRange(startIndex, endIndex);
	}
	
	
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

	@Override
	public void updateProduct(Product product) {
		//ADD CONFIRMATION TO NOT ALLOW INSERTING
		Optional<Product> product2 = productsRepository.findById(product.getProductID());
		
		if( product2.isPresent() ) {
			product.setVersion(product2.get().getVersion());
			productsRepository.save(product);
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		if(productsRepository.existsById(id)) {
			productsRepository.deleteById(id);
		}
	}

}
