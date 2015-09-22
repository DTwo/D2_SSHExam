package com.hand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Address;
import com.hand.dao.impl.AddressDaoImpl;
@Repository("addressServiceImpl")
public class AddressServiceImpl {
	@Autowired
	private AddressDaoImpl addressDaoImpl;
	
	public void editAddress(Address address){
		System.out.println("进入AddressServiceImpl类");
		addressDaoImpl.editAddress(address);
	}
}
