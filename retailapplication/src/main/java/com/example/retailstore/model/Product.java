package com.example.retailstore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;

	@Column(name = "supplier_id", nullable = false)
	private Integer supplierID;

	@Column(name = "category_id", nullable = false)
	private Integer categoryID;

	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "unit_price", nullable = false)
	private BigDecimal unitPrice;

	@Column(name = "quantity_per_unit", nullable = false)
	private Integer quantityPerUnit;

	@Column(name = "units_in_stock", nullable = false)
	private Integer unitsInStock;

	@Column(name = "discount_percent")
	private Integer discountPercent;

	@Column(name = "product_status")
	private Integer productStatus;

	
	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
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
	
}
