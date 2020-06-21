package com.example.retailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Product;

@Repository("productsRepository")
public interface ProductsRepository extends JpaRepository<Product, Integer> {

}
