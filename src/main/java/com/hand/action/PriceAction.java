package com.hand.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;



public class PriceAction extends ActionSupport{

	private File file;              //文件  
	private String fileFileName;    //文件名   
	private String filePath;        //文件路径
	private String downloadFilePath;  //文件下载路径
	private String fileContentType;   //文件类型
	private String suffix;  //从页面一起传上来的文件后缀名

	
	

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
	private InputStream inputStream; 
	
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
	
	
	
	public void outputJson(String json){
		try {
			System.out.println(json);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 读取Excel表
	 * @param filePath  --> Excel文件地址
	 */
	public void readExcel(String filePath)  {
		 SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		    try {  
		        //同时支持Excel 2003、2007  
		        File excelFile = new File(filePath); //创建文件对象  
		        FileInputStream is = new FileInputStream(excelFile); //文件流  
		        Workbook workbook = WorkbookFactory.create(is); //这种方式 Excel 2003/2007/2010 都是可以处理的  
		        int sheetCount = workbook.getNumberOfSheets();  //Sheet的数量  
		        //遍历每个Sheet  
		        for (int s = 0; s < sheetCount; s++) {  
		            Sheet sheet = workbook.getSheetAt(s);  
		            int rowCount = sheet.getPhysicalNumberOfRows(); //获取总行数  
		            //遍历每一行  
		            for (int r = 0; r < rowCount; r++) {  
		                Row row = sheet.getRow(r);  
		                int cellCount = row.getPhysicalNumberOfCells(); //获取总列数  
		                //遍历每一列  
		                for (int c = 0; c < cellCount; c++) {  
		                    Cell cell = row.getCell(c);
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
	
}
