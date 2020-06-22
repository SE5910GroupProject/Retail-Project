package com.example.retailstore.form.order;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CreateOrderForm {

	@NotNull(message = "Customer ID cannot be null.")
	@Positive(message = "Customer ID must be a positive integer.")
	private Integer customerID;
	
	@NotNull(message = "User ID cannot be null.")
	@Positive(message = "User ID must be a positive integer.")
	private Integer userID;
	
	@NotNull(message = "Purchase Date cannot be null.")
	private String purchaseDate;
	
	
	public Integer getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}
	
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
}
