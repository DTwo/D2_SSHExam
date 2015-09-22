package com.hand.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.OnDiscountAppliedRecords;
import com.hand.dao.OnDiscountAppliedRecordsDao;

public class OnDiscountAppliedRecordsDaoImpl implements OnDiscountAppliedRecordsDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<OnDiscountAppliedRecords> selectOnDiscountAppliedRecords(String discountName) {
		Session session = sessionFactory.openSession();
		String hql = "FROM OnDiscountAppliedRecords WHERE dicountName=:discountName";
		Query query  = session.createQuery(hql);
		query.setParameter("discountName", discountName);
		List<OnDiscountAppliedRecords> onDiscountAppliedRecords = query.list();
		session.close();
		return onDiscountAppliedRecords;
	}

}
