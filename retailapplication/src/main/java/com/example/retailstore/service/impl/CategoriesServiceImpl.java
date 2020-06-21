package com.example.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.Category;
import com.example.retailstore.repositories.CategoriesRepository;
import com.example.retailstore.service.CategoriesService;

@Service("categoriesService")
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Override
	public void insertCategory(Category category) {
		//Can return, maybe do something with it?
		if( !categoriesRepository.existsById(category.getCategoryID()) ) {
			categoriesRepository.save(category);
		}
	}

	@Override
	public List<Category> retrieveAllCategories() { 
		return categoriesRepository.findAll();
	}
	
	@Override
	public Category retrieveCategoryByID(int id) {
		Optional<Category> category = categoriesRepository.findById(id);
		
		if(category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void updateCategory(Category category) {
		//ADD CONFIRMATION TO NOT ALLOW INSERTING
		if( categoriesRepository.existsById(category.getCategoryID()) ) {
			categoriesRepository.save(category);
		}
		
	}

	@Override
	public void deleteCategory(int id) {
		if(categoriesRepository.existsById(id)) {
			categoriesRepository.deleteById(id);
		}
	}

}
