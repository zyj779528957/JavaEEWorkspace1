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
import java.util.List;
import java.util.Map;

/**
 * Created by Aeyjie on 2017-04-25.
 */
@WebServlet("/ShoppingAction.do")
public class ShoppingAction extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调试
        System.out.println("---ShoppingAction-doPost方法---");

        //1.处理中文乱码
        request.setCharacterEncoding("UTF-8");

        //2.通过pid得到单个产品对象
        String pidStr = request.getParameter("pid");
        String pNumStr = request.getParameter("pNum");
        int pid = Integer.parseInt(pidStr);
        int pNum = Integer.parseInt(pNumStr);

        //3.通过pid得到单个产品对象
        IProductService ps = new ProductService();
        Product p1 = ps.getObjById(pid);
        //将通过pid得到单个产品对象放入request
        request.setAttribute("p1", p1);

        //4.将当前产品对象放入session中的cartList集合
        List cartList = (List)request.getSession().getAttribute("cartList");
        System.out.println("---cartList:"+cartList);

        if(cartList.isEmpty()){
            System.out.println("---if-cartList:"+cartList);
            p1.setPsingleamount(pNum);
            cartList.add(p1);
        }else{
            System.out.println("---else-cartList:"+cartList);
            boolean flag = true;
            for(Object obj : cartList){
                Product p2 = (Product)obj;
                System.out.println(p2.getPid() +"--for-"+ pid);
                if (p2.getPid() == pid) {
                    int amount = p1.getPsingleamount() + pNum;
                    p1.setPsingleamount(amount);
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                p1.setPsingleamount(pNum);
                cartList.add(p1);
            }
        }

        System.out.println("ending");

        //4.转发到
        request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
