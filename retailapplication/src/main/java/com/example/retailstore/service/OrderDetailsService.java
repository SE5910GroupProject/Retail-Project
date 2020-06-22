package com.example.retailstore.service;

import java.util.List;

import com.example.retailstore.model.OrderDetails;

public interface OrderDetailsService {

	void insertOrderDetails(OrderDetails orderDetails);
	
	List<OrderDetails> retrieveAllOrderDetails();
	
	List<OrderDetails> retrieveOrderDetailsBetweenIdRange(int startIndex, int endIndex);
	
	OrderDetails retrieveOrderDetailsByID(int id);
	
	void updateOrderDetails(OrderDetails orderDetails);

	void deleteOrderDetails(int id);

}
