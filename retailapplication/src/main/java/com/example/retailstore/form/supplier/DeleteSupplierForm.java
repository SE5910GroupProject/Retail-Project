package com.example.retailstore.form.supplier;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DeleteSupplierForm {
	
	@NotNull(message = "Supplier ID cannot be null.")
	@Positive(message = "Supplier ID must be a positive integer.")
	private Integer supplierID;
	
	public Integer getSupplierID() {
		return supplierID;
	}
	
	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}
	
}
