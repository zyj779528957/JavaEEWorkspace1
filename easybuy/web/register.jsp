<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>易买网-注册（register page）</title>
	<script src="js/jquery-1.11.1.js"></script>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/login-register.css">
	<script type="text/javascript" src="scripts/function.js"></script>
	<script src="js/adddate.js"></script>
	<script type="text/javascript">
		$(function(){

			//用户名
			 $("#userName").blur(function() {
				var userName=$(this).val();
				if(userName.length==0){
					$("#sUserName").show();
					$("#sUserName").html("用户名不能为空");
				}else{
					//ajax局部刷新验证用户名
					$.ajax({
						type: "post", //提交方式
						url: "RegisterUserJudgeAction.do", //url:发送请求地址
						data: $("form").serialize(), //待发送 Key/value 参数     //或 data:{"userName":$("#userName").val()}
						dataType: "json", //返回的内容格式
						success: function(data){ //发送成功时回调函数
							if(data != null){
								$("#sUserName").show();
								$("#sUserName").html("此用户名已被注册");
							}else {
								$("#sUserName").hide();
								$("#sUserName").html("");
							}
						}
					}); //ajax结束
				} //else结束
			}); //用户名结束

			//真实姓名
			 $("#realName").blur(function() {
				var realName=$(this).val();
				if(realName.length==0){
					$("#sRealName").show();
					$("#sRealName").html("真实姓名不能为空");
				}else {
					$("#sRealName").hide();
					$("#sRealName").html("");
				}
			 }); //真实姓名结束

			//密码
			 $("#passWord").blur(function() {
				var passWord=$(this).val();
				if(passWord.length==0){
					$("#sPassWord").show();
					$("#sPassWord").html("密码不能为空");
				}
			 }); //密码结束

			//确认密码
			 $("#rePassWord").blur(function() {
				var passWord=$("#passWord").val();
				var rePassWord=$(this).val();
				if(rePassWord != passWord){
					$("#sRePassWord").show();
					$("#sRePassWord").html("两次输入的密码不匹配");
				}
			 }); //确认密码结束

		});

		//-----------------------------------------------------------------------------------
		//表单提交函数
		function mySubmit() {

			//用户名
			var userName=$("#userName").val();
			if(userName.length==0){
				$("#sUserName").show();
				$("#sUserName").html("用户名不能为空");
				return false;
			}else{
				$("#sUserName").hide();
				$("#sUserName").html("");
			}
			//真实姓名
			var realName=$("#realName").val();
			if(realName.length==0){
				$("#sRealName").show();
				$("#sRealName").html("用户名不能为空");
				return false;
			}else{
				$("#sRealName").hide();
				$("#sRealName").html("");
			}

			//密码
			var passWord = $("#passWord").val();
			if (passWord.length == 0) {
				$("#sPassWord").show();
				$("#sPassWord").html("密码不能为空");
				return false;
			}else{
				$("#sPassWord").hide();
				$("#sPassWord").html("");
			}

			//验证码(也可用jQuery方式取验证码文本框内的值)
			if(document.getElementById("verycode").value.length == 0) {
				document.getElementById("verycodeError").innerHTML = "验证码不能为空！";
				return false;
			}else if(document.getElementById("verycode").value != ${sessionScope.authCode}){
				document.getElementById("verycodeError").innerHTML = "验证码错误！";
				return false;
			}

		} //表单提交函数结束

		//-----------------------------------------------------------------------------------
		//验证码刷新
		function refresh(){
			//document.getElementById("authCode").src="GetAuthCode.do?time="+math.random();
			$("#veryCode").attr("src","GetAuthCode.do?time="+Math.random());
		}

	</script>
</head>
<body>

	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<div class="help">
			<a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a
				href="register.jsp">注册</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="#">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>
					欢迎注册易买网&nbsp;&nbsp;&nbsp;&nbsp;<span color="red" size="3px">${registerError}</span>
				</h1>
				<ul class="steps clearfix">
					<li class="current"><em></em>填写注册信息</li>
					<li class="last"><em></em>注册成功</li>
				</ul>
				<form id="regForm" method="post" action="RegisterAction.do" onsubmit="return mySubmit()">
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" name="userName" id="userName" /></td>
							<td><span id="sUserName" class="prompt"></span></td>
						</tr>
						<tr>
							<td class="field">真实姓名：</td>
							<td><input class="text" type="text" name="realName" id="realName" /></td>
							<td><span id="sRealName" class="prompt"></span></td>
						</tr>
						<tr>
							<td class="field">生日：</td>
							<td><input class="text" type="text" name="birthday" maxlength="100" id="Text4" onclick="SelectDate(this,'yyyy-MM-dd')"/></td>
							<td><span id="sBirthday" class="prompt"></span></td>
						</tr>
						<tr>
							<td class="field">性别：</td>
							<td>
								<input type="radio" name="sex" value="T" checked="checked" />男 
								<input type="radio" name="sex" value="F" id="sex" />女
							</td>
							<td><span id="sSex"></span></td>
							
						</tr>
						<tr>
							<td class="field">状态：</td>
							<td>
								<input type="radio" name="status" value="1" checked="checked" />普通用户 
								<input type="radio" name="status" value="2" id="status" />管理员
							</td>
							<td><span id="sstatus"></span></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" name="passWord" id="passWord" /><span></span></td>
							<td><span id="sPassWord" class="prompt"></span></td>
						</tr>
						<tr>
							<td class="field">确认密码：</td>
							<td><input class="text" type="password" name="rePassWord" id="rePassWord" /><span></span></td>
							<td><span id="sRePassWord" class="prompt"></span></td>
						</tr>						
						<tr>
							<td class="field">验证码：</td>
							<td><input id="verycode" class="text verycode" type="text" name="veryCode" value="${sessionScope.authCode}"/><img id="veryCode" src="GetAuthCode.do" sytle="cursor:pointer" />&nbsp<a href="javascript:;" onclick="refresh()">看不清</a></td>
							<td id="verycodeError" class="prompt"></td>
						</tr>
						
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>

</body>
</html>