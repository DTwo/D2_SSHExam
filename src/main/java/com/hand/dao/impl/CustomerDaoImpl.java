package com.hand.dao.impl;

import org.hibernate.HibernateException;
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
		address.setStatus("待确认");
		
		
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			int orgId = (Integer) session.save(organization);
			int cusId = (Integer) session.save(customer);
			int addId = (Integer) session.save(address);
			int linId = (Integer) session.save(linkman);
			
			System.out.println("插入了orgId:"+orgId+"--cusId:"+cusId+"--addId:"+addId+"--linId"+linId);
			
			tx.commit();
		} catch (HibernateException e) {
			
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return 1;
	}
}
