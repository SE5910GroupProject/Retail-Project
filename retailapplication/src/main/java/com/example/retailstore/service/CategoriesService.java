package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.Category;

public interface CategoriesService {

	void insertCategory(Category category);
	
	List<Category> retrieveAllCategories();
	
	Category retrieveCategoryByID(int id);
	
	void updateCategory(Category category);

	void deleteCategory(int id);

}
