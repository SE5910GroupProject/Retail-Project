package com.example.retailstore.form.order;

public class UpdateOrderForm {

	private int orderID;
	private Integer customerID;
	private Integer userID;
	private String purchaseDate;
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
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
