package com.hand.action;

import java.util.List;

import com.hand.Entity.OmSpecialDiscount;
import com.hand.dao.impl.OmSpecialDiscountDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class OneDiscountAction extends ActionSupport {

	private List<OmSpecialDiscount> omSpecialDiscounts;

	private String cust_code;
	
	private OmSpecialDiscountDaoImpl opdDao;
	
	private OmSpecialDiscount omSpecialDiscount;

	public OmSpecialDiscountDaoImpl getOpdDao() {
		return opdDao;
	}

	public void setOpdDao(OmSpecialDiscountDaoImpl opdDao) {
		this.opdDao = opdDao;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String select() {
		omSpecialDiscounts = opdDao.selectOmSpecialDiscount(cust_code);
		return SUCCESS;
	}
	
	public String send(){
		return "send";
	}
	
	public String update(){
		opdDao.updateOmSpecialDiscount(omSpecialDiscount);
		return SUCCESS;
	}
	
	public List<OmSpecialDiscount> getOmSpecialDiscounts() {
		return omSpecialDiscounts;
	}

	public void setOmSpecialDiscounts(List<OmSpecialDiscount> omSpecialDiscounts) {
		this.omSpecialDiscounts = omSpecialDiscounts;
	}

	public String getCust_code() {
		return cust_code;
	}

	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	public OmSpecialDiscount getOmSpecialDiscount() {
		return omSpecialDiscount;
	}

	public void setOmSpecialDiscount(OmSpecialDiscount omSpecialDiscount) {
		this.omSpecialDiscount = omSpecialDiscount;
	}
}
