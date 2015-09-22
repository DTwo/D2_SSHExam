package com.hand.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Address;
import com.hand.Entity.Customer;
import com.hand.Entity.Linkman;
import com.hand.Entity.Organization;
import com.hand.Entity.Payment;
import com.hand.dao.CustomerDao;

@Repository("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PaymentDaoImpl paymentDaoImpl;

	// 新建顾客
	public int addCustomer(Customer customer, Organization organization,
			Address address, Linkman linkman,Payment payment) {
		Session session = null;
		Transaction tx = null;
		int cusId = -1;
		int orgId = -1;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			orgId = (Integer) session.save(organization);

			String orghql = "from Organization where organizationId=:organizationId";
			String cushql = "from Customer where customerId=:customerId";

			Query query = session.createQuery(orghql);
			query.setParameter("organizationId", orgId);
			List organizations = query.list();
			Organization organization1 = (Organization) organizations.get(0);

			customer.setOrganization(organization1);
			cusId = (Integer) session.save(customer);

			query = session.createQuery(cushql);
			query.setParameter("customerId", cusId);
			List customers = query.list();
			Customer customer1 = (Customer) customers.get(0);

			address.setCustomer(customer1);
			System.out.println("address_id:" + session.save(address));

			linkman.setCustomer(customer1);
			System.out.println("linkman_id:" + session.save(linkman));
			
			payment.setCustomer(customer1);
			System.out.println("payment_id:" + session.save(payment));

			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("插入了cusid:" + cusId);

		return cusId;
	}

	// 查询所有顾客
	public List getCustomer() {
		System.out.println("进入getCustomer方法");
		Session session = null;
		Transaction tx = null;
		List customers = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "from Customer";
			Query query = session.createQuery(hql);
			customers = query.list();
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null) {
				tx.rollback();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return customers;
	}
	//根据客户名称查询
	public List getByCustomerName(String customerName){
		Session session = null;
		Transaction tx = null;
		List customers = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.like("customerName", customerName));
			customers = cr.list();
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
		
		return customers;
	}
	//按客户类型查询
	public List getByType(String type){
		System.out.println("进入模糊查询客户类型方法");
		Session session = null;
		Transaction tx = null;
		List customers = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.like("type", type));
			customers = cr.list();
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
		
		return customers;
	}
	//按集团公司查询
	public List getByGroupCompany(String groupCompany){
		Session session = null;
		Transaction tx = null;
		List customers = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.like("groupCompany", groupCompany));
			customers = cr.list();
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
		
		return customers;
	}
	//按客户简称查询
	public List getByCustomerCode(String customerCode){
		Session session = null;
		Transaction tx = null;
		List customers = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.like("customerCode", customerCode));
			customers = cr.list();
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
		
		return customers;
	}
	//按客户总公司查询
	public List getByCorporation(String corporation){
		Session session = null;
		Transaction tx = null;
		List customers = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Customer.class);
			cr.add(Restrictions.like("corporation", corporation));
			customers = cr.list();
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
		
		return customers;
	}
	//按客户状态查询
	public List getByStatus(String status){
		System.out.println("进入客户状态查询方法");
		Session session = null;
		Transaction tx = null;
		List addresses = null;
		List customers = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
//			Criteria cr = session.createCriteria(Address.class);
//			cr.add(Restrictions.like("status", address.getStatus()));
			String hql = "from Customer where address.status = :status";
			Query query = session.createQuery(hql);
			query.setParameter("status", status);
			customers = query.list();
//			addresses = cr.list();


//			for(Iterator iterator = addresses.iterator();iterator.hasNext();){
//				Address address1 = (Address) iterator.next();
//				customers.add(address1.getCustomer());
//			}
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
		System.out.println("cusmerlist"+customers);
		return customers;
	}
	
	public List getCustomer(int customerId){
		System.out.println("进入查找详细Customer方法");
		Session session = null;
		Transaction tx = null;
		List list = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "from Customer where customerId=:customerId";
			Query query = session.createQuery(hql);
			query.setParameter("customerId", customerId);
			list = query.list();
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
		
		return list;
		
	}
	
}
