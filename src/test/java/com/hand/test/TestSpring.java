package com.hand.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.service.TestService;

public class TestSpring {
	
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
		TestService testService = (TestService)ac.getBean("TestService");
		testService.Test();
	}

}
