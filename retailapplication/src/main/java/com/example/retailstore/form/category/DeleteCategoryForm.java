package com.example.retailstore.form.category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class DeleteCategoryForm {

	@NotNull(message = "Category ID cannot be null.")
	@Positive(message = "Category ID must be a positive integer.")
	private Integer categoryID;
	
	public Integer getCategoryID() {
		return categoryID;
	}
	
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	
}
