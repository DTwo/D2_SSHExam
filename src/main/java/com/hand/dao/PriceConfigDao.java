package com.hand.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.hand.Entity.Priceconfig;
import com.hand.Entity.Customer;

public interface PriceConfigDao {
	/**
	 * 新增价格配置表
	 * @param priceConfig -->价格表对象
	 */
	void addPriceConfig(Priceconfig priceConfig) throws HibernateException;
	
	/**
	 * 	 * 获取指定的价格表信息
	 * @param cust_code --> 客户简称
 	 * @param type  -->客户类型
	 * @return
	 */
	Priceconfig getPriceConfigwithCandT(String cust_code,String type)throws HibernateException;
	
	/**
	 * 通过指定的id获取特定价格配置表
	 * @param priceConfigId  --> 价格配置表id
	 * @return
	 */
	Priceconfig getPriceConfigwithId(Integer priceConfigId)throws HibernateException;
	
	/**
	 * 修改价格配置表
	 * @param priceConfig  -->修改后的价格表
	 */
	void editPriceConfig(Priceconfig priceConfig)throws HibernateException;

	/**
	 * 获取所有PriceConfig
	 * @return
	 */
	List getPriceConfigList();
	
	/**
	 * 通过简称和类型取得指定的Customer
	 * @param cust_code  -->简称
	 * @param type   --->类型
	 * @return
	 */
	public Customer getCustomerwithCandT(String cust_code,String type);
	
	/**
	 * 通过用户Id取得指定的Customer
	 * @param customerId   -->用户Id
	 * @return
	 */
	public Customer getCustomerwithId(Integer customerId);
}
