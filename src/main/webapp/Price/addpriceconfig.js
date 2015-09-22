$(document).ready(function(){
	//ajax跨域
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;
	
	
	//表格中添加30行预留格
	var colNum = 3;
	var user_def = 0;
	var tdId = 2;
	var i = 0;
	for(i =0;i<30;i++){
		colNum +=1;
		user_def +=1;
		tdId +=1;
	$("#u196").find("table").append('<tr><td>'+colNum+'</td><td>user_def'+user_def+'</td><td id="displayName'+tdId+'"></td><td id="ExcelCol'+tdId+'"></td><td><input type="checkbox"></td></tr>');
		
	}
	user_def = 0;
	//添加下拉列表中的PL列名
	for(i=0;i<30;i++){
		user_def +=1;
	$("#select_PLcol").siblings(".dropdown-menu").append('<li><a href="#">user_def'+user_def+'</a></li>');
	
	}
	//给下拉列表的a标签绑定事件
	$("#select_PLcol").siblings(".dropdown-menu").find("a").bind("click",function(){
		//alert($(this).text())
		$("#select_PLcol").text($(this).text());
	})
	
	//模态框下拉菜单，点击请求数据添加在下拉列中
	$(".dropdown").find("#select_addr").click(function(){
		$.ajax({
			url:server_context+"/PriceConfig_getCustomerList.action",
			dataType:'json',
			error:function(){console.log("ajax,error!")},
			success:function(json)
			{
				console.log(json);
				
				var str = "";
				if(json.length){
					$.each(json,function(index,array){
						//str += '<li> <a href="#" id = "'+array.addressId+'">'+array.address+'</a></li>';
						str += '<li> <a href="#" id="'+array.customerId+'">'+array.customerCode+'</a></li>';
					})
					
				}
				//json.length跳出添加元素
				console.log(str);
				$(".cuslist").find(".dropdown-menu").empty();
				$(".cuslist").find(".dropdown-menu").append(str);
				//给刚添加的a标签绑定点击事件
				$("#select_addr").siblings(".dropdown-menu").find("a").bind("click", function (){
					//alert("in li a bind");
					//alert($(this).text());
					//alert($(this).attr("id"));
					$("#select_addr").text($(this).text());
					$("#select_addr").append('<span class="hidden cusId">'+$(this).attr("id")+'</span>');
				})
			}
		});
	})
	
	
	
	
	//点击新增配置模态框，将数据请求到服务端保存
	$(".modal-footer").find("#submit").click(function(){
		//从模态框获取数据
		var customerId = $("#select_addr").find(".cusId").text();
		var customerCode = $("#select_addr").text();
		//alert(customerCode);
		var cusType = $("#cusType").val();
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
	
	
//	//点击查询/修改，请求数据添加到下方表格
//	$("#u114_input").click(function(){
//		var cus_code = $("#u105_input").val();
//		var type = $("#u113_input").val();
//		alert("cus_code:"+cus_code+"type:"+type);
//		
//		$.ajax({
//			url:server_context+"/PriceConfig_getPriceConfigWithCandT.action",
//			data:{
//				cus_code:cus_code,
//				type:type,
//				},
//			dataType:'json',
//			error:function(){alert("ajax error!!!")},
//			success:function(json){
//					console.log(json);
//					
//					if(json.length){
//						$.each(json,function(index,array){
//							alert("索引："+index);
//							
//							$("#displayName"+index).text(array.displayName);
//							$("#ExcelCol"+index).text(array.excelCol);
//						})
//					}
//					
//				}
//					
//			});
//	})
	
	
	$("#u114_input").click(function(){
		location.href="价格表配置查询_编辑.html";
	})
	
	
	
})