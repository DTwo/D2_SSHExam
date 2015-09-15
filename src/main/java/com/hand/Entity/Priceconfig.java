package com.hand.Entity;
// Generated 2015-9-15 16:38:44 by Hibernate Tools 3.4.0.CR1

/**
 * Priceconfig generated by hbm2java
 */
public class Priceconfig implements java.io.Serializable {

	private int priceConfigId;
	private Customer customer;
	private String custCode;
	private String type;
	private String displayName;
	private String priveListCol;
	private Integer excelCol;
	private String activity;
	private int priceId;
	private Price price;

	public Priceconfig() {
	}

	public Priceconfig(Customer customer, String custCode, String type, String priveListCol, String activity,
			int priceId) {
		this.customer = customer;
		this.custCode = custCode;
		this.type = type;
		this.priveListCol = priveListCol;
		this.activity = activity;
		this.priceId = priceId;
	}

	public Priceconfig(Customer customer, String custCode, String type, String displayName, String priveListCol,
			Integer excelCol, String activity, int priceId, Price price) {
		this.customer = customer;
		this.custCode = custCode;
		this.type = type;
		this.displayName = displayName;
		this.priveListCol = priveListCol;
		this.excelCol = excelCol;
		this.activity = activity;
		this.priceId = priceId;
		this.price = price;
	}

	public int getPriceConfigId() {
		return this.priceConfigId;
	}

	public void setPriceConfigId(int priceConfigId) {
		this.priceConfigId = priceConfigId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPriveListCol() {
		return this.priveListCol;
	}

	public void setPriveListCol(String priveListCol) {
		this.priveListCol = priveListCol;
	}

	public Integer getExcelCol() {
		return this.excelCol;
	}

	public void setExcelCol(Integer excelCol) {
		this.excelCol = excelCol;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getPriceId() {
		return this.priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public Price getPrice() {
		return this.price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
