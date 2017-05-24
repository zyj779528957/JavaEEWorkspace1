

$(function(){	   
	//用户名	   
	$("#username").blur(function(){
		var username=$(this).val();						  
		if(username.length==0){		
			$("#susername").html("<span style='color:red;'>用户名不能为空</span>");
		}		
		if(username.length>10){
			$("#susername").html("<span style='color:red;'>用户名长度不能超过10位</span>");
		}
	});	
	
	//密码
	$("#pwd").blur(function(){
		var pwd=$(this).val();
		if(pwd.length==0){
			$("#spwd").html("<span style='color:red;'>密码不能为空</span>");	
		}			  
	});
	
	//确认密码
	$("#confirmpwd").blur(function(){
		var pwd=$("#pwd").val();
		var confirmpwd=$(this).val();
		if(confirmpwd != pwd){
			$("#sconfirmpwd").html("<span style='color:red;'>两次输入不匹配</span>");	
		}else{
			$("#sconfirmpwd").html("");
		}			  
	});
});		

