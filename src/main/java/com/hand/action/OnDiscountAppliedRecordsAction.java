package com.hand.action;

import java.util.List;

import com.hand.Entity.OmSpecialDiscount;
import com.hand.Entity.OnDiscountAppliedRecords;
import com.hand.dao.impl.OnDiscountAppliedRecordsDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class OnDiscountAppliedRecordsAction extends ActionSupport {

	private OnDiscountAppliedRecordsDaoImpl odarDao;

	private OmSpecialDiscount omSpecialDiscount;

	private List<OnDiscountAppliedRecords> onDiscountAppliedRecords;

	public String select() {
		onDiscountAppliedRecords = odarDao.selectOnDiscountAppliedRecords(omSpecialDiscount.getDiscountName());
		return "send2";
	}

	public OmSpecialDiscount getOmSpecialDiscount() {
		return omSpecialDiscount;
	}

	public void setOmSpecialDiscount(OmSpecialDiscount omSpecialDiscount) {
		this.omSpecialDiscount = omSpecialDiscount;
	}

	public OnDiscountAppliedRecordsDaoImpl getOdarDao() {
		return odarDao;
	}

	public void setOdarDao(OnDiscountAppliedRecordsDaoImpl odarDao) {
		this.odarDao = odarDao;
	}

	public List<OnDiscountAppliedRecords> getOnDiscountAppliedRecords() {
		return onDiscountAppliedRecords;
	}

	public void setOnDiscountAppliedRecords(List<OnDiscountAppliedRecords> onDiscountAppliedRecords) {
		this.onDiscountAppliedRecords = onDiscountAppliedRecords;
	}

}
