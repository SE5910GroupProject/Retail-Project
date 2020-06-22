package com.example.retailstore.form.product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ShowProductForm {

	@NotNull(message = "From-ID must not be null.")
	@Positive(message = "From-ID must be a positive integer.")
	private Integer from;
	
	@NotNull(message = "To-ID must not be null.")
	@Positive(message = "To-ID must be a positive integer.")
	private Integer to;
	
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getTo() {
		return to;
	}
	public void setTo(Integer to) {
		this.to = to;
	}
	
}
