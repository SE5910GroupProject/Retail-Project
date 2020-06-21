package com.example.retailstore.model.temp;

import java.math.BigDecimal;

public class OrderDetails {

	private int orderID;
	private int productID;
	private int quantity;
	private BigDecimal unitPrice;
	private BigDecimal discount;
	
	public int getOrderID() {
		return orderID;
	}
	
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public BigDecimal getDiscount() {
		return discount;
	}
	
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	
}
