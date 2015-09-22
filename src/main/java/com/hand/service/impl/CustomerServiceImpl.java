package com.hand.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.Entity.Address;
import com.hand.Entity.Customer;
import com.hand.Entity.Linkman;
import com.hand.Entity.Organization;
import com.hand.Entity.Payment;
import com.hand.dao.CustomerDao;
import com.hand.dao.impl.CustomerDaoImpl;
import com.hand.dao.impl.OrganizationDaoImpl;

@Repository("customerServiceImpl")
public class CustomerServiceImpl {
	@Autowired
	private CustomerDaoImpl customerDaoImpl;
	@Autowired
	private OrganizationDaoImpl org;

	// 新建客户
	public int addCustomer(Customer customer, Organization organization,
			Address address, Linkman linkman,Payment payment) {

		return customerDaoImpl.addCustomer(customer, organization, address,
				linkman,payment);
	}

	// 查询所有客户信息
	public List getCustomer() {
		return customerDaoImpl.getCustomer();
	}

	// 模糊查询
	public JsonArray getCustomer(String customerName, String customerCode,
			String corporation, String groupCompany, String status, String type) {
		List customers = null;
		System.out.println("testgetcus");
		if (!customerName.isEmpty()) {
			System.out.println("进入getCustomerName");
			customers = customerDaoImpl.getByCustomerName("%" + customerName
					+ "%");

		} else if (!customerCode.isEmpty()) {
			System.out.println("进入getCustomerCode");

			customers = customerDaoImpl.getByCustomerCode("%" + customerCode
					+ "%");

		} else if (!corporation.isEmpty()) {

			customers = customerDaoImpl.getByCorporation("%" + corporation
					+ "%");

		} else if (!groupCompany.isEmpty()) {

			customers = customerDaoImpl.getByGroupCompany("%" + groupCompany
					+ "%");
		} else if (!type.isEmpty()) {

			customers = customerDaoImpl.getByType("%" + type + "%");

		} else if (!status.isEmpty()) {

			customers = customerDaoImpl.getByStatus(status);
			System.out.println(customers.toString());
		}
		
		JsonArray jsonArray = new JsonArray();
		for(Iterator iterator = customers.iterator();iterator.hasNext();){
			JsonObject jsonObject = new JsonObject();
			Customer customer = (Customer) iterator.next();
			jsonObject.addProperty("CustomerId", customer.getCustomerId());
			jsonObject.addProperty("customerName", customer.getCustomerName());
			jsonObject.addProperty("customerCode", customer.getCustomerCode());
			jsonObject.addProperty("type", customer.getType());
			jsonObject.addProperty("corporation", customer.getCorporation());
			jsonObject.addProperty("groupCompany", customer.getGroupCompany());
			jsonArray.add(jsonObject);
			
		}
		
		
		System.out.println(jsonArray.toString());
		return jsonArray;
	}
	
	public Customer getCustomer(int customerId){
		List list =  customerDaoImpl.getCustomer(customerId);
		Customer customer = (Customer) list.get(0);
		System.out.println(customer.getAddress().getAddressLine1()+"----"+customer.getOrganization().getFinance());
		return customer;
		
	}

}
