package com.hand.Entity;
// Generated 2015-9-17 12:06:09 by Hibernate Tools 3.4.0.CR1

/**
 * OmSpecialDiscount generated by hbm2java
 */
public class OmSpecialDiscount implements java.io.Serializable {

	private Integer specialId;
	private Customer customer;
	private String discountName;
	private String custCode;
	private String amount;
	private Integer appliedAmount;
	private int balance;
	private String activity;

	public OmSpecialDiscount() {
	}

	public OmSpecialDiscount(Customer customer, String discountName, String custCode, String amount, int balance,
			String activity) {
		this.customer = customer;
		this.discountName = discountName;
		this.custCode = custCode;
		this.amount = amount;
		this.balance = balance;
		this.activity = activity;
	}

	public OmSpecialDiscount(Customer customer, String discountName, String custCode, String amount,
			Integer appliedAmount, int balance, String activity) {
		this.customer = customer;
		this.discountName = discountName;
		this.custCode = custCode;
		this.amount = amount;
		this.appliedAmount = appliedAmount;
		this.balance = balance;
		this.activity = activity;
	}

	public Integer getSpecialId() {
		return this.specialId;
	}

	public void setSpecialId(Integer specialId) {
		this.specialId = specialId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDiscountName() {
		return this.discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Integer getAppliedAmount() {
		return this.appliedAmount;
	}

	public void setAppliedAmount(Integer appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
