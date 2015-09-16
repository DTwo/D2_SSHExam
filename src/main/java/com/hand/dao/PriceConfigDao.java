package com.hand.dao;

import com.hand.Entity.Priceconfig;

public interface PriceConfigDao {
	/**
	 * 新增价格配置表
	 * @param priceConfig -->价格表对象
	 */
	void addPriceConfig(Priceconfig priceConfig);
	
	/**
	 * 	 * 获取指定的价格表信息
	 * @param cust_code --> 客户简称
 	 * @param type  -->客户类型
	 * @return
	 */
	Priceconfig getPriceConfigwithCandT(String cust_code,String type);
	
	/**
	 * 通过指定的id获取特定价格配置表
	 * @param priceConfigId  --> 价格配置表id
	 * @return
	 */
	Priceconfig getPriceConfigwithId(Integer priceConfigId);
	
	/**
	 * 修改价格配置表
	 * @param priceConfig  -->修改后的价格表
	 */
	void editPriceConfig(Priceconfig priceConfig);

}
