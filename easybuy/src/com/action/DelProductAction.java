package com.action;

import com.entity.Product;
import com.service.IProductService;
import com.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aeyjie on 2017-04-25.
 */
@WebServlet("/DelProductAction.do")
public class DelProductAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调试
        System.out.println("---DelProductAction-doPost方法---");

        //1.处理中文乱码
        request.setCharacterEncoding("UTF-8");

        //2.通过pid得到单个产品对象
        String pidStr = request.getParameter("pid");
        int pid = Integer.parseInt(pidStr);

        //3.通过pid删除单个产品对象
        IProductService ps = new ProductService();
        int count = ps.DelObjById(pid);

        //4.转发到
        if(count > 0){
            request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
        }else{
            request.setAttribute("DelProductError" ,"删除单个产品失败！");
            request.getRequestDispatcher("shopping.jsp.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
