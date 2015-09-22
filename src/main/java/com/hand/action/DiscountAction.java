package com.hand.action;

import java.util.List;

import com.hand.Entity.OmNormalDiscount;
import com.hand.dao.impl.OmNormalDiscountDaoImp;
import com.opensymphony.xwork2.ActionSupport;

public class DiscountAction extends ActionSupport {
	
	
	private OmNormalDiscount ondEntity;

	private List<OmNormalDiscount> omNormalDiscounts;

	private OmNormalDiscountDaoImp ondDao;

	@Override
	public String execute() throws Exception {
		omNormalDiscounts = ondDao.showOmNoramlDiscount();
		return SUCCESS;
	}

	public String showOmNormalDiscounts() {
		omNormalDiscounts = ondDao.showOmNoramlDiscount();
		return SUCCESS;
	}
	
	public String addOmNormalDiscount(){
		ondDao.insertOmNoramlDiscount(ondEntity);
		omNormalDiscounts = ondDao.showOmNoramlDiscount();
		return SUCCESS;
	}
	
	public String updateOmNormalDiscount(){
		ondDao.updateOmNoramlDiscount(ondEntity);
		omNormalDiscounts = ondDao.showOmNoramlDiscount();
		return SUCCESS;
	}
	
	public String send(){
		return "update";
	}

	public List<OmNormalDiscount> getOmNormalDiscounts() {
		return omNormalDiscounts;
	}

	public void setOmNormalDiscounts(List<OmNormalDiscount> omNormalDiscounts) {
		this.omNormalDiscounts = omNormalDiscounts;
	}

	public OmNormalDiscountDaoImp getOndDao() {
		return ondDao;
	}

	public void setOndDao(OmNormalDiscountDaoImp ondDao) {
		this.ondDao = ondDao;
	}

	public OmNormalDiscount getOndEntity() {
		return ondEntity;
	}

	public void setOndEntity(OmNormalDiscount ondEntity) {
		this.ondEntity = ondEntity;
	}
	
	
}
