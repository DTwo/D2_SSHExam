package com.hand.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.Organization;
import com.hand.service.TestService;

@ParentPackage("basePackage")
@Action(value="strust2")
@Namespace("/")
public class TestAction {
	
	@Autowired
	private TestService TestService;
	
	
	 public void test(){
		 System.out.println("进入TestAction");
		 TestService.Test();
	 }
	 
	 public void saveOrganazition(){
		 Organization or = new Organization();
			or.setBusinessManager("test111");
			or.setBusniessAssistant("test111");
			or.setMarketArea("test111");
			TestService.save(or);
	 }
}
