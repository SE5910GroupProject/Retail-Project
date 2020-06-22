package com.example.retailstore.form.orderdetails;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class CreateOrderDetailsForm {
	
	@NotNull(message = "Order ID cannot be null.")
	@Positive(message = "Order ID must be a positive integer.")
	private Integer orderID;
	
	@NotNull(message = "Product ID cannot be null.")
	@Positive(message = "Product ID must be a positive integer.")
	private Integer productID;
	
	@NotNull(message = "Quantity cannot be null.")
	@Positive(message = "Quantity must be a positive integer.")
	private Integer quantity;
	
	@NotNull(message = "Unit Price cannot be null.")
	@Positive(message = "Unit Price must be a positive integer.")
	private BigDecimal unitPrice;
	
	@PositiveOrZero(message = "Discount must be zero or a positive integer.")
	private BigDecimal discount;
	
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
