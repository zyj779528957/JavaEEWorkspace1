package com.action;

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.service.IUserService;
import com.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Aeyjie on 2017-04-30.
 */
@WebServlet("/LoginUserJudgeAction.do")
public class LoginUserJudgeAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置ajax的请求与响应的字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        //通过request得到文本框中键入的uname与upwd
        String uid = request.getParameter("uid");
        String upwd = request.getParameter("upwd");


        //new一个业务层实现类用户对象
        IUserService us = new UserService();
        //调用业务层实现类的：登录方法
        User u1 = us.ifLogin(uid, upwd);

        String jsons = JSON.toJSONString(u1); //将用户对象转换为json格式

        PrintWriter out = response.getWriter();  //从响应中得到打印流
        out.print(jsons); //传回jsons数据
        out.flush(); //刷新打印流
        out.close(); //关闭打印流
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
