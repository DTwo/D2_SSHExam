package com.hand.dao;

import java.util.List;

import org.hibernate.HibernateException;

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
	 * 通过价格配置表主键Id获取对应的价格表信息
	 * @param priceConfigId
	 * @return
	 */
	List getPricewithConfigId(Integer priceConfigId)throws HibernateException;
	
	/**
	 * 通过Price主键priceId获取指定Price对象
	 * @param priceId
	 * @return
	 */
	Price getPricewithId(Integer priceId)throws HibernateException;
}
