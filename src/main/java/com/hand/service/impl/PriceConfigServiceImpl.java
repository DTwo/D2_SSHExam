package com.hand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.Entity.Customer;
import com.hand.Entity.Price;
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
	public Price getPriceforPriceConfig(Integer priceId){
		return PriceConfigDao.getPricewithId(priceId);
	}
	public List getPriceConfigList() {
		return PriceConfigDao.getPriceConfigList();
	}
	public List getCustomerList() {
		return PriceConfigDao.getCustomerList();
	}
	public Price getPricewithCandT(String Cus_code,String Type) {
		return PriceConfigDao.getPriceWithCandT(Cus_code, Type);
	}
	public List getCusListWithCandT(String Cus_code, String Type) {
		return PriceConfigDao.getPriceConfigwithCandT(Cus_code, Type);
	}
	public Price getPricewithCandTandF(String Cus_code, String Type, String factory) {
		return PriceConfigDao.getPricewithCandTandF(Cus_code, Type, factory);
	}
}
