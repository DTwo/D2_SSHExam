package com.hand.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Price;
import com.hand.dao.PriceDao;

@Repository("priceDao")
public class PriceDaoImpl implements PriceDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPrice(Price price) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		session.save(price);
		
	}

	public List getPriceList() throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Price";
		Query query = session.createQuery(hql);
		return query.list();
	}

	public List getPricewithConfigId(Integer priceConfigId) throws HibernateException{
		// TODO Auto-generated method stub
		return null;
	}

	public Price getPricewithId(Integer priceId) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		return (Price) session.get(Price.class, priceId);
	}

}
