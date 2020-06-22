package com.example.retailstore.form.orderdetails;

import java.math.BigDecimal;

public class UpdateOrderDetailsForm {
	
	private int orderDetailsID;
	private Integer orderID;
	private Integer productID;
	private Integer quantity;
	private BigDecimal unitPrice;
	private BigDecimal discount;
	
	public int getOrderDetailsID() {
		return orderDetailsID;
	}
	
	public void setOrderDetailsID(int orderDetailsID) {
		this.orderDetailsID = orderDetailsID;
	}
	
	public Integer getOrderID() {
		return orderID;
	}
	
	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}
	
	public Integer getProductID() {
		return productID;
	}
	
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
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
