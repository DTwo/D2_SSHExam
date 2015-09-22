package com.hand.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.Entity.Customer;
import com.hand.Entity.Price;
import com.hand.Entity.Priceconfig;
import com.hand.service.PriceService;
import com.hand.util.JsonUtil;
import com.hand.util.ObjectJsonValueProcessor;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;



public class PriceAction extends ActionSupport{

	private File file;              //文件  
	private String fileFileName;    //文件名   
	private String filePath;        //文件路径
	private String downloadFilePath;  //文件下载路径
	private String fileContentType;   //文件类型
	private String suffix;  //从页面一起传上来的文件后缀名
	private InputStream inputStream; 

	@Autowired
	private PriceService priceService;

	//获取客户简称cus_code和类型type，来获取指定用户的价格表Price
	private String cus_code;
	private String type;
	private String factory;

	//获取工厂型号、有效日期至、有效日期从用于新建Price
	//private String price_factory;
	private String effective_date_from;
	private String effective_date_to;




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
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
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
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getDownloadFilePath() {
		return downloadFilePath;
	}
	public void setDownloadFilePath(String downloadFilePath) {
		this.downloadFilePath = downloadFilePath;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public void uploadExcel(){

		String path = ServletActionContext.getServletContext().getRealPath("/upload");
		//System.out.println(path);
		File file = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹
		Gson gson = new Gson();
		String uploadresult = null;
		String json = null;
		if (!file.exists()) {
			file.mkdir();
		}
		try{
			if(this.file != null){
				file = this.getFile();
				//String ExcelFileName = java.util.UUID.randomUUID().toString()+".xls"; // 采用时间+UUID的方式随即命名
				//String ExcelFileName = UUID.randomUUID().toString()+file.getName().substring(file.getName().lastIndexOf(".")+1);
				String ExcelFileName = UUID.randomUUID().toString()+"."+suffix;
				//System.out.println("保存的文件名："+ExcelFileName);
				File newExcelfile = new File(path,ExcelFileName);
				FileUtils.copyFile(file,newExcelfile);
				System.out.println("保存了一个文件，文件地址："+path+"\n文件名："+ExcelFileName);
				uploadresult = "success";
				readExcel(newExcelfile.getPath());
			}
			else {
				System.out.println("file is null :"+file.getName());
				uploadresult = "error";
			}

		}catch(Exception e){
			e.printStackTrace();
			json = gson.toJson("error");
			outputJson(json);
		}
		json = gson.toJson(uploadresult);
		outputJson(json);
	}


	//通过客户简称Code和类型Type获取指定客户的价格表
	public void getPriceWithCandT(){
		List<Price> pricelist = priceService.getPriceWithCandT(cus_code, type);
		Price activityPrice = null;
		//遍历，把有效时间的那一项返回页面
		for(int i=0;i<pricelist.size();i++){
			//判断有效时间
			if(pricelist.get(i).getEffectiveDateTo()!=null&&pricelist.get(i).getEffectiveDateTo().after(new Date())){
				System.out.println("get a Activity Price");
				activityPrice = pricelist.get(i);
			}
		}
		//输出Price对象
		try{
			JsonConfig jsonConfig = new JsonConfig(); //建立配置
			jsonConfig.setExcludes(new String[]{"customer"});//忽略外联表
			JSONObject jsonObject = JSONObject.fromObject(activityPrice, jsonConfig);
			String json = jsonObject.toString();
			outputJson(json);
		}catch(Exception e){
			e.printStackTrace();
		}


	}

	/**
	 * 保存新增的客户配置（1个Price and n个PriceConfig）
	 */
	public void addPriceandPriceConfig(){
		System.out.println("in addPriceandPriceConfig");
		Customer foraddPrice = priceService.getCusWithCandT(cus_code, type);
		Price newprice = new Price();
		newprice.setCustomer(foraddPrice);
		newprice.setPlCustCode(foraddPrice.getCustomerCode());
		newprice.setType(foraddPrice.getType());
		newprice.setPlYhItem(factory);
		try {
			SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			newprice.setEffectiveDateFrom(temp.parse(effective_date_from));
			newprice.setEffectiveDateTo(temp.parse(effective_date_to));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("字符串转换为日期失败");
		}
		boolean addresult = priceService.addPrice(newprice);
		if(addresult){
			System.out.println("插入成功");
			outputJson("true");
		}
		else{ System.out.println("插入失败");
		outputJson("false");
		}



	}
	/**
	 * 通过客户简称Code和类型Type和工厂型号Factory获取指定客户的价格表
	 */
	public void getPriceWithCandTandF(){
		List<Price> pricelist = priceService.getPriceWithCandTandF(cus_code, type, factory);
		String json = getJson(pricelist);
		System.out.println(json);
		outputJson(json);
	}



	/**
	 * 输出json
	 * @param json
	 */
	public void outputJson(String json){
		try {
			System.out.println("输出的JSON:"+json);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 从数据库中选择指定客户的价格配置表和价格表组装Excel文件
	 */
	public void makeExcel(){

	}

	/**
	 * 将Excel中的数据导入保存到数据库中
	 */
	public void saveExcel(){

	}



	/**
	 * 读取Excel表
	 * @param filePath  --> Excel文件地址
	 */
	public void readExcel(String filePath)  {
		List<Price> pricelist = null;
		Price price = null;
		Sheet sheet = null;
		int rowCount = 0;
		Row row = null;
		int cellCount = 0;
		Cell cell = null;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		try {  
			//同时支持Excel 2003、2007  
			File excelFile = new File(filePath); //创建文件对象  
			FileInputStream is = new FileInputStream(excelFile); //文件流  
			Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
			int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量  
			//遍历每个Sheet  
			for (int s = 0; s < sheetCount; s++) {  
				sheet = workbook.getSheetAt(s);  
				rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数  
				//遍历每一行  
				for (int r = 0; r < rowCount; r++) {  
					row = sheet.getRow(r);  
					cellCount = row.getPhysicalNumberOfCells(); //获取总列数  
					//遍历每一列  
					for (int c = 0; c < cellCount; c++) {  
						cell = row.getCell(c);
						//判断当前单元格是否为空
						if(cell != null){
							int cellType = cell.getCellType();  
							String cellValue = null;  
							switch(cellType) {  
							case Cell.CELL_TYPE_STRING: //文本  
								cellValue = cell.getStringCellValue();  
								break;  
							case Cell.CELL_TYPE_NUMERIC: //数字、日期  
								if(DateUtil.isCellDateFormatted(cell)) {  
									cellValue = fmt.format(cell.getDateCellValue()); //日期型  
								}  
								else {  
									cellValue = String.valueOf(cell.getNumericCellValue()); //数字  
								}  
								break;  
							case Cell.CELL_TYPE_BOOLEAN: //布尔型  
								cellValue = String.valueOf(cell.getBooleanCellValue());  
								break;  
							case Cell.CELL_TYPE_BLANK: //空白  
								cellValue = " ";  
								break;  
							case Cell.CELL_TYPE_ERROR: //错误  
								cellValue = "错误";  
								break;  
							case Cell.CELL_TYPE_FORMULA: //公式  
								cellValue = "错误";  
								break;  
							default:  
								cellValue = "错误";  
							}  
							System.out.print(cellValue + "    " + "test"); 
						}
						else{
							//当前单元格为空时的逻辑操作
						}

					} //end for c
					System.out.println();  
				}  //end for r
			}  

		}  
		catch (Exception e) {  
			e.printStackTrace();  
		}  
	}


	/**
	 * 执行某个对象里的方法
	 * @param entityClass 类名
	 * @param methodName 方法名
	 * @param entity 实体对象
	 * @return 方法执行结果
	 */
	private String getColValue(Class entityClass,String methodName,Object entity){
		String result = "";
		Class c = entityClass;
		try {
			Method method = c.getMethod(methodName);
			result = (String)method.invoke(entity);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}
	//JSON组装
	private String getJson(List priceList){
		Price price = null;
		Set<Priceconfig> priceconfigSet;
		String col = "";
		JsonObject rootJO = new JsonObject();
		JsonArray jArray = new JsonArray();
		JsonObject jsonObject= null;
		JsonObject titleObject = null;
		JsonArray titleArry = new JsonArray();
		JsonObject userDelJO = null;
		JsonArray userDelJA = null;
		for(int i =0 ; i < priceList.size();i++){
			price = (Price)priceList.get(i);
			if(price != null){
				priceconfigSet = price.getPriceconfigs();
				jsonObject = new JsonObject();
				jsonObject.addProperty("plYhItem", price.getPlYhItem());
				jsonObject.addProperty("effectiveDateFrom", price.getEffectiveDateFrom()+"");
				jsonObject.addProperty("effectiveDateTo", price.getEffectiveDateTo()+"");
				String userDef = "";
				userDelJA = new JsonArray();
				for(Priceconfig p:priceconfigSet){
					userDelJO = new JsonObject();
					if(i == 0){
						titleObject = new JsonObject();
						titleObject.addProperty("displayName",p.getDisplayName());
						titleObject.addProperty("excel_col", p.getExcelCol());
						titleArry.add(titleObject);
					}
					col = p.getPriveListCol();
					try{
						//System.out.println("user_def 末尾："+Integer.parseInt(String.valueOf(col.charAt(col.length()-1))));
						//System.out.println("当前"+col);
						Integer.parseInt(String.valueOf(col.charAt(col.length()-1)));
						userDef =getColValue(Price.class,"getUserDef"+col.charAt(col.length()-1),price);
						userDelJO.addProperty("userDef"+col.charAt(col.length()-1), userDef);
						userDelJA.add(userDelJO);
					}
					catch(java.lang.NumberFormatException e){
						//如果是无法转换成数字类型的异常则跳过
						continue;
					}
				}
				jsonObject.add("userDef", userDelJA);
			}
			jArray.add(jsonObject);
		}
		rootJO.add("title", titleArry);
		rootJO.add("data", jArray);
		return rootJO.toString();
	}


}
