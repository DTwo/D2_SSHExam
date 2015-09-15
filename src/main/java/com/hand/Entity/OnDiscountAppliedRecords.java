package com.hand.Entity;
// Generated 2015-9-15 16:38:44 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * OnDiscountAppliedRecords generated by hbm2java
 */
public class OnDiscountAppliedRecords implements java.io.Serializable {

	private Integer appliedId;
	private Customer customer;
	private String dicountName;
	private String custCode;
	private String adnIdentifyNum;
	private int appliedAmount;
	private Date appliedDate;
	private Integer cancel;
	private Date cancelDate;

	public OnDiscountAppliedRecords() {
	}

	public OnDiscountAppliedRecords(Customer customer, String dicountName, String custCode, String adnIdentifyNum,
			int appliedAmount, Date appliedDate) {
		this.customer = customer;
		this.dicountName = dicountName;
		this.custCode = custCode;
		this.adnIdentifyNum = adnIdentifyNum;
		this.appliedAmount = appliedAmount;
		this.appliedDate = appliedDate;
	}

	public OnDiscountAppliedRecords(Customer customer, String dicountName, String custCode, String adnIdentifyNum,
			int appliedAmount, Date appliedDate, Integer cancel, Date cancelDate) {
		this.customer = customer;
		this.dicountName = dicountName;
		this.custCode = custCode;
		this.adnIdentifyNum = adnIdentifyNum;
		this.appliedAmount = appliedAmount;
		this.appliedDate = appliedDate;
		this.cancel = cancel;
		this.cancelDate = cancelDate;
	}

	public Integer getAppliedId() {
		return this.appliedId;
	}

	public void setAppliedId(Integer appliedId) {
		this.appliedId = appliedId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDicountName() {
		return this.dicountName;
	}

	public void setDicountName(String dicountName) {
		this.dicountName = dicountName;
	}

	public String getCustCode() {
		return this.custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getAdnIdentifyNum() {
		return this.adnIdentifyNum;
	}

	public void setAdnIdentifyNum(String adnIdentifyNum) {
		this.adnIdentifyNum = adnIdentifyNum;
	}

	public int getAppliedAmount() {
		return this.appliedAmount;
	}

	public void setAppliedAmount(int appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public Date getAppliedDate() {
		return this.appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Integer getCancel() {
		return this.cancel;
	}

	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

	public Date getCancelDate() {
		return this.cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

}
