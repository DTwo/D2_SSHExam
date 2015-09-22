package com.hand.Entity;

/**
 * OmNormalDiscount generated by hbm2java
 */
public class OmNormalDiscount implements java.io.Serializable {

	private Integer normalId;
	private Customer customer;
	private String discountName;
	private String type;
	private String discountBase;
	private Integer baseQty;
	private int discountRate;
	private String activity;

	public OmNormalDiscount() {
	}

	public OmNormalDiscount(Customer customer, String discountName, String type, String discountBase, int discountRate,
			String activity) {
		this.customer = customer;
		this.discountName = discountName;
		this.type = type;
		this.discountBase = discountBase;
		this.discountRate = discountRate;
		this.activity = activity;
	}

	public OmNormalDiscount(Customer customer, String discountName, String type, String discountBase, Integer baseQty,
			int discountRate, String activity) {
		this.customer = customer;
		this.discountName = discountName;
		this.type = type;
		this.discountBase = discountBase;
		this.baseQty = baseQty;
		this.discountRate = discountRate;
		this.activity = activity;
	}

	public Integer getNormalId() {
		return this.normalId;
	}

	public void setNormalId(Integer normalId) {
		this.normalId = normalId;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDiscountBase() {
		return this.discountBase;
	}

	public void setDiscountBase(String discountBase) {
		this.discountBase = discountBase;
	}

	public Integer getBaseQty() {
		return this.baseQty;
	}

	public void setBaseQty(Integer baseQty) {
		this.baseQty = baseQty;
	}

	public int getDiscountRate() {
		return this.discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
