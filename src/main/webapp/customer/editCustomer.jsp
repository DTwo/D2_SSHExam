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
		
			$("#but2").click(function(){
			alert($("#editAddress").serialize())
				$.ajax({
					type:"POST",
					url:"<%=path %>/customer/EditCustomer_editAddress!editAddress.action",
					dataType:"json",
					data:$("#editAddress").serialize(),
				
				});
			});
			
			$("#but4").click(function(){
			alert($("#editorg").serialize())
				$.ajax({
					type:"POST",
					url:"<%=path %>/customer/EditCustomer_editorg!editorg.action",
					dataType:"json",
					data:$("#editorg").serialize(),
				
				});
			});
			
			$("#but5").click(function(){
			alert($("#editlink").serialize())
				$.ajax({
					type:"POST",
					url:"<%=path %>/customer/EditCustomer_editLinkman!editLinkman.action",
					dataType:"json",
					data:$("#editlink").serialize(),
				
				});
			});
		});
		
	</script>
  </head>
  
  <body>
<div class="container">
	  	<form id="editCus">
  			<div class="row" >
  				<input type="hidden" name="customerId" value="${sessionScope.customer.customerId }">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">客户名称</div>
  				<div class="col-md-2" ><input type="text" name="customerName" value="${sessionScope.customer.customerName }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">类型</div>
  				<div class="col-md-2" "><input type="text" name="type" value="${sessionScope.customer.type }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">集团公司</div>
  				<div class="col-md-2" "><input type="text" name="groupCompany" value="${sessionScope.customer.groupCompany }"></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">客户简称</div>
  				<div class="col-md-2" ><input type="text" name="customerCode" value="${sessionScope.customer.customerCode }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">状态</div>
  				<div class="col-md-2" "><input type="text" name="status" value="待确认"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">总公司</div>
  				<div class="col-md-2" "><input type="text" name="corporation" value="${sessionScope.customer.corporation }"></div>
  			</div>
  			<div class="row" style="padding-top: 10px;">
  				<div class="col-md-2 col-md-offset-10" ><button type="button" id="but1" >保存</div>
  			</div>
	  	</form>
	  	
	  	<br>
	  	
	  	<form id="editAddress">
  			<div class="row" >
  			<input type="hidden" name="addressId" value="${sessionScope.customer.address.addressId }">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">地址行1</div>
  				<div class="col-md-2" ><input type="text" name="addressLine1" value="${sessionScope.customer.address.addressLine1 }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">地址行2</div>
  				<div class="col-md-2" "><input type="text" name="addressLine2" value="${sessionScope.customer.address.addressLine2 }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">城市</div>
  				<div class="col-md-2" "><input type="text" name="city" value="${sessionScope.customer.address.city }"></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">州/省</div>
  				<div class="col-md-2" ><input type="text" name="state" value="${sessionScope.customer.address.state }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">国家</div>
  				<div class="col-md-2" ">
  					<select name="country">
  							<option value="Please choose">Please choose</option>
							<option value="Afghanistan">Afghanistan</option>
							<option value="Albania">Albania</option>
							<option value="Argentina">Argentina</option>
							<option value="Australia">Australia</option>
							<option value="Austria">Austria</option>
							<option value="Bahrain">Bahrain</option>
							<option value="Belgium">Belgium</option>
							<option value="Brazil">Brazil</option>
							<option value="Bulgaria">Bulgaria</option>
							<option value="Chile">Chile</option>
							<option value="China">China</option>
							<option value="Colombia">Colombia</option>
							<option value="Croatia">Croatia</option>
							<option value="Cyprus">Cyprus</option>
							<option value="Czech Republic">Czech Republic</option>
							<option value="Denmark">Denmark</option>
							<option value="Ecuador">Ecuador</option>
							<option value="Egypt">Egypt</option>
							<option value="El Salvador">El Salvador</option>
							<option value="Estonia">Estonia</option>
							<option value="Faroe Islands">Faroe Islands</option>
							<option value="Fiji">Fiji</option>
							<option value="Finland">Finland</option>
							<option value="FYROM">FYROM</option>
							<option value="Germany">Germany</option>
							<option value="Ghana">Ghana</option>
							<option value="Greece">Greece</option>
							<option value="Guatemala">Guatemala</option>
							<option value="Guernsey">Guernsey</option>
							<option value="Honduras">Honduras</option>
							<option value="Hong Kong">Hong Kong</option>
							<option value="Hungary">Hungary</option>
							<option value="Iceland">Iceland</option>
							<option value="India">India</option>
							<option value="Indonesia">Indonesia</option>
							<option value="Ireland">Ireland</option>
							<option value="Italy">Italy</option>
							<option value="Jamaica">Jamaica</option>
							<option value="Jersey">Jersey</option>
							<option value="Kenya">Kenya</option>
							<option value="Kuwait">Kuwait</option>
							<option value="Latvia">Latvia</option>
							<option value="Lithuania">Lithuania</option>
							<option value="France">France</option>
							<option value="Luxembourg">Luxembourg</option>
							<option value="Malaysia">Malaysia</option>
							<option value="Malta">Malta</option>
							<option value="Mexico">Mexico</option>
							<option value="Netherlands">Netherlands</option>
							<option value="New Zealand">New Zealand</option>
							<option value="Nicaragua">Nicaragua</option>
							<option value="Norway">Norway</option>
							<option value="Paraguay">Paraguay</option>
							<option value="Peru">Peru</option>
							<option value="Poland">Poland</option>
							<option value="Portugal">Portugal</option>
							<option value="Romania">Romania</option>
							<option value="Serbia">Serbia</option>
							<option value="Singapore">Singapore</option>
							<option value="Slovenia">Slovenia</option>
							<option value="South Africa">South Africa</option>
							<option value="Spain">Spain</option>
							<option value="Sri Lanka">Sri Lanka</option>
							<option value="Sweden">Sweden</option>
							<option value="Switzerland">Switzerland</option>
							<option value="Turkey">Turkey</option>
							<option value="United Kingdom">United Kingdom</option>
							<option value="Uruguay">Uruguay</option>
							<option selected value="USA">USA</option>
  					</select>
  				</div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">邮编</div>
  				<div class="col-md-2" "><input type="text" name="postcode" value="${sessionScope.customer.address.postcode }"></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">目的港</div>
  				<div class="col-md-2" ><input type="text" name="portOfDestination" value="${sessionScope.customer.address.portOfDestination }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">码头</div>
  				<div class="col-md-2" "><input type="text" name="shippingMark" value="${sessionScope.customer.address.shippingMark }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">有效</div>
  				<div class="col-md-2" "><input type="text" name="status" value="${sessionScope.customer.address.status }"></div>
  			</div>
  			<div class="row">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">失效日期</div>
  				<div class="col-md-2" "><input type="text" name="inactuveDate" value="${sessionScope.customer.address.inactuveDate }"></div>
  			</div>
  			<div class="row" style="padding-top: 10px;">
  				<div class="col-md-2 col-md-offset-10" ><button type="button" id="but2" >保存</div>
  			</div>
	  	</form>
	  	
	  	<br>
	  	<form id="editPay">
  			<div class="row" >
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">所属发票组</div>
  				<div class="col-md-2" ><input type="text" name="customerName" value=""></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">通用加价条款</div>
  				<div class="col-md-2" "><input type="text" name="type" value=""></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">结算货币</div>
  				<div class="col-md-2" "><input type="text" name="groupCompany" value=""></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">一般折扣</div>
  				<div class="col-md-2" ><input type="text" name="customerCode" value=""></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">付款条件</div>
  				<div class="col-md-2" "><input type="text" name="status" value=""></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">价格条款1</div>
  				<div class="col-md-2" "><textarea rows="10" cols="50" name=""></textarea></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">价格条款2</div>
  				<div class="col-md-2" "><textarea rows="10" cols="50" name=""></textarea></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">价格条款3</div>
  				<div class="col-md-2" "><textarea rows="10" cols="50" name=""></textarea></div>
  			</div>

  			<div class="row" style="padding-top: 10px;">
  				<div class="col-md-2 col-md-offset-10" ><button type="button" id="but3" >保存</div>
  			</div>
	  	</form>
	  	
	  	<br>
	  	
	  	<form id="editorg">
  			<div class="row" >
  			<input type="hidden" name="organizationId" value="${sessionScope.customer.organization.organizationId }">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">所属TEAM</div>
  				<div class="col-md-2" ><input type="text" name="marketArea" value="${sessionScope.customer.organization.marketArea }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">业务经理</div>
  				<div class="col-md-2" "><input type="text" name="businessManager" value="${sessionScope.customer.organization.businessManager }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">业务助理</div>
  				<div class="col-md-2" "><input type="text" name="busniessAssistant" value="${sessionScope.customer.organization.busniessAssistant }"></div>
  			</div>
  			<div class="row" style="padding-top: 10px;">
  				<div class="col-md-2 col-md-offset-10" ><button type="button" id="but4" >保存</div>
  			</div>
	  	</form>
	  	<br>
	  	
	  	<form id="editlink">
  			<div class="row" >
  			<input type="hidden" name="customerId" value="${sessionScope.customer.linkman.customerId }">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">发件人邮箱</div>
  				<div class="col-md-2" ><input type="text" name="mailfrom" value="${sessionScope.customer.linkman.mailfrom }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">Pre PO 收件人</div>
  				<div class="col-md-2" "><input type="text" name="prepoMailto" value="${sessionScope.customer.linkman.prepoMailto }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">PO 收件人</div>
  				<div class="col-md-2" "><input type="text" name="poMailto" value="${sessionScope.customer.linkman.poMailto }"></div>
  			</div>
  			<div class="row" style=" padding-top: 10px">
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">OC/PI收件人</div>
  				<div class="col-md-2" ><input type="text" name="ocpiMailto" value="${sessionScope.customer.linkman.ocpiMailto }"></div>
  				<div class="col-md-2" style="width: 90px; margin-left: 70px;">INV/Packing list 收件人</div>
  				<div class="col-md-2" "><input type="text" name="invPklistMailto" value="${sessionScope.customer.linkman.invPklistMailto }"></div>
  			</div>
  			<div class="row" style="padding-top: 10px;">
  				<div class="col-md-2 col-md-offset-10" ><button type="button" id="but5" >保存</div>
  			</div>
	  	</form>
	  	  		
  	</div>
  	
  </body>
</html>
