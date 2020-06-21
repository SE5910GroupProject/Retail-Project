package com.example.retailstore.form.product;

import javax.validation.constraints.NotNull;

public class DeleteProductForm {
	
	@NotNull(message = "Product ID must not be null.")
	private Integer productID;

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
}
