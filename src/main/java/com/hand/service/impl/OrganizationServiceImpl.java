package com.hand.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hand.Entity.Organization;
import com.hand.dao.impl.OrganizationDaoImpl;

@Repository("orgServiceImpl")
public class OrganizationServiceImpl {
	@Autowired
	private OrganizationDaoImpl org;
	
	public int addOrganization(Organization organization){
		return org.addOrganization(organization);
	}
	public Organization getOrganization(int id){
		return org.getOrganization(id);
	}
	
	public void editOrganization(Organization organization){
		org.editOrganization(organization);
	}
}
