package com.hand.service;

import java.util.List;

import com.hand.Entity.Customer;
import com.hand.Entity.Price;

public interface PriceService {
	
	/**
	 * 添加新增的Price到priceDao里
	 * @param price
	 * @return
	 */
	boolean addPrice(Price price);
	
	
	/**
	 * 获取Price表里的全部信息
	 * @return
	 */
	List getPriceList();
	
	/**
	 * 通过Priceconfig的主键Id获取对应的Price集合
	 * @param configId
	 * @return
	 */
	List getPricewithConfigId(Integer configId);

	/**
	 * 通过Price主键Id获取指定的Price持久化对象
	 * @param priceId
	 * @return
	 */
	Price getPriceWithId(Integer priceId);
	
	/**
	 * 通过用户简称cus_code和类型type获取对应的价格表信息
	 * @param cus_code
	 * @param type
	 * @return
	 */
	List getPriceWithCandT(String cus_code,String type);
	
	/**
	 * 通过用户简称cus_code和类型type和工厂型号Factory获取对应的价格表信息
	 * @param cus_code
	 * @param type
	 * @param Factory
	 * @return
	 */
	List getPriceWithCandTandF(String cus_code,String type,String Factory);
	
	
	Customer getCusWithCandT(String cus_code,String type);
	
}
