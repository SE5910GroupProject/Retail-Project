package com.example.retailstore.service.temp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.temp.Order;
import com.example.retailstore.repositories.temp.OrdersRepository;

//@Service
public class OrdersServiceImpl {

	@Autowired
	private OrdersRepository orderRepository;
	
	public void insertOrder(int customerID, int userID, Date purchaseDate) {
		orderRepository.insertOrder(customerID, userID, purchaseDate);
	}
	
	public List<Order> retrieveOrders() {
		
		List<Order> orders = orderRepository.retrieveOrders();
		
		return orders;
	}
	
	public void updateOrder(int orderID, int customerID, int userID, Date purchaseDate) {
		orderRepository.updateOrder(orderID, customerID, userID, purchaseDate);
	}
	
	public void deleteOrder(int orderID) {
		orderRepository.deleteOrder(orderID);
	}
	
}
