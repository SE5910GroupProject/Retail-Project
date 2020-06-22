package com.example.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.OrderDetails;
import com.example.retailstore.repositories.OrderDetailsRepository;
import com.example.retailstore.service.OrderDetailsService;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Override
	public void insertOrderDetails(OrderDetails orderDetails) {
		//Can return, maybe do something with it?
		if( !orderDetailsRepository.existsById(orderDetails.getOrderDetailsID()) ) {
			orderDetailsRepository.save(orderDetails);
		}
	}

	@Override
	public List<OrderDetails> retrieveAllOrderDetails() { 
		return orderDetailsRepository.findAll();
	}
	
	@Override
	public OrderDetails retrieveOrderDetailsByID(int id) {
		Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(id);
		
		if(orderDetails.isPresent()) {
			return orderDetails.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void updateOrderDetails(OrderDetails orderDetails) {
		//ADD CONFIRMATION TO NOT ALLOW INSERTING
		if( orderDetailsRepository.existsById(orderDetails.getOrderDetailsID()) ) {
			orderDetailsRepository.save(orderDetails);
		}
		
	}

	@Override
	public void deleteOrderDetails(int id) {
		if(orderDetailsRepository.existsById(id)) {
			orderDetailsRepository.deleteById(id);
		}
	}

}
