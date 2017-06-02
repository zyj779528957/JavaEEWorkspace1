<%--
  Created by IntelliJ IDEA.
  User: Aeyjie
  Date: 2017-05-28
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>青鸟租房后台</title>
    <link rel="stylesheet" href="../js/jquery-1.11.1.js">
    <link rel="stylesheet" href="../bootstrap/css/bootstrap.css">
    <%--<script src="../bootstrap/js/bootstrap.js"></script>--%>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .qn {
            width:1100px;
            margin: 0 auto;
            background-color: pink;
        }
        /*头部*/
        .qn-header {
            border: 3px solid red;
            padding: 6px;
            overflow: hidden;
        }
        .qn-header ul {
            list-style: none;
        }
        .qn-header ul li {
            float: left;
            margin-right: 40px;
            background-color: yellow;
        }
        .qn-header ul li p {
            margin: 0;
        }
        .qn-header ul li select {
            width: 100px;
        }
        /*中间内容*/
        .qn-content  {
            padding: 20px;
            vertical-align: middle;
            background-color: green;
            overflow: hidden;
        }

        .qn-content .content div {
            line-height: 80px;
            float: left;
            background-color: lightgoldenrodyellow;
        }
        .qn-content .content .ct-type {
            margin: 0 60px 0 240px;
        }

        .qn-content .content .ct-imginfo .ct-imginfo-img,
        .qn-content .content .ct-imginfo .ct-imginfo-info {
            float: left;
        }
        .qn-content .content .ct-imginfo .ct-imginfo-img{
            margin-right: 20px;
       }
      /* .qn-content .content .ct-imginfo .ct-imginfo-info {

       }*/


        /*底部*/
        .qn-footer {
            background-color: deepskyblue;
        }
    </style>

</head>
<body>
    <div class="qn">
        <div class="qn-logo">
            <img src="../images/logo.gif" alt="青鸟logo">
        </div>
        <div class="qn-header">
            <ul>
                <li class="h-topic">
                    <p>房屋信息</p>
                    标题：<input type="text" name="topic" id=""> <button>搜索房屋</button>
                </li>
                <li class="h-price">
                    <p>价格</p>
                    <select name="" id="hs_price" class="hs-price">
                        <option value="">价格不限</option>
                        <option value="">1-200</option>
                        <option value="">201-400</option>
                        <option value="">401-400</option>
                    </select>

                </li>
                <li class="h-district">
                    <p>区域</p>
                    <select name="district" id="hs_district" class="hs-district">
                        <option value="">不限</option>
                        <option value="">雨花区</option>
                        <option value="">芙蓉区</option>
                    </select>
                </li>
                <li class="h-street">
                    <P>街道</P>
                    <select name="street" id="hs-street" class="sh-street">
                        <option value="">不限</option>
                        <option value="">劳动路</option>
                        <option value="">解放路</option>
                    </select>
                </li>
                <li class="h-type">
                    <P>房型</P>
                    <select name="type" id="hs_type" class="hs-type">
                        <option value="">不限</option>
                        <option value="">一室一厅</option>
                        <option value="">二室一厅</option>
                        <option value="">三室一厅</option>
                    </select>
                </li>
                <li class="h-area">
                    <P>面积</P>
                    <select name="area" id="hs_area" class="hs-area">
                        <option value="">不限</option>
                        <option value="">1-100平米</option>
                        <option value="">100平米以上</option>
                    </select>
                </li>
            </ul>

        </div>
        <div class="qn-content">
            <div id="content" class="content">
                <div class="ct-imginfo">
                    <div class="ct-imginfo-img">
                        <img src="../images/thumb_house.gif" alt="房屋图片" >
                    </div>
                    <dl class="ct-imginfo-info">
                        <dt>大房子</dt>
                        <dd>雨花区解放路，120平米</dd>
                        <dd>联系方式：189</dd>
                    </dl>
                </div>
                <div class="ct-type">一室一厅</div>
                <div class="ct-price">500.00</div>
            </div>
        </div>
        <div class="qn-footer">
            footer
        </div>
    </div>

</body>
</html>
