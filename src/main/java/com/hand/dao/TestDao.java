package com.hand.dao;

import java.io.Serializable;

import com.hand.Entity.Organization;

public interface TestDao {
	
	/**
	 * 测试
	 * @param cus
	 * @return
	 */
	Serializable save(Organization organ); 
}
