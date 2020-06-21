package com.example.retailstore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_details_id")
	private int id;
	
	@Column(name = "order_id", nullable = false)
	private int orderID;
	
	@Column(name = "product_id", nullable = false)
	private int product_id;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@Column(name = "unit_price", nullable = false)
	private BigDecimal unitPrice;
	
	@Column(name = "discount")
	private BigDecimal discount;
	
	
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

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
}
