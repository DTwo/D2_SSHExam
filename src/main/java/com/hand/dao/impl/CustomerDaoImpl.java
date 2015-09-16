package com.hand.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.Entity.Address;
import com.hand.Entity.Customer;
import com.hand.Entity.Linkman;
import com.hand.Entity.Organization;
import com.hand.Entity.Payment;
import com.hand.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	public int addCustomer(Customer customer){
		Session session = null;
		Transaction tx = null;
		Organization organization = customer.getOrganization();
		Address address = customer.getAddress();
		Linkman linkman = customer.getLinkman();
		session = factory.openSession();
		tx = session.beginTransaction();
		
		
		session.save(customer);
		
		return 1;
	}
}
