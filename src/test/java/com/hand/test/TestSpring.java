package com.hand.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.dao.impl.OmNormalDiscountDaoImp;
import com.hand.service.TestService;

public class TestSpring {
	
	private OmNormalDiscountDaoImp ondDao;
	
	
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml","Discount_spring.xml"});
		OmNormalDiscountDaoImp haha = (OmNormalDiscountDaoImp) ac.getBean("ondDao");
		System.out.println(haha.showOmNoramlDiscount());
//		ond.showOmNoramlDiscount();
	}


	public OmNormalDiscountDaoImp getOnd() {
		return ondDao;
	}


	public void setOnd(OmNormalDiscountDaoImp ondDao) {
		this.ondDao = ondDao;
	}

	
	
}
