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
	
	/**
	 * Attempts to create a new row in the Categories table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param orderDetails the object to be inserted into the database
	 */
	@Override
	public void insertCategory(Category category) {
		if( !categoriesRepository.existsById(category.getCategoryID()) ) {
			categoriesRepository.save(category);
		}
	}

	/**
	 * Retrieves all rows from the Categories table.
	 * 
	 * @return List
	 */
	@Override
	public List<Category> retrieveAllCategories() { 
		return categoriesRepository.findAll();
	}
	
	/**
	 * Retrieves all rows from the Categories table contained between the provided indexes.
	 *
	 * @param startIndex The starting index (inclusive) to be retrieved
	 * @param endIndex   The ending index (inclusive) to be retrieved
	 * @return Collection
	 */
	@Override
	public List<Category> retrieveCategoriesBetweenIdRange(int startIndex, int endIndex) {
		return categoriesRepository.findCategoriesBetweenIdRange(startIndex, endIndex);
	}
	
	/**
	 * Retrieves a specific row from the Categories table by the ID provided
	 *
	 * @param id The primary key of the row being searched for.
	 * @return Category if found, null if not found
	 */
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

	/**
	 * Updates a specific row in the Categories table.
	 * If present, changes the version number and updates the row, otherwise, it does not update.
	 *
	 * @param category The object being updated
	 */
	@Override
	public void updateCategory(Category category) {
		Optional<Category> category2 = categoriesRepository.findById(category.getCategoryID());
		
		if(category2.isPresent()) {
			category.setVersion(category2.get().getVersion());
			categoriesRepository.save(category);
		}
		
	}

	/**
	 * Performs a hard-delete on a row in the Categories table by a specific ID.
	 * Checks if a row corresponds with the given ID first. If so, continue, otherwise do nothing.
	 * 
	 * @param id The id of the row to be removed
	 */
	@Override
	public void deleteCategory(int id) {
		if(categoriesRepository.existsById(id)) {
			categoriesRepository.deleteById(id);
		}
	}

}
