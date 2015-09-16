package com.hand.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Priceconfig;
import com.hand.dao.PriceConfigDao;

@Repository("PriceConfigDao")
public class PriceConfigDaoImpl implements PriceConfigDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPriceConfig(Priceconfig priceConfig) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		//Transaction tx = session.beginTransaction();
		session.save(priceConfig);
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
