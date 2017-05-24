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
@WebServlet("/RegisterUserJudgeAction.do")
public class RegisterUserJudgeAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置ajax的请求与响应的字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        String  uid = request.getParameter("userName");

        IUserService us = new UserService(); //new一个用户业务层对象（多态）

        User u1 = us.ifLogin(uid, null);
        //String jsons = JSON.toJSONString(u1); //将用户对象转换为json格式

        PrintWriter out = response.getWriter();  //从响应中得到打印流
        out.print(u1); //传回jsons数据
        out.flush(); //刷新打印流
        out.close(); //关闭打印流


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
