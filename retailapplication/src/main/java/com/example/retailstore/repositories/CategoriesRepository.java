package com.example.retailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Category;

@Repository("categoriesRepository")
public interface CategoriesRepository extends JpaRepository<Category, Integer> {

}
