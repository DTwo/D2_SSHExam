package com.hand.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hand.Entity.Customer;
import com.hand.Entity.Priceconfig;
import com.hand.service.impl.PriceConfigServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class PriceConfigAction extends ActionSupport{
	
	@Autowired
	private PriceConfigServiceImpl PriceConfigService;
	
	public void addPriceConfig(){
		
		Customer forPriceConfig = PriceConfigService.getCustomerforPriceConfig(1);
		
		Priceconfig priceConfig = new Priceconfig();
		priceConfig.setCustCode(forPriceConfig.getCustomerCode());
		priceConfig.setCustomer(forPriceConfig);
		priceConfig.setDisplayName("基础价");
		priceConfig.setType(forPriceConfig.getType());
		priceConfig.setExcelCol(3);
		priceConfig.setActivity("是");
		priceConfig.setPriveListCol("User_det3");
		if(PriceConfigService.addPriceConfig(priceConfig))System.out.println("插入成功");
		else System.out.println("插入失败");
	}
	
	public void getPriceConfigList(){
		List<Priceconfig> priceConfigList = PriceConfigService.getPriceConfigList();
		for(int i = 0 ; i < priceConfigList.size(); i++){
			System.out.println("Priceconfig id:"+priceConfigList.get(i).getPriceConfigId());
			System.out.println("Priceconfig DisplayName:"+priceConfigList.get(i).getDisplayName());
			System.out.println("Priceconfig Customer:"+priceConfigList.get(i).getCustomer().getCustomerCode());
		}
	
	
	}
	
	
	
}
