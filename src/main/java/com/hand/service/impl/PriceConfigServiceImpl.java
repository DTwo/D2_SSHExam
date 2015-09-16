package com.hand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.Entity.Priceconfig;
import com.hand.dao.impl.PriceConfigDaoImpl;
import com.hand.service.PriceConfigService;

@Service("PriceConfigService")
public class PriceConfigServiceImpl implements PriceConfigService{
	
	@Autowired
	private PriceConfigDaoImpl PriceConfigDao;
	
	public boolean addPriceConfig(Priceconfig priceConfig) {
		boolean bool = false;
		try{
			PriceConfigDao.addPriceConfig(priceConfig);
			bool = true;
		}catch(Exception e){
			e.printStackTrace();
			bool = false;
		}
		return bool;
		
	}

}
