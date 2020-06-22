package com.example.retailstore.form.category;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCategoryForm {
	
	@NotNull(message = "Category Name cannot be null.")
	@Size(min=1, max=30, message = "Category Name must be between 1 and 30 characters long.")
	private String categoryName;
	
	@Size(min=0, max=50, message = "Description must be between 0 and 50 characters long.")
	private String description;
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
