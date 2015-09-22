package com.hand.service.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.Entity.Customer;
import com.hand.Entity.Price;
import com.hand.dao.PriceDao;
import com.hand.service.PriceService;

@Service("priceService")
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceDao priceDao;

	public boolean addPrice(Price price) {
		System.out.println("in addService");
		boolean result = false;
		try {
			priceDao.addPrice(price);
			result = true;
		} catch (Exception e) {
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

	public List getPriceWithCandT(String cus_code, String type) {
		return priceDao.getPricewithCandT(cus_code, type);
	}

	public List getPriceWithCandTandF(String cus_code, String type, String Factory) {
		return priceDao.getPriceWithCandTandF(cus_code, type, Factory);
	}

	public Customer getCusWithCandT(String cus_code, String type) {

		return priceDao.getCusWithCandT(cus_code, type);
	}

}
