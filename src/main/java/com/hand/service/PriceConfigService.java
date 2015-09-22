package com.hand.service;

import java.util.List;

import com.hand.Entity.Customer;
import com.hand.Entity.Price;
import com.hand.Entity.Priceconfig;

public interface PriceConfigService {
	
	/**
	 * 新增PriceConfig
	 * @param priceConfig
	 * @return 插入成功返回true,否则返回false
	 */
	boolean addPriceConfig(Priceconfig priceConfig);
	
	/**
	 * 获取价格配置表全部信息
	 * @return
	 */
	List getPriceConfigList();
	
	/**
	 * 获取指定Customer
	 * @param customerId
	 * @return
	 */
	public Customer getCustomerforPriceConfig(Integer customerId);
	
	/**
	 * 获取Customer列表信息
	 * @return
	 */
	public List getCustomerList();
	
	
	/**
	 * 
	 * @param Cus_code
	 * @param Type
	 * @return
	 */
	public Price getPricewithCandT(String Cus_code,String Type);
	
	
	public List getCusListWithCandT(String Cus_code,String Type);
	
}
