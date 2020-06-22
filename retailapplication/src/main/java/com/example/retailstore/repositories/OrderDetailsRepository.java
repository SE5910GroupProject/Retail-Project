package com.example.retailstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.OrderDetails;

@Repository("orderDetailsRepository")
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	@Query(value = "SELECT * FROM order_details c WHERE c.order_details_id >= ?1 AND c.order_details_id <= ?2", nativeQuery = true)
	List<OrderDetails> findOrderDetailsBetweenIdRange(int startIndex, int endIndex);
	
	
}
