package com.hand.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonArray;
import com.hand.Entity.Customer;
import com.hand.service.impl.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class CheckCustomerAction extends ActionSupport {
	private String customerName;
	private String type;
	private String groupCompany;
	private String customerCode;
	private String status;
	private String corporation;
	private int customerId;

	@Autowired
	private CustomerServiceImpl customerServiceImpl;





	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public void jsonShow() {
		System.out.println("进入jsonshow");
		System.out.println(status);
		JsonArray customers = customerServiceImpl.getCustomer(customerName,
				customerCode, corporation, groupCompany, status, type);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(customers);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getCustomer() {
		System.out.println(customerId);
		
		Customer customer = customerServiceImpl.getCustomer(customerId);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		return "get";
	}
	
	public String editCustomer(){
		
		Customer customer = customerServiceImpl.getCustomer(customerId);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		return "show";
	}
	


}
