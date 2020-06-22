package com.example.retailstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Product;

@Repository("productsRepository")
public interface ProductsRepository extends JpaRepository<Product, Integer>  {

	@Query(value = "SELECT * FROM products c WHERE c.product_id >= ?1 AND c.product_id <= ?2", nativeQuery = true)
	List<Product> findProductsBetweenIdRange(int startIndex, int endIndex);
	
}
