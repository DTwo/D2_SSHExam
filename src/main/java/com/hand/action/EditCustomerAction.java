package com.hand.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.Address;
import com.hand.Entity.Customer;
import com.hand.Entity.Linkman;
import com.hand.Entity.Organization;
import com.hand.service.impl.AddressServiceImpl;
import com.hand.service.impl.CustomerServiceImpl;
import com.hand.service.impl.LinkmanServiceImpl;
import com.hand.service.impl.OrganizationServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EditCustomerAction extends ActionSupport {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired 
	private OrganizationServiceImpl orgServiceImpl;
	@Autowired
	private AddressServiceImpl addressServiceImpl;
	@Autowired 
	private LinkmanServiceImpl linServiceImpl;
	//Address
	private int addressId;
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
	//Customer
	private Integer customerId;
	private String customerCode;
	private String type;
	private String groupCompany;
	private String corporation;
	private String customerName;
	//
	
	private String mailfrom;
	private String prepoMailto;
	private String poMailto;
	private String ocpiMailto;
	private String invPklistMailto;
	//
	private Integer organizationId;
	private String marketArea;
	private String businessManager;
	private String busniessAssistant;
	private String finance;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
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
	public Date getInactuveDate() {
		return inactuveDate;
	}
	public void setInactuveDate(Date inactuveDate) {
		this.inactuveDate = inactuveDate;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getMailfrom() {
		return mailfrom;
	}
	public void setMailfrom(String mailfrom) {
		this.mailfrom = mailfrom;
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
	public String getOcpiMailto() {
		return ocpiMailto;
	}
	public void setOcpiMailto(String ocpiMailto) {
		this.ocpiMailto = ocpiMailto;
	}
	public String getInvPklistMailto() {
		return invPklistMailto;
	}
	public void setInvPklistMailto(String invPklistMailto) {
		this.invPklistMailto = invPklistMailto;
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
	public String getBusniessAssistant() {
		return busniessAssistant;
	}
	public void setBusniessAssistant(String busniessAssistant) {
		this.busniessAssistant = busniessAssistant;
	}
	public String getFinance() {
		return finance;
	}
	public void setFinance(String finance) {
		this.finance = finance;
	}
	
	public void editcustomer(){
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		customer.setCorporation(corporation);
		customer.setCustomerCode(customerCode);
		customer.setCustomerName(customerName);
		customer.setGroupCompany(groupCompany);
		customer.setType(type);
	}
	
	public void editAddress(){
		System.out.println("进入editAddress方法");
		Address address = new Address();
		address.setAddressId(addressId);
		address.setAddressLine1(addressLine1);
		address.setAddressLine2(addressLine2);
		address.setCity(city);
		address.setCountry(country);
		address.setInactuveDate(inactuveDate);
		address.setPortOfDestination(portOfDestination);
		address.setPostcode(postcode);
		address.setShippingMark(shippingMark);
		address.setStatus(status);
		address.setState(state);
		addressServiceImpl.editAddress(address);
	}
	
	public void editLinkman(){
		System.out.println("进入editLinkman方法");
		Linkman linkman = new Linkman();
		linkman.setCustomerId(customerId);
		linkman.setInvPklistMailto(invPklistMailto);
		linkman.setMailfrom(mailfrom);
		linkman.setOcpiMailto(ocpiMailto);
		linkman.setPoMailto(poMailto);
		linkman.setPrepoMailto(prepoMailto);
		linServiceImpl.editLinkMan(linkman);
	}
	
	public void editorg(){
		System.out.println("进入editorg方法");
		Organization organization = new Organization(marketArea, businessManager, busniessAssistant, finance);
		orgServiceImpl.editOrganization(organization);
	}
}
