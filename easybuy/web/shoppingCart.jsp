<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aeyjie
  Date: 2017-04-25
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>shoppingCart page</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script src="js/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="scripts/function.js"></script>
    <script>

        //======================================================
        //js函数1：添加一个cookie
        function addcookie(name,value,expireHours){
            var cookieString=name+"="+escape(value);
            //判断是否设置过期时间
            if(expireHours>0){
                var date=new Date();
                date.setTime(date.getTime+expireHours*3600*1000);
                cookieString=cookieString+"; expire="+date.toGMTString();
            }
            document.cookie=cookieString;
        }
        //---------------

        //js函数2：获取指定名称的cookie值
        function getcookie(name){
            var strcookie=document.cookie;
            var arrcookie=strcookie.split("; ");
            for(var i=0;i<arrcookie.length;i++){
                var arr=arrcookie[i].split("=");
                if(arr[0]==name)return arr[1];
            }
            return "";
        }
        //======================================================



        jQuery(function () { //jQuery开始


            /*//获取指定名称的cookie值
            console.log("haha:"+document.cookie)

            var pNum = getcookie("${p1.pid}Num"); //调用js函数2：获取指定名称的cookie值

            if(pNum == null){
                addcookie("${p1.pid}", "1", "3"); //js函数1：添加一个cookie
                console.log(document.cookie) //调试
            }else{
                pNum++;
                $("#number_id_1").val(pNum);
                //addcookie("${p1.pid}Num", pNum, "3"); //js函数1：添加一个cookie
                console.log(document.cookie) //调试
            }*/


            //---------------
            //点击函数1：对购物车内单种商品的数量减1
            $(".minusNum").click(function () {
                var pNum = $(this).prev().children().val();
                if(pNum > 1){
                    pNum--;
                    $(this).prev().children().val(pNum);

                    //addcookie("${p1.pid}Num", pNum, "3"); //js函数1：添加一个cookie
                    // console.log(getcookie("${p1.pid}Num"));
                }
            });

            //---------------
            //点击函数2：对购物车内单种商品的数量加1
            $(".plusNum").click(function () {
                var pNum = $(this).prev().prev().children().val();
                pNum++;
                $(this).prev().prev().children().val(pNum);

                //addcookie("${p1.pid}Num", pNum, "3"); //js函数1：添加一个cookie
                //console.log(getcookie("${p1.pid}Num"));
            });
            //---------------

        }); //jQuery结束

    </script>
</head>
<body><div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" /></div>
    <div class="help"><a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a href="register.html">注册</a></div>
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
<div id="position" class="wrap">
    您现在的位置：<a href="index.html">易买网</a> &gt; 购物车
</div>
<div class="wrap">
    <div id="shopping">
        <h2>${DelProductError}</h2>
        cartList:${cartList}
        <form action="shopping-result.html">
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
                    <th>购买数量</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${cartList}" var="p1">
                    <tr id="product_id_1">
                        <td class="thumb"><img src="${p1.pfilename}" /><a href="product-view.jsp">${p1.pname}</a></td>
                        <td class="price" id="price_id_1">
                            <span>￥${p1.pprice}</span>
                            <input type="hidden" value="99" />
                        </td>
                        <td class="number">
                            <dl>
                                <dt><input id="number_id_1" class="number_id_1" type="text" name="number" value="${p1.psingleamount}"/></dt>
                                <dd id="minusNum" class="minusNum">-</dd>
                                <dd id="plusNum" class="plusNum">+</dd>
                            </dl>
                        </td>
                        <td class="delete"><a href="DelProductAction.do?pid=${p1.pid}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="button"><input type="submit" value="" /></div>
        </form>
    </div>
   <%-- <script type="text/javascript">
        //document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
    </script>--%>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div></body>
</html>
