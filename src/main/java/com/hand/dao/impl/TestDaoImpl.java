package com.hand.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Organization;
import com.hand.dao.TestDao;

@Repository("TestDao")
public class TestDaoImpl implements TestDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Serializable save(Organization organ) {
		return sessionFactory.openSession().save(organ);
	}

}
