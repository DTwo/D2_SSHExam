package com.hand.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Customer;
import com.hand.Entity.Price;
import com.hand.dao.PriceDao;

@Repository("priceDao")
public class PriceDaoImpl implements PriceDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addPrice(Price price) throws HibernateException{
		System.out.println("in addDao");
		Session session = sessionFactory.getCurrentSession();
		try{
		session.save(price);
		}catch(Exception e){
			e.printStackTrace();
		}
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

	public List getPriceWithCandTandF(String cus_code, String type, String Factory) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Price WHERE plCustCode =:Cus_code and type =:Cus_type and plYhItem =:FactoryNum";
		Query query = session.createQuery(hql);
		query.setParameter("Cus_code", cus_code);
		query.setParameter("Cus_type", type);
		query.setParameter("FactoryNum", Factory);
		return query.list();
	}

	public Customer getCusWithCandT(String cus_code, String type) throws HibernateException {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Customer WHERE customerCode=:Cus_code AND type =:Cus_type";
		Query query = session.createQuery(hql);
		query.setParameter("Cus_code", cus_code);
		query.setParameter("Cus_type", type);
		return (Customer) query.list().get(0);
	}

}
