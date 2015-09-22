package com.hand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hand.Entity.Address;
import com.hand.Entity.Linkman;
import com.hand.dao.impl.LinkManDaoImpl;
@Repository("linkmanServiceImpl")
public class LinkmanServiceImpl {
	@Autowired
	private LinkManDaoImpl linkManDaoImpl;
	public void editLinkMan(Linkman linkman){
		linkManDaoImpl.editLinkMan(linkman);
	}
}
