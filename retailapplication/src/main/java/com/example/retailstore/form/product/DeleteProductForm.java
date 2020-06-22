package com.example.retailstore.form.product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DeleteProductForm {
	
	@NotNull(message = "Product ID cannot be null.")
	@Positive(message = "Product ID must be a positive integer.")
	private Integer productID;

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
}
