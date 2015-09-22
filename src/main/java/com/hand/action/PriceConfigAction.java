package com.hand.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.hand.Entity.Customer;
import com.hand.Entity.Price;
import com.hand.Entity.Priceconfig;
import com.hand.service.PriceConfigService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class PriceConfigAction extends ActionSupport{

	@Autowired
	private PriceConfigService PriceConfigService;
	
	//接收新增客户配置页面数据
	private String customerId;
	private String cus_code;
	private String type;
	private String displayName;
	private String excelcol;
	private String activity;
	private String privelistcol;
	
	
	
	
	public String getPrivelistcol() {
		return privelistcol;
	}
	public void setPrivelistcol(String privelistcol) {
		this.privelistcol = privelistcol;
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
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getExcelcol() {
		return excelcol;
	}
	public void setExcelcol(String excelcol) {
		this.excelcol = excelcol;
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
		Price forPriceConfig = PriceConfigService.getPricewithCandT(cus_code, type);
		Priceconfig priceConfig = new Priceconfig();
		priceConfig.setCustCode(cus_code);
		priceConfig.setDisplayName(displayName);
		priceConfig.setType(type);
		priceConfig.setExcelCol(Integer.valueOf(excelcol));
		priceConfig.setActivity(activity);
		priceConfig.setPriveListCol(privelistcol);
		priceConfig.setPrice(forPriceConfig);
		if(PriceConfigService.addPriceConfig(priceConfig)){
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
