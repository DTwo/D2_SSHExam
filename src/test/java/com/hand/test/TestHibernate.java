package com.hand.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.Entity.Customer;
import com.hand.Entity.Organization;
import com.hand.service.impl.TestServiceImpl;

public class TestHibernate {
	
	private TestServiceImpl TestService;
	
	@Before
	public void before(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
		TestService = (TestServiceImpl) ac.getBean("TestService");
	}
	
	@Test
	public void test(){
		Organization or = new Organization();
		or.setBusinessManager("test");
		or.setBusniessAssistant("test");
		or.setMarketArea("test");
		TestService.save(or);
		
	}
}
