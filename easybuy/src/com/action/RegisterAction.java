package com.action;

import com.entity.User;
import com.service.IUserService;
import com.service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Aeyjie on 2017-04-20.
 */
@WebServlet("/RegisterAction.do")
public class RegisterAction extends HttpServlet {

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

        //读取表单name属性信息
        request.setCharacterEncoding("utf-8"); //对请求数据进行字符编码（即设置字符集）
        //request内置对象得到浏览器表单中键入的用户名和密码
        String uid=request.getParameter("userName");
        String uname=request.getParameter("realName");
        String ubirthday=request.getParameter("birthday"); //生日：String类型
        String usex=request.getParameter("sex");
        Integer ustatus=Integer.parseInt(request.getParameter("status"));
        String upassword=request.getParameter("passWord");

        //生日：字符串转换成日期
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = new java.sql.Date(sdf2.parse(ubirthday).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User u1 = new User();
        u1.setUid(uid);
        u1.setUname(uname);
        u1.setUbirthday(date); //生日:Date类型
        u1.setUsex(usex);
        u1.setUstatus(ustatus);
        u1.setUpwd(upassword);

        //把用户信息放session
        request.getSession().setAttribute("loginUser",u1); //将含有uid存储到session会话中

        IUserService us = new UserService(); //new一个用户业务层对象（多态）

        //开始向数据库注册用户（即新增用户）
        if(us.register(u1) > 0) { //注册成功
            if(uid.equals("admin") || u1.getUstatus() == 2) {
                response.sendRedirect(request.getContextPath()+"/ManagerSys/admin.jsp");	//为管理员：重定向（跳转到主页，但不传送本页信息）
            }else {
                request.getRequestDispatcher("IndexAction.do").forward(request, response); //为普通用户：转发到IndexAction.do
            }
        }else{ //注册失败
            request.setAttribute("registerError", "注册失败！");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }


    }

    /**
     * doGet方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
