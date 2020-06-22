package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.Order;

public interface OrdersService {

	void insertOrder(Order order);

	List<Order> retrieveAllOrders();

	Order retrieveOrderByID(int id);

	void updateOrder(Order order);

	void deleteOrder(int id);

}
