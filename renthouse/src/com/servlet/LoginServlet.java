package com.servlet;

import com.domain.Users;
import com.service.UsersService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Aeyjie on 2017-05-29.
 */
@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("-----LoginServlet-----");

        request.setCharacterEncoding("utf-8");

        // 封装数据：需导入commons-BeanUtils 与 commons-logging 两个jar包
        //sMap<String, String[]> map = request.getParameterMap();

        Users u = new Users();

        u.setName(request.getParameter("name"));
        u.setPassword(request.getParameter("password"));

        //new一个业务层用户对象
        UsersService us = new UsersService();
        Users u1 = us.ifLogin(u); //登录判断


       /* try {
            // 封装数据
            BeanUtils.populate(u, map);

            //new一个业务层用户对象
            UsersService us = new UsersService();
            Users u1 = us.ifLogin(u); //登录判断

            System.out.println("------哈哈----:"+u1);
            System.out.println("----------:"+u1);


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/

        System.out.println("------哈哈----");
        System.out.println("----------:"+u1);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
