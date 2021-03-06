package com.hand.Entity;


import java.util.Date;

/**
 * Address generated by hbm2java
 */
public class Address implements java.io.Serializable {

	private int addressId;
	private Customer customer;
	private String country;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
	private String postcode;
	private String portOfDestination;
	private String shippingMark;
	private String status;
	private Date inactuveDate;

	public Address() {
	}

	public Address(Customer customer, String country, String portOfDestination, String shippingMark) {
		this.customer = customer;
		this.country = country;
		this.portOfDestination = portOfDestination;
		this.shippingMark = shippingMark;
	}

	public Address(Customer customer, String country, String state, String city, String addressLine1,
			String addressLine2, String postcode, String portOfDestination, String shippingMark, String status,
			Date inactuveDate) {
		this.customer = customer;
		this.country = country;
		this.state = state;
		this.city = city;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.postcode = postcode;
		this.portOfDestination = portOfDestination;
		this.shippingMark = shippingMark;
		this.status = status;
		this.inactuveDate = inactuveDate;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPortOfDestination() {
		return this.portOfDestination;
	}

	public void setPortOfDestination(String portOfDestination) {
		this.portOfDestination = portOfDestination;
	}

	public String getShippingMark() {
		return this.shippingMark;
	}

	public void setShippingMark(String shippingMark) {
		this.shippingMark = shippingMark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInactuveDate() {
		return this.inactuveDate;
	}

	public void setInactuveDate(Date inactuveDate) {
		this.inactuveDate = inactuveDate;
	}

}
