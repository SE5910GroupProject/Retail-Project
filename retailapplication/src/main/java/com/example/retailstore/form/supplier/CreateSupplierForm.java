package com.example.retailstore.form.supplier;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateSupplierForm {
	
	@NotNull(message = "Company Name cannot be null.")
	@Size(min=1, max=50, message = "Company Name must be between 1 and 50 characters long.")
	private String companyName;
	
	@NotNull(message = "Contact Name cannot be null.")
	@Size(min=1, max=30, message = "Contact Name must be between 1 and 30 characters long.")
	private String contactName;
	
	@Size(min=1, max=30, message = "Contact Designation must be between 1 and 30 characters long.")
	private String contactDesignation;
	
	@NotNull(message = "Phone Number cannot be null.")
	@Positive(message = "Phone Number must be a positive integer.")
	private Long phoneNumber;
	
	private String address;
	
	@Size(min=1, max=20, message = "City must be between 1 and 20 characters long.")
	private String city;
	
	@Positive(message = "Zip Code must be a positive integer.")
	private Integer zipCode;
	
	@Size(min=1, max=15, message = "Country must be between 1 and 15 characters long.")
	private String country;

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getContactName() {
		return contactName;
	}
	
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public String getContactDesignation() {
		return contactDesignation;
	}
	
	public void setContactDesignation(String contactDesignation) {
		this.contactDesignation = contactDesignation;
	}
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public Integer getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
}
