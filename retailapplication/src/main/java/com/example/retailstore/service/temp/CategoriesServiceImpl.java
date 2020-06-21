package com.example.retailstore.service.temp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.temp.Category;
import com.example.retailstore.repositories.temp.CategoriesRepository;

//@Service
public class CategoriesServiceImpl {

	@Autowired
	private CategoriesRepository categoryRepository;
	
	public void insertCategory(String categoryName, String description) {
		categoryRepository.insertCategory(categoryName, description);
	}
	
	public List<Category> retrieveCategories() {
		
		List<Category> categorys = categoryRepository.retrieveCategories();
		
		return categorys;
	}
	
	public void updateCategory(int categoryID, String categoryName, String description) {
		categoryRepository.updateCategory(categoryID, categoryName, description);
	}
	
	public void deleteCategory(int categoryID) {
		categoryRepository.deleteCategory(categoryID);
	}
	
}
