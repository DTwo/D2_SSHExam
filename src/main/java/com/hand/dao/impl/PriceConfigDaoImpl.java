package com.hand.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Customer;
import com.hand.Entity.Priceconfig;
import com.hand.dao.PriceConfigDao;

@Repository("PriceConfigDao")
public class PriceConfigDaoImpl implements PriceConfigDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPriceConfig(Priceconfig priceConfig) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		//Transaction tx = session.beginTransaction();
		try{
		session.save(priceConfig);
		session.flush();
		}catch(HibernateException e){e.printStackTrace();}
	}

	public Priceconfig getPriceConfigwithCandT(String cust_code, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Priceconfig getPriceConfigwithId(Integer priceConfigId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void editPriceConfig(Priceconfig priceConfig) throws HibernateException{
		// TODO Auto-generated method stub
		
	}

	public List getPriceConfigList() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Priceconfig";
		Query query = session.createQuery(hql);
		return query.list();
	}


	public Customer getCustomerwithCandT(String cust_code, String type) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Customer Cus WHERE Cus.customerCode =:Cust_Code and Cus.type =:type";
		Query query = session.createQuery(hql);
		query.setParameter("Cust_Code", cust_code);
		query.setParameter("type", type);
		return (Customer) query.list().get(0);
		
	}

	public Customer getCustomerwithId(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		return (Customer) session.get(Customer.class, customerId);
		
	}
	
}
