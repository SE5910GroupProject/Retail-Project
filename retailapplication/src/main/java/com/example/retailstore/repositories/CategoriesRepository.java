package com.example.retailstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Category;

@Repository("categoriesRepository")
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

	@Query(value = "SELECT * FROM categories c WHERE c.category_id >= ?1 AND c.category_id <= ?2", nativeQuery = true)
	List<Category> findCategoriesBetweenIdRange(int startIndex, int endIndex);
	
}
