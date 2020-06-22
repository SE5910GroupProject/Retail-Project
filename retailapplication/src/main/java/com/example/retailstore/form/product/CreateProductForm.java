package com.example.retailstore.form.product;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class CreateProductForm {
	
	@NotNull(message = "Supplier ID cannot be null.")
	@Positive(message = "Supplier ID must be a positive integer.")
	private Integer supplierID;
	
	@NotNull(message = "Category ID cannot be null.")
	@Positive(message = "Category ID must be a positive integer.")
	private Integer categoryID;
	
	@NotNull(message = "Product Name cannot be null.")
	@Size(min=1, max=50, message = "Product Name must be between 1 and 50 characters long.")
	private String productName;
	
	@NotNull(message = "Unit Price cannot be null.")
	@Positive(message = "Unit Price must be a positive decimal.")
	private BigDecimal unitPrice;
	
	@NotNull(message = "Quantity per Unit cannot be null.")
	@Size(min=1, max=10, message = "Quantity per Unit must be between 1 and 10 characters long.")
	private String quantityPerUnit;
	
	@NotNull(message = "Units in Stock cannot be null.")
	@PositiveOrZero(message = "Units In Stock must be zero or a positive decimal.")
	private Integer unitsInStock;
	
	@PositiveOrZero(message = "Discount Percent must be zero or a positive integer.")
	private Integer discountPercent;
	
	@PositiveOrZero(message = "Product Status must be zero or a positive decimal.")
	private Integer productStatus;
	
	public Integer getSupplierID() {
		return supplierID;
	}
	
	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}
	
	public Integer getCategoryID() {
		return categoryID;
	}
	
	public void setCategoryID(Integer categoryID) {
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
	
	public Integer getUnitsInStock() {
		return unitsInStock;
	}
	
	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	
	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public Integer getProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	
}
