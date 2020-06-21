package com.example.retailstore.model.temp;

import java.math.BigDecimal;

public class Product {

	private int productID;
	private int supplierID;
	private int categoryID;
	private String productName;
	private BigDecimal unitPrice;
	private String quantityPerUnit;
	private int unitsInStock;
	private int discountPercent;
	private int productStatus;
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getSupplierID() {
		return supplierID;
	}
	
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
	
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}
	
	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
	
	public int getUnitsInStock() {
		return unitsInStock;
	}
	
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	
	public int getDiscountPercent() {
		return discountPercent;
	}
	
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public int getProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
}
