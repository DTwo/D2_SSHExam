package com.hand.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Customer;
import com.hand.Entity.Payment;
import com.hand.dao.PaymentDao;
@Repository("paymentDaoImpl")
public class PaymentDaoImpl implements PaymentDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void editPayment(Payment payment){
		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			String hql = "update Payment set invoiceGroup=:invoiceGroup,currency=:currency,paymentTerm=:paymentTerm,priceIterm1=:priceIterm1,priceIterm2=:priceIterm2,priceIterm3=:priceIterm3,markupName=:markupName,discountName=:discountName where paymentId=:paymentId";
			Query query = session.createQuery(hql);
			query.setParameter("invoiceGroup", payment.getInvoiceGroup());
			query.setParameter("currency", payment.getCurrency());
			query.setParameter("paymentTerm", payment.getPaymentTerm());
			query.setParameter("priceIterm1", payment.getPriceIterm1());
			query.setParameter("priceIterm2", payment.getPriceIterm2());
			query.setParameter("priceIterm3", payment.getPriceIterm3());
			query.setParameter("markupName", payment.getMarkupName());
			query.setParameter("discountName", payment.getDiscountName());
			query.setParameter("paymentId", payment.getPaymentId());
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
