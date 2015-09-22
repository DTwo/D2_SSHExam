package com.hand.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Organization;
import com.hand.dao.OrganizationDao;

@Repository("org")
public class OrganizationDaoImpl implements OrganizationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Organization getOrganization(int organizationId) {
		Session session = null;
		List organizations = null;
		Organization organization = null;
		System.out.println("进入了getOrganization方法");
		session = sessionFactory.getCurrentSession();
		String hql = "from Organization where organizationId=:organizationId";
		Query query = session.createQuery(hql);
		query.setParameter("organizationId", organizationId);
		organizations = query.list();
		if (organizations.isEmpty()) {
			return null;
		} else {
			organization = (Organization) organizations.get(0);

		}

		return organization;

	}

	public int addOrganization(Organization organization) {
		Session session = null;

		System.out.println("进入了addOrganization方法");
		int id = 0;

		System.out.println("----test---" + organization.getBusinessManager());
		session = sessionFactory.getCurrentSession();
		id = (Integer) session.save(organization);
		System.out.println("插入了organizationId：" + id);

		return id;
	}
	
	public void editOrganization(Organization organization) {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			String hql = "update Organization set marketArea=:marketArea,businessManager=:businessManager,busniessAssistant=:busniessAssistant,finance=:finance where organizationId=:organizationId";
			Query query = session.createQuery(hql);
			query.setParameter("marketArea", organization.getMarketArea());
			query.setParameter("businessManager", organization.getBusinessManager());
			query.setParameter("busniessAssistant", organization.getBusniessAssistant());
			query.setParameter("finance", organization.getFinance());
			query.setParameter("organizationId", organization.getOrganizationId());
			System.out.println("更新了"+query.executeUpdate()+"條數據");
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.beginTransaction();
		}
		
	}
}
