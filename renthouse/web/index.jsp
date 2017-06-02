<%--
  Created by IntelliJ IDEA.
  User: Aeyjie
  Date: 2017-05-28
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <link rel="stylesheet" href="js/jquery-1.11.1.js">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <style>
      .qn-logo {
        margin-left: 200px;
      }

      /*表单*/
      .form-horizontal {
        padding: 30px;
        margin: 150px 0 0 450px;
        background-color: skyblue;
        width: 600px;
        border: solid 3px yellowgreen;
      }
    </style>
  </head>
  <body>

    <%--青鸟logo--%>
    <div class="qn-logo">
      <img src="images/logo.gif" alt="青鸟logo">
    </div>

    <%--引入bootstrap表单--%>
    <form class="form-horizontal" action="<%=request.getContextPath()%>/loginServlet.do" method="post" >
      <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-10">
          <input type="text"  name="name" class="form-control" id="inputEmail3" placeholder="username" style="width:300px">
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-10">
          <input type="text" name="password" class="form-control" id="inputPassword3" placeholder="password" style="width:300px">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <div class="checkbox">
            <label>
              <input type="checkbox"> 记住密码
            </label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">登 录</button>
        </div>
      </div>
    </form>

  </body>
</html>
