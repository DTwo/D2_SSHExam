package com.hand.Entity;
// Generated 2015-9-15 16:38:44 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Integer customerId;
	private Organization organization;
	private String customerCode;
	private String type;
	private String groupCompany;
	private String corporation;
	private Set payments = new HashSet(0);
	private Set omSpecialDiscounts = new HashSet(0);
	private Address address;
	private Linkman linkman;
	private Set onDiscountAppliedRecordses = new HashSet(0);
	private Set omNormalDiscounts = new HashSet(0);
	private Priceconfig priceconfig;

	public Customer() {
	}

	public Customer(Organization organization, String customerCode, String type) {
		this.organization = organization;
		this.customerCode = customerCode;
		this.type = type;
	}

	public Customer(Organization organization, String customerCode, String type, String groupCompany,
			String corporation, Set payments, Set omSpecialDiscounts, Address address, Linkman linkman,
			Set onDiscountAppliedRecordses, Set omNormalDiscounts, Priceconfig priceconfig) {
		this.organization = organization;
		this.customerCode = customerCode;
		this.type = type;
		this.groupCompany = groupCompany;
		this.corporation = corporation;
		this.payments = payments;
		this.omSpecialDiscounts = omSpecialDiscounts;
		this.address = address;
		this.linkman = linkman;
		this.onDiscountAppliedRecordses = onDiscountAppliedRecordses;
		this.omNormalDiscounts = omNormalDiscounts;
		this.priceconfig = priceconfig;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGroupCompany() {
		return this.groupCompany;
	}

	public void setGroupCompany(String groupCompany) {
		this.groupCompany = groupCompany;
	}

	public String getCorporation() {
		return this.corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

	public Set getOmSpecialDiscounts() {
		return this.omSpecialDiscounts;
	}

	public void setOmSpecialDiscounts(Set omSpecialDiscounts) {
		this.omSpecialDiscounts = omSpecialDiscounts;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Linkman getLinkman() {
		return this.linkman;
	}

	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}

	public Set getOnDiscountAppliedRecordses() {
		return this.onDiscountAppliedRecordses;
	}

	public void setOnDiscountAppliedRecordses(Set onDiscountAppliedRecordses) {
		this.onDiscountAppliedRecordses = onDiscountAppliedRecordses;
	}

	public Set getOmNormalDiscounts() {
		return this.omNormalDiscounts;
	}

	public void setOmNormalDiscounts(Set omNormalDiscounts) {
		this.omNormalDiscounts = omNormalDiscounts;
	}

	public Priceconfig getPriceconfig() {
		return this.priceconfig;
	}

	public void setPriceconfig(Priceconfig priceconfig) {
		this.priceconfig = priceconfig;
	}

}