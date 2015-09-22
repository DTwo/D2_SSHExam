<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<script type="text/javascript" src="customer/js/jquery-2.1.4.min.js"></script>
<title>My JSP 'createCustomer.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	$(document).ready(function(){
		$("#sub").click(function(check){
			$("form :input.require").each(function(){
				if($(this).val()==""){
					alert($(this).prop("name")+"带*不能为空");
					check.preventDefault();
				}
			});
		});
	});
	
</script>
</head>

<body>


	<div>

		<form action="<%=path %>/customer/customer.action" method="post">
			<table>
				<tr>
					<td>*客户简称：<select name="customerCode">
						<option value="ATW-J">ATW-J</option>
						<option value="ATW-M">ARM-M</option>
						<option value="ATW">ATW</option>
						<option value="GTW">GTW</option>
						<option value="GBH">GBH</option>
					</select></td>
					<td>*客户名称：<input type="text" name="customerName" class="require"></td>
					<td>*类型：<select name="type">
						<option value="GG200">GG200</option>
						<option value="STD">STD</option>
					</select></td>
				</tr>
				<tr>
					<td>集团公司:<input type="text" name="groupCompany"></td>
					<td>总公司:<input type="text" name="corporation"></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td>*国别 <select id="u136_input" name="country" class="require">
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
					</td>
					<td>
						州/省<input type="text" name="state">
					</td>
					<td>
						城市<input type="text" name="city">
					</td>

				</tr>
				<tr>
					<td>地址行1:<input type="text" name="addressLine1"></td>
					<td>地址行2：<input type="text" name="addressLine2"></td>
					<td>邮编:<input type="text" name="postcode"></td>
				</tr>
				<tr>
					<td>*目的港名称：<input type="text" name="portOfDestination" class="require"></td>
					<td>*码头:<input type="text" name="shippingMark" class="require"></td>
					<td>*状态：<input type="text" name="status" value="待确认" readonly="readonly" class="require"></td>
				</tr>
				<tr>
					<td colspan="3"><input type="text" name="inactiveDate"></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td>所属发票组：<input type="text" name="invoiceGroup"></td>
					<td>*结算货币:<select name="currency" class="require">
						<option value="$">$</option>
						<option value="￥">￥</option>
					</select></td>
					<td>*付款方式:<input type="text" name="paymentTerm" class="require"></select>
				</tr>
				<tr>
					<td>价格条款1：<input type="text" name="priceTerm1"></td>
					<td>价格条款2：<input type="text" name="priceTerm2"></td>
					<td>价格条款3：<input type="text" name="priceTerm3"></td>
					
				</tr>
				<tr>
					<td>*通用加价条款：<input type="text" name="markupName" value="低于50片加价5%" class="require"></td>
					<td>*一般折扣:<input type="text" name="discountName" value="无折扣" class="require"></td>
				</tr>
			</table>
		<br>
			<table>
				<tr>
					<td>*市场区域：<select name="marketArea">
						<option value="德国">德国</option>
						<option value="亚太">亚太</option>
						<option value="欧洲2">欧洲2</option>
						<option value="美国">美国</option>
						<option value="欧洲1">欧洲1</option>
						<option value="OEM">OEM</option>
					</select></td>
					<td>
						*业务经理：<select name="businessManager">
							<option value="郑晓彬经理">郑晓彬经理</option>
							<option value="何家俊经理">何家俊经理</option>
							<option value="张艺亨经理">张艺亨经理</option>
						</select>
					</td>
					<td>
						*业务员：<select name="businessAssistant">
							<option value="郑晓彬业务员">郑晓彬业务员</option>
							<option value="何家俊业务员">何家俊业务员</option>
							<option value="张艺亨业务员">张艺亨业务员</option>
						</select>
					</td>
					<td>
						*财务：<select name="finance">
							<option value="有钱人郑晓彬">有钱人郑晓彬</option>
							<option value="有钱人何家俊">有钱人何家俊</option>
							<option value="有钱人张艺亨">有钱人张艺亨</option>
						</select>
					</td>
				</tr>
			</table>
			<br>
			
			<table>
				<tr>
					<td>发件人:<input type="text" name="mailFrom"></td>
					<td>Pre Po收件人<input type="text" name="prepoMailto"></td>
					<td>po收件人<input type="text" name="poMailto"></td>
				</tr>
				<tr>
					<td>oc/pi收件人<input type="text" name="ocpiMaito"></td>
					<td>INV/packing list收件人<input type="text" name="invPklistMailto"></td>
				</tr>
			</table>

			<!-- <input type="button" id="sub" value="提交"> -->
			<button type="submit" id="sub">提交</button>
		<form>

	</div>

</body>
</html>
