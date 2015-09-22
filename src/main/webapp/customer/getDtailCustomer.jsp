<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getDtailCustomer.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<table>
  		<tr><td>客户信息</td></tr>
  		<tr>
  			<td>${sessionScope.customer.customerName }</td>
  			<td>${sessionScope.customer.customerCode }</td>
  			<td>${sessionScope.customer.type }</td>

  		</tr>
  		<tr>
  			<td>${sessionScope.customer.groupCompany }</td>
  			<td>${sessionScope.customer.corporation }</td>
  		</tr>
  	</table>
  	<table>
  		<tr><td>地址信息</td></tr>
  		<tr>
  			<td>${sessionScope.customer.address.country }</td>
  			<td>${sessionScope.customer.address.state }</td>
  			<td>${sessionScope.customer.address.city }</td>
  		</tr>
  		  <tr>
  			<td>${sessionScope.customer.address.addressLine1 }</td>
  			<td>${sessionScope.customer.address.addressLine2 }</td>
  			<td>${sessionScope.customer.address.postcode }</td>
  		</tr>
  		<tr>
  			<td>${sessionScope.customer.address.portOfDestination }</td>
  			<td>${sessionScope.customer.address.shippingMark }</td>
  			<td>${sessionScope.customer.address.status }</td>
  		</tr>
  		<tr>
  			<td>${sessionScope.customer.address.inactuveDate }</td>
  		</tr>
  	</table>
  	<table>
  		<tr><td>联系人</td></tr>
  		<tr>
  			<td>${sessionScope.customer.linkman.mailfrom }</td>
  			<td>${sessionScope.customer.linkman.prepoMailto }</td>
  			<td>${sessionScope.customer.linkman.poMailto }</td>
  		</tr>
  		<tr>
  			<td>${sessionScope.customer.linkman.ocpiMailto }</td>
  			<td>${sessionScope.customer.linkman.invPklistMailto }</td>
  		</tr>
  	</table>
  	<table>
  		<tr><td>组织</td></tr>
  		<tr>
  			<td>${sessionScope.customer.organization.marketArea }</td>
  			<td>${sessionScope.customer.organization.businessManager }</td>
  			<td>${sessionScope.customer.organization.busniessAssistant }</td>
  		</tr>
  		<tr>
  			<td>${sessionScope.customer.organization.finance }</td>
  		</tr>
  	</table>
  </body>
</html>
