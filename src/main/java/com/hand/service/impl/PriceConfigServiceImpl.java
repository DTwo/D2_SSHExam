package com.hand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.Entity.Customer;
import com.hand.Entity.Priceconfig;
import com.hand.dao.PriceConfigDao;
import com.hand.service.PriceConfigService;

@Service("PriceConfigService")
public class PriceConfigServiceImpl implements PriceConfigService{
	
	@Autowired
	private PriceConfigDao PriceConfigDao;
	
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
	public Customer getCustomerforPriceConfig(Integer customerId){
		return PriceConfigDao.getCustomerwithId(customerId);
	}
	public List getPriceConfigList() {
		return PriceConfigDao.getPriceConfigList();
	}
	public List getCustomerList() {
		return PriceConfigDao.getCustomerList();
	}
	public List getCustomerwithCandT(String Cus_code, String Type) {
		return PriceConfigDao.getPriceConfigwithCandT(Cus_code, Type);
	}
}
