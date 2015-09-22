package com.hand.dao;

import java.util.List;

import com.hand.Entity.OmNormalDiscount;

public interface OmNormalDiscountDao {

	public List<OmNormalDiscount> showOmNoramlDiscount();

	public void insertOmNoramlDiscount(OmNormalDiscount omNormalDiscount);

	public void updateOmNoramlDiscount(OmNormalDiscount omNormalDiscount);

}
