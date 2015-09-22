package com.hand.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.hand.Entity.Customer;
import com.hand.Entity.Price;

public interface PriceDao {
	/**
	 * 保存新增的Price价格表
	 * @param price
	 */
	void addPrice(Price price)throws HibernateException;
	
	/**
	 * 获取Price表的全部信息
	 */
	List getPriceList()throws HibernateException;
	
	/**
	 * 通过用户简称cus_code和类型type获取对应的价格表信息
	 * @param cus_code
	 * @param type
	 * @return
	 * @throws HibernateException
	 */
	List getPricewithCandT(String cus_code,String type)throws HibernateException;
	
	/**
	 * 通过Price主键priceId获取指定Price对象
	 * @param priceId
	 * @return
	 */
	Price getPricewithId(Integer priceId)throws HibernateException;
	
	/**
	 * 通过用户简称cus_code和类型type和工厂型号Factory获取对应的价格表信息
	 * @param cus_code
	 * @param type
	 * @param Factory
	 * @return
	 * @throws HibernateException
	 */
	List getPriceWithCandTandF(String cus_code,String type,String Factory) throws HibernateException;
	
	Customer getCusWithCandT(String cus_code,String type) throws HibernateException;
	
	
}
