package com.hand.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.Entity.Organization;
import com.hand.dao.TestDao;
import com.hand.service.TestService;

@Service("TestService")
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDao TestDao;
	
	public void Test() {
		System.out.println("In TestServiceImpl : Hello World!");
		
	}

	public Serializable save(Organization organ) {
		return TestDao.save(organ);
	}




}
