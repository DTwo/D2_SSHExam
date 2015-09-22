package com.hand.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.hand.Entity.Customer;
import com.hand.Entity.Price;
import com.hand.Entity.Priceconfig;
import com.hand.service.PriceConfigService;
import com.hand.service.PriceService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class PriceConfigAction extends ActionSupport{

	@Autowired
	private PriceConfigService PriceConfigService;
	@Autowired
	private PriceService priceService;
	
	//接收新增客户配置页面数据
	private String customerId;
	private String cus_code;
	private String type;
	private String factoryNum;
	private String effective_date_from;
	private String activity;
	private String effective_date_to;
	
	
	
	

	public String getFactoryNum() {
		return factoryNum;
	}
	public void setFactoryNum(String factoryNum) {
		this.factoryNum = factoryNum;
	}
	public String getEffective_date_from() {
		return effective_date_from;
	}
	public void setEffective_date_from(String effective_date_from) {
		this.effective_date_from = effective_date_from;
	}
	public String getEffective_date_to() {
		return effective_date_to;
	}
	public void setEffective_date_to(String effective_date_to) {
		this.effective_date_to = effective_date_to;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCus_code() {
		return cus_code;
	}
	public void setCus_code(String cus_code) {
		this.cus_code = cus_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void addPriceConfig(){
		//获取当前指定的客户来配置价格表
		System.out.println("in addPriceConfig");
		//Customer forPriceConfig = PriceConfigService.getCustomerforPriceConfig(Integer.valueOf(customerId));
		//先保存Price表
		System.out.println(cus_code);
		Customer forPriceConfig = priceService.getCusWithCandT(cus_code, type);
		Price newprice = new Price();
		newprice.setCustomer(forPriceConfig);
		newprice.setPlCustCode(forPriceConfig.getCustomerCode());
		newprice.setType(forPriceConfig.getType());
		newprice.setPlYhItem(factoryNum);
		try {
			SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			newprice.setEffectiveDateFrom(temp.parse(effective_date_from));
			newprice.setEffectiveDateTo(temp.parse(effective_date_to));
		}catch(Exception e){
			e.printStackTrace();
		}
		if(priceService.addPrice(newprice)){
			outputJson("success");
		}
		//再将price表的工厂列，有效日期从列，有效日期到列添加到priceconfig表
		Price priceforPriceConfig = PriceConfigService.getPricewithCandTandF(cus_code, type,factoryNum);
		Priceconfig priceConfig = new Priceconfig();
		priceConfig.setCustCode(cus_code);
		priceConfig.setDisplayName("工厂型号");
		priceConfig.setType(type);
		priceConfig.setExcelCol(2);
		priceConfig.setActivity(activity);
		priceConfig.setPriveListCol("PL_YH_ITEM");
		priceConfig.setPrice(priceforPriceConfig);
		Priceconfig priceConfig1 = new Priceconfig();
		priceConfig1.setPrice(priceforPriceConfig);
		priceConfig1.setCustCode(cus_code);
		priceConfig1.setType(type);
		priceConfig1.setExcelCol(3);
		priceConfig1.setDisplayName("有效日期从");
		priceConfig1.setPriveListCol("effective_date_from");
		priceConfig1.setActivity(activity);
		
		Priceconfig priceConfig2 = new Priceconfig();
		priceConfig2.setPrice(priceforPriceConfig);
		priceConfig2.setCustCode(cus_code);
		priceConfig2.setType(type);
		priceConfig2.setExcelCol(4);
		priceConfig2.setDisplayName("有效日期至");
		priceConfig2.setPriveListCol("effective_date_to");
		priceConfig2.setActivity(activity);
		
		if(PriceConfigService.addPriceConfig(priceConfig)&&
				PriceConfigService.addPriceConfig(priceConfig1)&&
					PriceConfigService.addPriceConfig(priceConfig2)){
			System.out.println("插入成功");
			outputJson("true");
		}
		else{ System.out.println("插入失败");
			outputJson("false");
		}
	}
	
	
	public void getPriceConfigList(){
		List<Priceconfig> priceConfigList = PriceConfigService.getPriceConfigList();
//		for(int i = 0 ; i < priceConfigList.size(); i++){
//			System.out.println("Priceconfig id:"+priceConfigList.get(i).getPriceConfigId());
//			System.out.println("Priceconfig DisplayName:"+priceConfigList.get(i).getDisplayName());
//			System.out.println("Priceconfig Customer:"+priceConfigList.get(i).getCustomer().getCustomerCode());
//		}
		
		

	}
	
	
	public void getCustomerList(){
		List<Customer>  cuslist = PriceConfigService.getCustomerList();
		try{
			JsonConfig jsonConfig = new JsonConfig(); //建立配置
			jsonConfig.setExcludes(new String[]{"prices","organization","linkman","address","payments","omSpecialDiscounts","priceconfigs","onDiscountAppliedRecordses","omNormalDiscounts"});//忽略外联表
			JSONArray jsonArray = JSONArray.fromObject(cuslist, jsonConfig);
			String json = jsonArray.toString();
		outputJson(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("OK");
	}
	
	
	public void getPriceConfigWithCandT(){
		List<Priceconfig> priceConfigList = PriceConfigService.getCusListWithCandT(cus_code, type);
		System.out.println("");
		try{
			JsonConfig jsonConfig = new JsonConfig(); //建立配置
			jsonConfig.setExcludes(new String[]{"price"});//忽略外联表
			JSONArray jsonArray = JSONArray.fromObject(priceConfigList, jsonConfig);
			String json = jsonArray.toString();
			outputJson(json);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 输出json
	 * @param json
	 */
	public void outputJson(String json){
		try {
			System.out.println(json);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/json");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
