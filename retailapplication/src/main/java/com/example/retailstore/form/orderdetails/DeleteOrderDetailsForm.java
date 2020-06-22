package com.example.retailstore.form.orderdetails;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DeleteOrderDetailsForm {
	
	@NotNull(message = "Order Details ID cannot be null.")
	@Positive(message = "Order Details ID must be a positive integer.")
	private Integer orderDetailsID;

	public Integer getOrderDetailsID() {
		return orderDetailsID;
	}
	
	public void setOrderDetailsID(Integer orderDetailsID) {
		this.orderDetailsID = orderDetailsID;
	}
	
}
