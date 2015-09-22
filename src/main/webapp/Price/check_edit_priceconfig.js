$(document).ready(function(){
	
	//ajax跨域
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;
	
	$("#Cus_code").text($($("#u107_input")).val());
	$("#Cus_type").text($($("#u115_input")).val());
	
	var user_def = 0;
	//模态框下拉菜单添加PL列名
	for(i=0;i<30;i++){
		user_def += 1;
		$("#select_PLcol").siblings(".dropdown-menu").append('<li><a href="#">user_def'+user_def+'</a></li>');
	}
	//给下拉列表的a标签绑定事件  (在表格中存在的不可添加，不可选中)
	$("#select_PLcol").siblings(".dropdown-menu").find("a").bind("click",function(){
		//alert($(this).text())
		
		$("#select_PLcol").text($(this).text());
	})
	
	
	//点击查询/修改，请求数据添加到下方表格
	$("#u116_input").click(function(){
		var cus_code = $("#u107_input").val();
		var type = $("#u115_input").val();
		alert("cus_code:"+cus_code+"type:"+type);
		
		$.ajax({
			url:server_context+"/PriceConfig_getPriceConfigWithCandT.action",
			data:{
				cus_code:cus_code,
				type:type,
				},
			dataType:'json',
			error:function(){alert("ajax error!!!")},
			success:function(json){
					console.log(json);
					var i = 0;
					var table_th = '<tr class="active"><th>序号</th><th>PL列名</th><th>显示名称</th><th>EXCEL列</th><th>启用</th></tr>';
					$("table").empty();
					$("table").append(table_th);
					if(json.length){
						$.each(json,function(index,array){
							alert("索引："+index);
							i += 1;
							if(array.activity=="是"){
							$("table").append('<tr><td>'+i+'</td><td>'+array.priveListCol+'</td><td>'+array.displayName+'</td><td>'+array.excelCol+'</td><td><input type="checkbox" checked="checked"></td></tr>')
//							$("#displayName"+index).text(array.displayName);
//							$("#ExcelCol"+index).text(array.excelCol);
							}
							else{
								$("table").append('<tr><td>'+i+'</td><td>'+array.priveListCol+'</td><td>'+array.displayName+'</td><td>'+array.excelCol+'</td><td><input type="checkbox"></td></tr>')
							}
						})
					}
					
				}
					
			});
	})
	
	
	$("#u214_input").click(function(){
		$("#Cus_code").text($($("#u107_input")).val());
		$("#Cus_type").text($($("#u115_input")).val());
	})
	
	
	//点击新增配置模态框，将数据请求到服务端保存
	$(".modal-footer").find("#submit").click(function(){
		//从模态框获取数据
		var customerId = $("#select_addr").find(".cusId").text();
		var customerCode =$("#u107_input").val();
		//alert(customerCode);
		var cusType = $("#u115_input").val();
		alert("cusCode:"+customerCode+"cusType:"+cusType);
		var displayName = $("#displayName").val();
		var excelcol = $("#Excelcol").val();
		var Plcol = $("#select_PLcol").text();
		$.ajax({
			url:server_context+"/PriceConfig_addPriceConfig.action",
			data:{
				customerId:customerId,
				cus_code:customerCode,
				type:cusType,
				displayName:displayName,
				excelcol:excelcol,
				privelistcol:Plcol,
				activity:"是"
				},
			dataType:'json',
			error:function(){alert("ajax error!!!")},
			success:function(json){
					//alert(json);
					//console.log(json);
					if(JSON.stringify(json)=="true"){alert("添加成功")}
					else alert("添加失败");
					
				}
					
			});
		
	})
	
	
	
	
})