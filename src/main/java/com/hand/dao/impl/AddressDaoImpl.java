package com.hand.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Address;
import com.hand.dao.AddressDao;

@Repository("addressDaoImpl")
public class AddressDaoImpl implements AddressDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void editAddress(Address address) {

		Session session = null;
		Transaction tx = null;
		System.out.println("-----进入了editAddress方法-------");
		
		
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "update Address set country=:country,state=:state,city=:city,addressLine1=:addressLine1,addressLine2=:addressLine2,postcode=:postcode,portOfDestination=:portOfDestination,shippingMark=:shippingMark,status=:status,inactuveDate=:inactuveDate where addressId=:addressId";
			Query query = session.createQuery(hql);
			
			
			query.setParameter("country", address.getCountry());
			query.setParameter("state", address.getState());
			query.setParameter("city", address.getCity());
			query.setParameter("addressLine1", address.getAddressLine1());
			query.setParameter("addressLine2", address.getAddressLine2());
			query.setParameter("postcode", address.getPostcode());
			query.setParameter("portOfDestination", address.getPortOfDestination());
			query.setParameter("shippingMark", address.getShippingMark());
			query.setParameter("status", address.getStatus());
			query.setParameter("inactuveDate", address.getInactuveDate());
			query.setParameter("addressId", address.getAddressId());
			
			
			int test = query.executeUpdate();
			System.out.println("update了"+test+"记录");
			
			
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

	}
	


}
