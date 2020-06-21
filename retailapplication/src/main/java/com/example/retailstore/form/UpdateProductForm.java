package com.example.retailstore.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateProductForm {
	
	@NotNull(message = "Product ID must not be null.")
	private Integer productID;
	
	@NotNull(message = "Supplier ID must not be null.")
	private Integer supplierID;
	
	@NotNull(message = "Category ID must not be null.")
	private Integer categoryID;
	
	@NotNull(message = "Product Name must not be null.")
	@Size(min=1, max=50, message = "Product Name must be between 1 and 50 characters long.")
	private String productName;
	
	@NotNull(message = "Unit Price must not be null.")
	private BigDecimal unitPrice;
	
	@NotNull(message = "Quantity per Unit must not be null.")
	private Integer quantityPerUnit;
	
	@NotNull(message = "Units in Stock must not be null.")
	private Integer unitsInStock;
	
	private Integer discountPercent;
	private Integer productStatus;
	
	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
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
	
	public Integer getQuantityPerUnit() {
		return quantityPerUnit;
	}
	
	public void setQuantityPerUnit(Integer quantityPerUnit) {
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
