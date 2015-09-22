$(document).ready(function(){

	//ajax跨域
	var localObj = window.location;
	var contextPath = localObj.pathname.split("/")[1];
	var basePath = localObj.protocol+"//"+localObj.host+"/"+contextPath;
	var server_context=basePath;
	
	var user_def = 0;
	//模态框下拉菜单添加PL列名
	for(i=0;i<30;i++){
		user_def += 1;
		$("#select_PLcol").siblings(".dropdown-menu").append('<li><a href="#">user_def'+user_def+'</a></li>');
	}

	$("#u323_input").click(function(){
		var Cus_Code = $("#u128_input").val();
		var Cus_Type = $("#u136_input").val();
		var FactoryNum = $("#u319_input").val();
		var space = 0;
		var userDef = 0;
		var userDefNum = 0;
		var titlelength = 0;
		$.ajax({
			url:server_context+"/Price_getPriceWithCandTandF.action",
			data:{
				cus_code:Cus_Code,
				type:Cus_Type,
				factory:FactoryNum,
			},
			dataType:'json',
			error:function(){alert("ajax error!!!")},
			success:function(json){
				//alert(json);
				console.log(json);
//				console.log("排序前：");
				//按excel_col排序，升序
				json.title = json.title.sort(sort_by('excel_col',true,parseInt));
//				console.log("排序后");
//				console.log(json);
				$("table").empty();
				$("table").append('<tr class="info th"><th>NO.</th></tr>');
				if(json.title.length){
//					console.log("排序前："+json);
//					json.title = json.title.sort(sort_by('excel_col',true,parseInt));
//					console.log("排序后"+json);
					//遍历title
					$.each(json.title,function(index1,array1){

						//获取array键值对个数
//						for(var excel_col in array){
//						titlelength += 1;
//						}

						$(".th").append('<th>'+array1.displayName+'</th>');

					})
				}
				if(json.data.length){
					//遍历data
					$.each(json.data,function(index2,array2){
						space += 1;
						$("table").append('<tr id="price_'+space+'"><td>'+space+'</td><td>'+array2.plYhItem+'</td><td>'+array2.effectiveDateFrom+'</td><td>'+array2.effectiveDateTo+'</td></tr>');

//						if(json.data.userDef.length){

							//遍历userDef
//							$.each(array2.userDef,function(index3,array3){
//								;
//								//获取array3--userDef键值对个数
//								for(var excel_col in array2){
//									titlelength += 1;
//								}
//								//alert(titlelength);
//								
//							});
							userDef += 1
							for(var i =0;i<array2.userDef.length;i++){
								//userDefNum += 1;
								//console.log(userDefNum);
//								alert(userDefNum);
							//	console.log(array2.userDef.userDef+i);
								for(var key in array2.userDef[i]){
									console.log(userDef);
									console.log(array2.userDef[i][key]);
									$("#price_"+userDef).append('<td>'+array2.userDef[i][key]+'</td>');
								}
							}
							
//						}
					})


				}

			}

		});
	})

	
	//点击模态框的save,将数据保存到后台
	$(".modal-footer").find("#submit").click(function(){
		var cus_code = $(".modal-body").find("#Cus_code").val();
		var cus_type = $(".modal-body").find("#Cus_type").val();
		var Cus_Factory = $(".modal-body").find("#Cus_Factory").val();
		var effective_date_from = $(".modal-body").find("#effective_date_from").val();
		var effective_date_to = $(".modal-body").find("#effective_date_to").val();
		alert(cus_code+cus_type+Cus_Factory);
		
		$.ajax({
			url:server_context+"/Price_addPriceandPriceConfig.action",
			data:{
				cus_code:cus_code,
				type:cus_type,
				factory:Cus_Factory,
				effective_date_from:effective_date_from,
				effective_date_to:effective_date_to
			},
			dataType:'json',
			error:function(){alert("ajax error!!!")},
			success:function(json){
				if(JSON.stringify(json)=="true"){alert("添加成功")}
				else alert("添加失败");
			}
		});
	})
	
	
	
	
	//定义排序方法  
	sort_by = function(field, reverse, primer){         

		var key = primer ?  
				function(x) {return primer(x[field])} :  
					function(x) {return x[field]};  

					reverse = [-1, 1][+!!reverse];  

					return function (a, b) {  
						return a = key(a), b = key(b), reverse * ((a > b) - (b > a));  
					}   

	}  
	
	
	//点击导入Excel 跳转到导入页面
	$("#u321_input").click(function(){
		location.href="价格表导入.html";
	})
	

})