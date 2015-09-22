package com.hand.action;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.Address;
import com.hand.Entity.Customer;
import com.hand.Entity.Linkman;
import com.hand.Entity.Organization;
import com.hand.Entity.Payment;
import com.hand.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{
	private String customerName;
	private String customerCode;
	private String type;
	private String groupCompany;
	private String corporation;
	private String country;
	private String state;
	private String city;
	private String addressLine1;
	private String addressLine2;
	private String postcode;
	private String portOfDestination;
	private String shippingMark;
	private String status;
	private Date inactiveDate;
	private String invoiceGroup;
	private String currency;
	private String paymentTerm;
	private String priceTerm1;
	private String priceTerm2;
	private String priceTerm3;
	private String markupName;
	private String discountName;
	private String marketArea;
	private String businessManager;
	private String businessAssistant;
	private String finance;
	private String mailFrom;
	private String prepoMailto;
	private String poMailto;
	private String ocpiMaito;
	private String invPklistMailto;
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getGroupCompany() {
		return groupCompany;
	}

	public void setGroupCompany(String groupCompany) {
		this.groupCompany = groupCompany;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPortOfDestination() {
		return portOfDestination;
	}

	public void setPortOfDestination(String portOfDestination) {
		this.portOfDestination = portOfDestination;
	}

	public String getShippingMark() {
		return shippingMark;
	}

	public void setShippingMark(String shippingMark) {
		this.shippingMark = shippingMark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Date getInactiveDate() {
		return inactiveDate;
	}

	public void setInactiveDate(Date inactiveDate) {
		this.inactiveDate = inactiveDate;
	}

	public String getInvoiceGroup() {
		return invoiceGroup;
	}

	public void setInvoiceGroup(String invoiceGroup) {
		this.invoiceGroup = invoiceGroup;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getPriceTerm1() {
		return priceTerm1;
	}

	public void setPriceTerm1(String priceTerm1) {
		this.priceTerm1 = priceTerm1;
	}

	public String getPriceTerm2() {
		return priceTerm2;
	}

	public void setPriceTerm2(String priceTerm2) {
		this.priceTerm2 = priceTerm2;
	}

	public String getPriceTerm3() {
		return priceTerm3;
	}

	public void setPriceTerm3(String priceTerm3) {
		this.priceTerm3 = priceTerm3;
	}

	public String getMarkupName() {
		return markupName;
	}

	public void setMarkupName(String markupName) {
		this.markupName = markupName;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getMarketArea() {
		return marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getBusinessManager() {
		return businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public String getBusinessAssistant() {
		return businessAssistant;
	}

	public void setBusinessAssistant(String businessAssistant) {
		this.businessAssistant = businessAssistant;
	}

	public String getFinance() {
		return finance;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getPrepoMailto() {
		return prepoMailto;
	}

	public void setPrepoMailto(String prepoMailto) {
		this.prepoMailto = prepoMailto;
	}

	public String getPoMailto() {
		return poMailto;
	}

	public void setPoMailto(String poMailto) {
		this.poMailto = poMailto;
	}

	public String getOcpiMaito() {
		return ocpiMaito;
	}

	public void setOcpiMaito(String ocpiMaito) {
		this.ocpiMaito = ocpiMaito;
	}

	public String getInvPklistMailto() {
		return invPklistMailto;
	}

	public void setInvPklistMailto(String invPklistMailto) {
		this.invPklistMailto = invPklistMailto;
	}

	@Override
	public String execute() throws Exception {
		
		Organization organization = new Organization(marketArea, businessManager, businessAssistant, finance);
		Customer customer = new Customer(organization, customerCode, type, customerName);
		Address address = new Address(customer, country, state, city, addressLine1, addressLine2, postcode, portOfDestination, shippingMark, status, inactiveDate);
		Linkman linkman = new Linkman(customer, mailFrom, prepoMailto, poMailto, ocpiMaito, invPklistMailto);
		Payment payment = new Payment(customer, currency, paymentTerm, markupName, discountName);
		Set payments = new HashSet();
		payments.add(payment);
		customer.setGroupCompany(groupCompany);
		customer.setCorporation(corporation);
		customer.setAddress(address);
		customer.setLinkman(linkman);
		customer.setPayments(payments);
		System.out.println("marketArea:"+marketArea);
		int id = customerServiceImpl.addCustomer(customer, organization, address, linkman, payment);
		System.out.println("customer_id:"+id);
		return SUCCESS;
	}
	
}
