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

	public List getPricewithCandT(String cus_code,String type) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Price WHERE plCustCode =:Cus_code and type =:Cus_type";
		Query query = session.createQuery(hql);
		query.setParameter("Cus_code", cus_code);
		query.setParameter("Cus_type", type);
		return query.list();
	}

	public Price getPricewithId(Integer priceId) throws HibernateException{
		Session session = sessionFactory.getCurrentSession();
		return (Price) session.get(Price.class, priceId);
	}

}
