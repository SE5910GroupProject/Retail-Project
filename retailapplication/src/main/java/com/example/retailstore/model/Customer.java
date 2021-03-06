package com.example.retailstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customers_id")
	private int customerID;
	
	@Column(name = "first_name", nullable = false, length = 30)
	private String firstName;
	
	@Column(name = "last_name", length = 30)
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city", length = 20)
	private String city;
	
	@Column(name = "zip_code")
	private Integer zipCode;
	
	@Column(name = "country", length = 32)
	private String country;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Column(name = "birth_day")
	private String birthDate;
	
	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Integer version = 0;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders.addAll(orders);
	}
	
	
	public String getDisplayNameText() {
		
		String displayName = "(" + customerID + ") " + firstName;
		if(lastName != null) {
			displayName += " " + lastName;
		}
		
		return displayName;
	}

}
