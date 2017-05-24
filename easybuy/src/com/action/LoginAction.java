package com.action;

import com.entity.User;
import com.service.IUserService;
import com.service.impl.AppUtil;
import com.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aeyjie on 2017-04-14.
 */
@WebServlet("/LoginAction.do")
public class LoginAction extends HttpServlet {

    /**
     * doPost方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调试
        System.out.println("---loginAction-doPost方法---");

        //把当前系统日期放入session
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = sdf.format(new Date());
        request.setAttribute("dateStr",dateStr);

        //处理中文乱码
        request.setCharacterEncoding("UTF-8");

        //通过request得到文本框中键入的uname与upwd
        String uid = request.getParameter("uid");
        String upwd = request.getParameter("upwd");

        //new一个业务层实现类用户对象
        IUserService us = new UserService();
        //调用业务层实现类的：登录方法
        User u1 = us.ifLogin(uid, upwd);




        //注：一般：目录不同用重定向，目录相同用转发
        if(u1 != null){ //登录成功

            //写入cookie
            String times = request.getParameter("times");
            System.out.println("----times:"+times);
            if (times != null) {
                int time = Integer.parseInt(times);

                //加密中文
                uid = AppUtil.encode(uid);

                Cookie c1 = new Cookie("cUid", uid);
                c1.setMaxAge(time * 3600);
                Cookie c2 = new Cookie("cUpwd", upwd);

                //将cookie存入response
                response.addCookie(c1);
                response.addCookie(c2);
            }

            //把用户信息放入session
            request.getSession().setAttribute("loginUser",u1); //将含有uid存储到session会话中

            if (u1.getUid().equals("admin") || u1.getUstatus() == 2) {
                request.getRequestDispatcher("ManagerSys/admin.jsp").forward(request, response); //  "/index.jsp"为绝对路径：localhost:8080/index.jsp
            }else {
                //自动跳转：重定向(多用于不同目录，不同业务)
                request.getRequestDispatcher("IndexAction.do").forward(request, response); //  "/index.jsp"为绝对路径：localhost:8080/index.jsp
                //response.sendRedirect("index.jsp"); //转发
            }

        } //大登录成功if结束

    } //doPost结束

    /**
     * doGet方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("---loginAction-doGet方法---"); //调试
        doPost(request, response); //调用doPost方法

    }


}
