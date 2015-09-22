package com.hand.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.hand.Entity.Priceconfig;
import com.hand.Entity.Customer;
import com.hand.Entity.Price;

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
	List getPriceConfigwithCandT(String cust_code,String type)throws HibernateException;
	
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
	 * 通过Id取得指定的Price
	 * @param priceId
	 * @return
	 */
	public Price getPricewithId(Integer priceId);
	
	/**
	 * 获取客户列表，用于添加新增客户配置
	 * @return
	 */
	public List getCustomerList();
	
	
//	/**
//	 * 通过用户简称cus_code和类型type获取对应的价格表信息
//	 * @param cus_code
//	 * @param type
//	 * @return
//	 * @throws HibernateException
//	 */
//	List getPriceConfigwithCandT(String cus_code,String type)throws HibernateException;
//	
	
	public Price getPriceWithCandT(String Cus_code,String Cus_Type);
	
	
	public Price getPricewithCandTandF(String Cus_code,String Cus_type,String factory);
	
}
