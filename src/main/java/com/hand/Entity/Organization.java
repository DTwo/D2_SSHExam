package com.hand.Entity;
// Generated 2015-9-21 11:25:57 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Organization generated by hbm2java
 */
public class Organization implements java.io.Serializable {

	private Integer organizationId;
	private String marketArea;
	private String businessManager;
	private String busniessAssistant;
	private String finance;
	private Set customers = new HashSet(0);

	public Organization() {
	}

	public Organization(String marketArea, String businessManager, String busniessAssistant, String finance) {
		this.marketArea = marketArea;
		this.businessManager = businessManager;
		this.busniessAssistant = busniessAssistant;
		this.finance = finance;
	}

	public Organization(String marketArea, String businessManager, String busniessAssistant, String finance,
			Set customers) {
		this.marketArea = marketArea;
		this.businessManager = businessManager;
		this.busniessAssistant = busniessAssistant;
		this.finance = finance;
		this.customers = customers;
	}

	public Integer getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getMarketArea() {
		return this.marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public String getBusinessManager() {
		return this.businessManager;
	}

	public void setBusinessManager(String businessManager) {
		this.businessManager = businessManager;
	}

	public String getBusniessAssistant() {
		return this.busniessAssistant;
	}

	public void setBusniessAssistant(String busniessAssistant) {
		this.busniessAssistant = busniessAssistant;
	}

	public String getFinance() {
		return this.finance;
	}

	public void setFinance(String finance) {
		this.finance = finance;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

}
