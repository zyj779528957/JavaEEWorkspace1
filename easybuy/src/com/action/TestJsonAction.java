package com.action;

import com.alibaba.fastjson.JSON;
import com.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aeyjie on 2017-04-22.
 */
@WebServlet("/TestJsonAction.do")
public class TestJsonAction extends HttpServlet {


    /**
     * 得到单个对象并转换为json格式
     */
    public String oneObj(){
        User u1 = new User("1","小明","admin","男");

        String jsons = JSON.toJSONString(u1);

        System.out.println("TestJason-oneObj: "+jsons);

        return jsons;
    }

    /**
     * 得到多个对象的list集合并转换为json格式
     */
    public String listObj(){

        User u1 = new User("1","小明","admin","男");
        User u2 = new User("2","小李","admin","男");
        User u3 = new User("3","小红","admin","女");

        List<User> list = new ArrayList<User>();

        list.add(u1);
        list.add(u2);
        list.add(u3);

        String jsons = JSON.toJSONString(list);
        System.out.println("TestJason-listObj: "+jsons);

        return jsons;
    }


    /**
     * doPost
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //使用ajax时,请求和响应都要处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String btype = request.getParameter("btype");
        System.out.println("---btype: "+btype); //调试

        String jsons = "";

        if("one".equals(btype)){
            jsons = oneObj();
        }else if("list".equals(btype)){
            jsons = listObj();
        }


        PrintWriter out = response.getWriter(); //从响应中得到打印流
        out.print(jsons); //传回jsons

        out.flush(); //刷新打印流
        out.close(); //关闭打印流

    }

    /**
     * doGet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
