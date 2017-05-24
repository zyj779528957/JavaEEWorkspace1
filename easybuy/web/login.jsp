<%--
  Created by IntelliJ IDEA.
  User: Aeyjie
  Date: 2017-04-14
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/login-register.css">
    <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="scripts/function.js"></script>
    <script type="text/javascript">
        jQuery(function () { //jQuery开始
            //用户名
            $("#userName").blur(function() {
                var userName=$(this).val();
                if(userName.length==0){
                    $("#sUserName").show();
                    $("#sUserName").html("用户名不能为空");
                }else{
                    $("#sUserName").hide();
                    $("#sUserName").html("");
                }
            });

            //密码
            $("#passWord").blur(function() {

                var passWord = $(this).val();
                if (passWord.length == 0) {
                    $("#sPassWord").show();
                    $("#sPassWord").html("密码不能为空</font");
                }else{
                    $("#sPassWord").hide();
                    $("#sPassWord").html("");
                }
            });


        }); //jQuery结束


        //-----------------------------------------------------------------------------------

       /* $("form").submit(function(){

        })*/

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


            //ajax局部验证用户名与密码

            var flag = 1; ////第1步：标识

            $.ajax({  //第2步
                type: "post", //提交方式
                url: "LoginUserJudgeAction.do", //url:发送请求地址
                data: $("form").serialize(), //待发送 Key/value 参数
                dataType: "json", //返回的内容格式
                async: false, //第3步：必须将 ajax的async的属性设为false(即设为同步模式)，不然此 $.ajax 会在本mySubmit函数的最后执行
                success: function(data){ //发送成功时回调函数
                    if(data == null){
                        flag = 2;
                        $("#loginPrompt").html("用户名或密码错误！");
                    }
                }
            }); //ajax结束


            if(flag == 2){ //第4步：必须将 ajax的async的属性设为false(即设为同步)，不然此if会在 $.ajax 之前执行
                return false;
            }

        } //表单提交函数结束


        //-----------------------------------------------------------------------------------
        //验证码刷新函数
        function refresh(){
            //document.getElementById("authCode").src="GetAuthCode.do?time="+math.random();
            $("#veryCode").attr("src","GetAuthCode.do?time="+Math.random());
            console.log(${sessionScope.authCode});
        }
    </script>

</head>
<body>

    <div id="header" class="wrap">
        <div id="logo">
            <img src="images/logo.gif" />
        </div>
        <div class="help">
            <a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a>
        </div>
        <div class="navbar">
            <ul class="clearfix">
                <li class="current"><a href="IndexAction.do">首页</a></li>
                <li><a href="#">图书</a></li>
                <li><a href="#">百货</a></li>
                <li><a href="#">品牌</a></li>
                <li><a href="#">促销</a></li>
            </ul>
        </div>
    </div>
    <div>cname:${cUid}<br/>cpwd:${cUpwd}</div>
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
                    欢迎回到易买网&nbsp;&nbsp;&nbsp;&nbsp;<span id="loginPrompt" class="prompt"></span>
                </h1>
                <form id="loginForm" method="post" action="LoginAction.do" onsubmit="return mySubmit()">
                    <table>
                        <tr>
                            <td class="field">用户名：</td>
                            <td><input class="text" type="text" name="uid" value="${cUid}" id="userName" ></td>
                            <td><span id="sUserName" class="prompt"></span></td>
                        </tr>
                        <tr>
                            <td class="field">登录密码：</td>
                            <td><input class="text" type="password"  name="upwd" value="${cUpwd}" id="passWord" id="passWord" /></td>
                            <td><span id="sPassWord" class="prompt"></span></td>
                        </tr>

                        <tr>

                            <td class="field">验证码：</td>
                            <td><input id="verycode" class="text verycode" type="text" name="veryCode" value="${sessionScope.authCode}"/><img id="veryCode" src="GetAuthCode.do" sytle="cursor:pointer" />&nbsp<a href="javascript:;" onclick="refresh()">看不清</a></td>
                            <td id="verycodeError" class="prompt"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><label class="ui-green"><input type="submit" id="tijiao" name="submit" value="立即登录" /></label>&nbsp<input type="checkbox" name="times" value="1" />&nbsp保存密码</td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <div id="footer">
        Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
    </div>

</body>
</html>
