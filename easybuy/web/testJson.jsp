<%--
  Created by IntelliJ IDEA.
  User: Aeyjie
  Date: 2017-04-22
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.11.1.js"></script>
    <script>

        jQuery(function () { //jQuery开始

            //点击函数1
            $("[value='one']").click(function () {

                var node = $("div");

                //jQuery-ajax: post方式
               /* $.post(
                    "TestJsonAction.do",   //url:发送请求地址
                    $("form").serialize(),   //待发送 Key/value 参数
                    function(data){  //发送成功时回调函数
                        var ss ="";
                        ss += "姓名:"+data.uname+"<br/>";
                        ss += "性别:"+data.usex+"<br/>";
                        node.html(ss);
                    }, "json" //返回内容格式 json
                ) //ajax结束 */

                //jQuery-ajax: ajax方式
                $.ajax({
                    type: "POST", //提交方式
                    url: "TestJsonAction.do", //url:发送请求地址
                    data: $("form").serialize(), //待发送 Key/value 参数
                    dataType: "json", //返回的内容格式
                    success: function(data){ //发送成功时回调函数
                        var ss ="";
                        ss += "姓名:"+data.uname+"<br/>";
                        ss += "性别:"+data.usex+"<br/>";
                        node.html(ss);
                        alert(1)
                    }
                }); //ajax结束

            }); //点击函数1结束


            //点击函数2
            $("[value='list']").click(function () {

                var node = $("div");

                //jQuery-ajax：ajax方式
                $.post(
                    "TestJsonAction.do",   //url:发送请求地址
                    $("form").serialize(),   //待发送 Key/value 参数
                    function(data){  //发送成功时回调函数
                        var ss ="";
                        $.each(data, function (i,v) {

                            ss += "姓名:"+i+"---"+v.uname+"&nbsp"
                            ss += "性别:"+v.usex+"<br/>"
                        });
                        node.html(ss);
                    }, "json"   //返回内容格式 json
                ); //ajax-post结束结束

            }); //点击函数2结束


        }); //jQuery结束
    </script>
</head>
<body>
    <form action="javascript:void(0);" method="post">
        <p><input type="radio" name="btype" value="one" id="">&nbsp; 单个对象</p>
        <p><input type="radio" name="btype" value="list" id="">&nbsp; 集合对象</p>
        <p><input type="radio" name="btype" value="multi" id="">&nbsp; 复杂对象</p>
    </form>

    <div style="font-size: 24px; color: yellowgreen;">
        此处放ajax-json得到的数据
    </div>


</body>
</html>
