package com.example.retailstore.form.customer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DeleteCustomerForm {
	
	@NotNull(message = "Customer ID cannot be null.")
	@Positive(message = "Customer ID must be a positive integer.")
	private Integer customerID;
	
	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	
}
