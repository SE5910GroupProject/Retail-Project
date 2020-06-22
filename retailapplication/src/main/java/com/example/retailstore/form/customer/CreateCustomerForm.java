package com.example.retailstore.form.customer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CreateCustomerForm {
	
	@NotNull(message = "First Name cannot be null.")
	@Size(min=1, max=30, message = "First Name must be between 1 and 30 characters long.")
	private String firstName;
	
	@Size(max=30, message = "Last Name must be between 1 and 30 characters long.")
	private String lastName;
	
	private String address;
	
	@Size(max=20, message = "City must be between 1 and 20 characters long.")
	private String city;
	
	@Positive(message = "Zip Code must be positive.")
	private Integer zipCode;
	
	@Size(max=32, message = "Country must be between 1 and 32 characters long.")
	private String country;
	
	@Positive(message = "Phone Number must be positive.")
	private Long phoneNumber;
	
	private String birthDate;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
