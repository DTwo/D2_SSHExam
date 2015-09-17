package com.hand.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.Entity.Price;
import com.hand.dao.impl.PriceDaoImpl;
import com.hand.service.PriceService;

@Service("priceService")
public class PriceServiceImpl implements PriceService{

	@Autowired
	private PriceDaoImpl priceDao;
	
	public boolean addPrice(Price price) {
		boolean result = false;
		try{
			priceDao.addPrice(price);
			result = true;
		}catch(HibernateException e){
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	public List getPriceList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getPricewithConfigId(Integer configId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Price getPriceWithId(Integer priceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
