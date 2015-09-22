package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.Customer;
import com.hand.Entity.OmNormalDiscount;
import com.hand.dao.OmNormalDiscountDao;

public class OmNormalDiscountDaoImp implements OmNormalDiscountDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<OmNormalDiscount> showOmNoramlDiscount() {
		Session session = sessionFactory.openSession();
		String hql = "FROM OmNormalDiscount";
		Query query = session.createQuery(hql);
		List<OmNormalDiscount> omNormalDiscounts = query.list();
		session.close();
		return omNormalDiscounts;
	}

	public void insertOmNoramlDiscount(OmNormalDiscount omNormalDiscount) {
		Session session = sessionFactory.openSession();
		Customer customer = new Customer();
		customer.setCustomerId(1);
		omNormalDiscount.setCustomer(customer);
		session.save(omNormalDiscount);
		session.close();
	}

	public void updateOmNoramlDiscount(OmNormalDiscount omNormalDiscount) {
		Session session = sessionFactory.openSession();
		OmNormalDiscount temp = (OmNormalDiscount) session.get(OmNormalDiscount.class, omNormalDiscount.getNormalId());
		temp.setDiscountName(omNormalDiscount.getDiscountName());
		temp.setDiscountBase(omNormalDiscount.getDiscountBase());
		temp.setType(omNormalDiscount.getType());
		temp.setBaseQty(omNormalDiscount.getBaseQty());
		temp.setActivity(omNormalDiscount.getActivity());
		temp.setDiscountRate(omNormalDiscount.getDiscountRate());
		session.update(temp);
		session.flush();
		session.close();
	}

}
