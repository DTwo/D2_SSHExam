package com.hand.dao;

import java.util.List;

import com.hand.Entity.OnDiscountAppliedRecords;

public interface OnDiscountAppliedRecordsDao {
	
	public List<OnDiscountAppliedRecords> selectOnDiscountAppliedRecords(String discountName);

}
