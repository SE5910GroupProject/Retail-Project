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
	
	/**
	 * Attempts to create a new row in the Orders table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param order the object to be inserted into the database
	 */
	@Override
	public void insertOrder(Order order) {
		if( !ordersRepository.existsById(order.getOrderID()) ) {
			ordersRepository.save(order);
		}
	}

	/**
	 * Retrieves all rows from the Orders table.
	 * 
	 * @return List
	 */
	@Override
	public List<Order> retrieveAllOrders() { 
		return ordersRepository.findAll();
	}
	
	/**
	 * Retrieves all rows from the Orders table contained between the provided indexes.
	 *
	 * @param startIndex The starting index (inclusive) to be retrieved
	 * @param endIndex   The ending index (inclusive) to be retrieved
	 * @return Collection
	 */
	@Override
	public List<Order> retrieveOrdersBetweenIdRange(int startIndex, int endIndex) {
		//In the future, this should throw an exception, but for the time being, this is fine as is.
		if(endIndex < startIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			startIndex = temp;
		}
		
		return ordersRepository.findOrdersBetweenIdRange(startIndex, endIndex);
	}
	
	/**
	 * Retrieves a specific row from the Orders table by the ID provided
	 *
	 * @param id The primary key of the row being searched for.
	 * @return Order if found, null if not found
	 */
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

	/**
	 * Updates a specific row in the Orders table.
	 * If present, changes the version number and updates the row, otherwise, it does not update.
	 *
	 * @param orders The object being updated
	 */
	@Override
	public void updateOrder(Order order) {
		Optional<Order> order2 = ordersRepository.findById(order.getOrderID());
		
		if( order2.isPresent() ) {
			order.setVersion(order2.get().getVersion());
			ordersRepository.save(order);
		}
		
	}

	/**
	 * Performs a hard-delete on a row in the Orders table by a specific ID.
	 * Checks if a row corresponds with the given ID first. If so, continue, otherwise do nothing.
	 * 
	 * @param id The id of the row to be removed
	 */
	@Override
	public void deleteOrder(int id) {
		if(ordersRepository.existsById(id)) {
			ordersRepository.deleteById(id);
		}
	}

}
