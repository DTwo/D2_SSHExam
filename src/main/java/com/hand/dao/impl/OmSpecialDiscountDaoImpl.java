package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.OmSpecialDiscount;
import com.hand.dao.OmSpecialDiscountDao;

public class OmSpecialDiscountDaoImpl implements OmSpecialDiscountDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<OmSpecialDiscount> selectOmSpecialDiscount(String cust_code) {
		Session session = sessionFactory.openSession();
		String hql = "FROM OmSpecialDiscount WHERE custCode=:cust_code";
		Query query = session.createQuery(hql);
		query.setParameter("cust_code", cust_code);
		List<OmSpecialDiscount> omSpecialDiscounts = query.list();
		session.close();
		return omSpecialDiscounts;
	}

	public void updateOmSpecialDiscount(OmSpecialDiscount omSpecialDiscount) {
		Session session = sessionFactory.openSession();
		OmSpecialDiscount temp = new OmSpecialDiscount();
		temp = (OmSpecialDiscount) session.get(OmSpecialDiscount.class, omSpecialDiscount.getSpecialId());
		temp.setDiscountName(omSpecialDiscount.getDiscountName());
		temp.setAmount(omSpecialDiscount.getAmount());
		temp.setAppliedAmount(omSpecialDiscount.getAppliedAmount());
		temp.setBalance(omSpecialDiscount.getBalance());
		temp.setActivity(omSpecialDiscount.getActivity());
		temp.setCustCode(omSpecialDiscount.getCustCode());
		session.update(temp);
		session.flush();
		session.close();
	}
}
