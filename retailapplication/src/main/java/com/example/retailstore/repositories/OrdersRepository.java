package com.example.retailstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Order;

@Repository("ordersRepository")
public interface OrdersRepository extends JpaRepository<Order, Integer> {

	@Query(value = "SELECT * FROM orders c WHERE c.orders_id >= ?1 AND c.orders_id <= ?2", nativeQuery = true)
	List<Order> findOrdersBetweenIdRange(int startIndex, int endIndex);
	
}
