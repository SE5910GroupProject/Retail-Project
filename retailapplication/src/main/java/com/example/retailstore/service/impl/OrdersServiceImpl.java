package com.example.retailstore.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retailstore.model.Order;
import com.example.retailstore.repositories.OrdersRepository;
import com.example.retailstore.service.OrdersService;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Override
	public void insertOrder(Order order) {
		//Can return, maybe do something with it?
		if( !ordersRepository.existsById(order.getOrderID()) ) {
			ordersRepository.save(order);
		}
	}

	@Override
	public List<Order> retrieveAllOrders() { 
		return ordersRepository.findAll();
	}
	
	@Override
	public Order retrieveOrderByID(int id) {
		Optional<Order> order = ordersRepository.findById(id);
		
		if(order.isPresent()) {
			return order.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void updateOrder(Order order) {
		//ADD CONFIRMATION TO NOT ALLOW INSERTING
		if( ordersRepository.existsById(order.getOrderID()) ) {
			ordersRepository.save(order);
		}
		
	}

	@Override
	public void deleteOrder(int id) {
		if(ordersRepository.existsById(id)) {
			ordersRepository.deleteById(id);
		}
	}

}
