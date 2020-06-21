package com.example.retailstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retailstore.model.Order;

@Repository("ordersRepository")
public interface OrdersRepository extends JpaRepository<Order, Integer> {

}
