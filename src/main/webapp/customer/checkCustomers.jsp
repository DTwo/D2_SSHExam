<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkCustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="customer/css/bootstrap.min.css" type="text/css">
	<script type="text/javascript" src="customer/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#but").click(function(){
			$.ajax({
				contentType:"application/x-www-form-urlencoded;charset=UTF-8",
				type:"POST",
				url:"<%=path %>/customer/CheckCustomer_jsonShow!jsonShow.action",
				dataType:"json",
/*  				data:{
					"customerName":customerName,
					"type":type,
					"groupCompany":groupCompany,
					"customerCode":customerCode,
					"status":status,
					"corporation":corporation,
				},  */
				data:$("#form").serialize(),
				success:function(data){
					var row ;
					alert("hello");
					alert($("#form").serialize());
					
 					$.each(data,function(index,value){
							row+="<div class='row'><div class='col-md-1'>"+value.customerName+"</div>"+
								"<div class='col-md-1'>"+value.customerCode+"</div>"+
								"<div class='col-md-1'>"+value.type+"</div>"+
								"<div class='col-md-2'>"+value.corporation+"</div>"+
								"<div class='col-md-2'>"+value.groupCompany+"</div>"+
								"<div class='col-md-1'><a href='<%=path%>/customer/CheckCustomer_getCustomer!getCustomer.action?customerId="+value.CustomerId
								+"'>查看</a>"+"</div>"+
								"<div class='col-md-1'><a href='<%=path%>/customer/CheckCustomer_editCustomer!editCustomer.action?customerId="+value.CustomerId
								+"'>编辑</a>"+"</div></div>"
						}); 
						$("#customer").html(row);
						/* $(selector).each(function(index,val){
							row+="<tr><td>"+val.customerName+
								"</td><td>"+val.customerCode+
								"</td><td>"+val.type+
								"</td><td>"+val.corporation+
								"</td><td>"+val.groupCompany+
								"</td><td><a href='EditCustomer_check!check.action?customerId='"+value.customerId
								+"查看</a>"+
								"</td><td><a href='EditCustomer_edit!check.action?customerId='"+value.customerId
								+"编辑</a>"
						}); */
				},
			
			
			});
		});
		
		});
		
		
		
	</script>
  </head>
  
  <body>
  	<div class="container">
  		
  			<form id="form">
  			<div class="row" >
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">客户名称</div>
  				<div class="col-md-2" ><input type="text" name="customerName"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">类型</div>
  				<div class="col-md-2" "><input type="text" name="type"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">集团公司</div>
  				<div class="col-md-2" "><input type="text" name="groupCompany"></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">客户简称</div>
  				<div class="col-md-2" ><input type="text" name="customerCode"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">状态</div>
  				<div class="col-md-2" "><input type="text" name="status" value="待确认"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">总公司</div>
  				<div class="col-md-2" "><input type="text" name="corporation"></div>
  			</div>
  			<div class="row" style="padding-top: 10px;">
  				<div class="col-md-2 col-md-offset-4" ><button type="button" id="but" >查询</div>
  				<div class="col-md-2"><input type="button" value="新建" onclick="window.location.href='customer/createCustomer.jsp'"></div>
  			</div>
  			</form>
  		<div id="customer"></div>
  	</div>
  	
  </body>
</html>
