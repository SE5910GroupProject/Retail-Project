package com.example.retailstore.form.order;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DeleteOrderForm {

	@NotNull(message = "Order ID cannot be null.")
	@Positive(message = "Order ID must be a positive integer.")
	private Integer orderID;
	
	public Integer getOrderID() {
		return orderID;
	}
	
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	
}
