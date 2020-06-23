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
	
	/**
	 * Attempts to create a new row in the OrderDetails table.
	 * First checks if the object already exists. If so, do nothing, otherwise perform the insert.
	 *
	 * @param orderDetails the object to be inserted into the database
	 */
	@Override
	public void insertOrderDetails(OrderDetails orderDetails) {
		if( !orderDetailsRepository.existsById(orderDetails.getOrderDetailsID()) ) {
			orderDetailsRepository.save(orderDetails);
		}
	}

	/**
	 * Retrieves all rows from the OrderDetails table.
	 * 
	 * @return List
	 */
	@Override
	public List<OrderDetails> retrieveAllOrderDetails() { 
		return orderDetailsRepository.findAll();
	}
	
	/**
	* Retrieves all rows from the OrderDetails table contained between the provided indexes.
	*
	* @param startIndex The starting index (inclusive) to be retrieved
	* @param endIndex   The ending index (inclusive) to be retrieved
	* @return Collection
	*/
	public List<OrderDetails> retrieveOrderDetailsBetweenIdRange(int startIndex, int endIndex) {
		//In the future, this should throw an exception, but for the time being, this is fine as is.
		if(endIndex < startIndex) {
			int temp = startIndex;
			startIndex = endIndex;
			startIndex = temp;
		}
		
		return orderDetailsRepository.findOrderDetailsBetweenIdRange(startIndex, endIndex);
	}
	
	/**
	* Retrieves a specific row from the OrderDetails table by the ID provided
	*
	* @param id The primary key of the row being searched for. 
	* @return OrderDetails if found, null if not found
	*/
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

	/**
	* Updates a specific row in the OrderDetails table.
	* If present, changes the version number and updates, otherwise, it does not update update.
	*
	* @param orderDetails The object being updated
	*/
	@Override
	public void updateOrderDetails(OrderDetails orderDetails) {
		Optional<OrderDetails> orderDetails2 = orderDetailsRepository.findById(orderDetails.getOrderDetailsID());
		
		if(orderDetails2.isPresent()) {
			orderDetails.setVersion(orderDetails2.get().getVersion());
			orderDetailsRepository.save(orderDetails);
		}
		
	}

	/**
	* Performs a hard-delete on a row in the OrderDetails table by a specific ID.
	* Checks if a row corresponds with the given ID first. If so, continue, otherwise do nothing.
	* 
	* @param id The id of the row to be removed
	*/
	@Override
	public void deleteOrderDetails(int id) {
		if(orderDetailsRepository.existsById(id)) {
			orderDetailsRepository.deleteById(id);
		}
	}

}
