package com.hand.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Linkman;
import com.hand.dao.LinkManDao;
@Repository("linkManDaoImpl")
public class LinkManDaoImpl implements LinkManDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void editLinkMan(Linkman linkman){
		Session session=null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "update Linkman set mailfrom=:mailfrom,prepoMailto=:prepoMailto,poMailto=:poMailto,ocpiMailto=:ocpiMailto,invPklistMailto=:invPklistMailto where customerId=:customerId";
			Query query = session.createQuery(hql);
			query.setParameter("mailfrom", linkman.getMailfrom());
			query.setParameter("prepoMailto", linkman.getPrepoMailto());
			query.setParameter("poMailto", linkman.getPoMailto());
			query.setParameter("ocpiMailto", linkman.getOcpiMailto());
			query.setParameter("invPklistMailto", linkman.getInvPklistMailto());
			query.setParameter("customerId", linkman.getCustomerId());
			
			System.out.println("更新了"+query.executeUpdate()+"条数据");
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
