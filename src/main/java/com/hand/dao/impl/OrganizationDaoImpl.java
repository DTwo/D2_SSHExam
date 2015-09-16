package com.hand.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hand.Entity.Organization;
import com.hand.dao.OrganizationDao;

public class OrganizationDaoImpl implements OrganizationDao {
	
	private SessionFactory factory;
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	public Organization getOrganization(int customerId){
		Session session = null;
		Transaction tx = null;
		List organizations = null;
		Organization organization = null;
		System.out.println("进入了getOrganization方法");
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "from Organization where customerId=:customerId";
			Query query = session.createQuery(hql);
			query.setParameter("customerId", customerId);
			organizations = query.list();
			if(organizations.isEmpty()){
				return null;
			}else{
				organization = (Organization) organizations.get(0);
				
			}
			tx.commit();
		} catch (HibernateException e) {
			if(tx!=null){
				tx.rollback();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			session.close();
		}
		return organization;
		
	}
	
	
	public void addOrganization(String marketArea,String businessManager,String busniessAssistant,String finance){
		Session session = null;
		Transaction tx = null;
		System.out.println("进入了addOrganization方法");
		
		try {
			Organization organization = new Organization(marketArea, businessManager, busniessAssistant, finance);
			session = factory.openSession();
			tx = session.beginTransaction();
			int id = (Integer) session.save(organization);
			System.out.println("插入了organizationId："+id);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		
		
	}
}
