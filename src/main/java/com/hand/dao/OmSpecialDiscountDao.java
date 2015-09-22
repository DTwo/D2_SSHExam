package com.hand.dao;

import java.util.List;

import com.hand.Entity.OmSpecialDiscount;

public interface OmSpecialDiscountDao {
	public List<OmSpecialDiscount> selectOmSpecialDiscount(String cust_code);
	
	public void updateOmSpecialDiscount(OmSpecialDiscount omSpecialDiscount);
}
