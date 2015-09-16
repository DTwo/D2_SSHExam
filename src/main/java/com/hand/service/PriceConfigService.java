package com.hand.service;

import com.hand.Entity.Priceconfig;

public interface PriceConfigService {
	
	/**
	 * 新增PriceConfig
	 * @param priceConfig
	 * @return 插入成功返回true,否则返回false
	 */
	boolean addPriceConfig(Priceconfig priceConfig);
	
}
