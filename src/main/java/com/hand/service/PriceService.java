package com.hand.service;

import java.util.List;

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
	
}
