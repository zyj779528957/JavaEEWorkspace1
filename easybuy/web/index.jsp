<%--
  Created by IntelliJ IDEA.
  User: Aeyjie
  Date: 2017-04-14
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>易买网-index</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script src="js/jquery-1.11.1.js"></script>
    <%--若联网，则可引入在线jquery文件替代本地jquery文件--%>
    <%-- <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script> --%>
    <script type="text/javascript" src="scripts/function.js"></script>
    <script>

        //定义新闻滚动变量
        var marginTop = 0;
        var stop = false;

        //新闻滚动函数
        function ulscroll() {

            if(stop) return; //控制是否停止滚动

            $("#express").children("li").first().animate({"margin-top":marginTop--},0,function () {
                var $first = $(this);
                //如果第一个子元素移到完全看不见就加到ul的最后然后marginTop清0
                if((-marginTop) > $first.height()){
                    $first.css({"margin-top":0}).appendTo($("#express"));
                    marginTop = 0;
                }
            });
        } //新闻滚动函数结束


        jQuery(function () { //jQuery开始

            //设置定时器,隔时调用ulscroll函数
            var interval = setInterval("ulscroll()",50);
            //鼠标停止上移，移出启动
            $("#express").mouseover(function () {
                stop = true;
            }).mouseout(function () {
                stop = false;
            });

            //左侧商品类别下对应产品的显示与隐藏
            $(".pc-pcChi").mouseenter(function(){
                $(".pc-product").css("display","block");
            }).mouseleave(function () {
                $(".pc-product").css("display","none");
            });

        }); //jQuery结束
    </script>
</head>
<body>

<%--此h1仅作testJson.jsp的测试用--%>
<h1><a href="./testJson.jsp">测试ajax json</a></h1>

<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" /></div>
    <div class="help">
        <span style="color: red;">${loginUser.uid}</span>&nbsp;
        <span>${dateStr}</span>
        <a href="shoppingCart.jsp" class="shopping">购物车</a>
        <a href="login.jsp">登录</a><span style="color:red;">${loginError}</span>
        <a href="register.jsp">注册</a></div>
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
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
           <h2>商品分类</h2>
            <dl>
                <%-- forEach循环输出（商品父类别名》商品子类别名》）--%>
                <c:forEach   var="pcPar" items="${listPCParent}">
                     <dt>${pcPar.pcname}</dt>
                    <%-- forEach循环输出（商品子类别名》）--%>
                     <c:forEach var="pcChi" items="${listPCChild}">
                         <c:if test="${pcChi.pcparentid == pcPar.pcid}">
                             <dd class="pc-pcChi">
                                 <a href="product-list.jsp" class="pc-pcChi-pcname">${pcChi.pcname}</a>
                                 <ul class="pc-product">
                                         <%-- forEach循环输出（商品子类别下的商品名）--%>
                                     <c:forEach items="${listP}" var="p1">
                                         <c:if test="${p1.pcid == pcPar.pcid &&  p1.pchildid == pcChi.pcid}">
                                             <li><a href="ProductAction.do?pid=${p1.pid}">${p1.pname}</a></li>
                                         </c:if>
                                     </c:forEach>
                                 </ul>
                             </dd>
                         </c:if>
                     </c:forEach>
                </c:forEach>
            </dl>
        </div>
        <div class="spacer"></div>
        <div class="last-view">
            <h2>最近浏览</h2>
            <style>
                .clearfix dt img{
                    width: 50px;
                    height:50px;
                }
            </style>
            <dl class="clearfix">
                <%--forEach循环输出（最近浏览的商品 自己在IndexAction控制层限定输出个数）--%>
                <c:forEach items="${historyPidsList}" var="p1">
                    <dt><img src="${p1.pfilename}" /></dt>
                    <dd><a href="ProductAction.do?pid=${p1.pid}">${p1.pname}</a></dd>
                </c:forEach>
            </dl>

        </div>
    </div>
    <div class="main">
        <div class="price-off">
            <h2>今日特价</h2>
            <ul class="product clearfix">
                <%--forEach循环输出（pid<601 即为特价）--%>
                <c:forEach   var="p1" items="${listP}">
                    <c:if test="${p1.pid < 601}">
                        <li>
                            <dl>
                                <dt><a href="ProductAction.do?pid=${p1.pid}" target="_blank"><img src="${p1.pfilename}" /></a></dt>
                                <dd class="title"><a href="product-view.jsp" target="_blank">${p1.pname}</a></dd>
                                <dd class="price">￥ ${p1.pprice}</dd>
                            </dl>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
        <div class="side">
            <div class="news-list">
                <h4>最新公告</h4>
                <ul>
                    <c:forEach items="${nList}" var="n1">
                        <li><a href="news-view.jsp" target="_blank">${n1.ntitle}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="spacer"></div>
            <div class="news-list">
                <h4>新闻动态</h4>
                <ul id="express">
                    <c:forEach items="${nList}" var="n1">
                        <li><a href="news-view.jsp" target="_blank">${n1.ntitle}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="spacer clear"></div>
        <div class="hot">
            <h2>热卖推荐</h2>
            <ul class="product clearfix">
                <%--forEach循环输出（601<=pid<=660 即为热卖）--%>
                <c:forEach   var="p1" items="${listP}">
                    <c:if test="${p1.pid >= 601 && p1.pid < 660}">
                        <li>
                            <dl>
                                <dt><a href="ProductAction.do?pid=${p1.pid}" target="_blank"><img src="${p1.pfilename}" /></a></dt>
                                <dd class="title"><a href="product-view.jsp" target="_blank">${p1.pname}</a></dd>
                                <dd class="price">￥ ${p1.pprice}</dd>
                            </dl>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>

</body>
</html>
