package com.action;

import com.entity.Product;
import com.service.IProductService;
import com.service.impl.AppUtil;
import com.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by Aeyjie on 2017-04-25.
 */
@WebServlet("/ProductAction.do")
public class ProductAction extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调试
        System.out.println("---ProductAction-doPost方法---");

        //1.处理中文乱码
        request.setCharacterEncoding("UTF-8");

        //2.通过pid得到单个产品对象
        String pidStr = request.getParameter("pid");
        int pid = Integer.parseInt(pidStr);

        IProductService ps = new ProductService();
        Product p1 = ps.getObjById(pid);
        //将通过pid得到单个产品对象放入request
        request.setAttribute("p1", p1);


        //3 判断当前historyPids是否已存在于cookie中,并用cookie记录浏览过的产品ID
        Cookie[] carr = request.getCookies();
        String historyPids = "";  //浏览过的产品ID

        LinkedList<String> pidsList = null;
        List<String> asList = null;
        Cookie c1 = null; //声明产品浏览记录：historyPids
        int flag = 1; //标识是否new了Cookie

        if (carr != null) { //大if开始
            for (Cookie cs : carr) {

                //3.1 当historyPids已存在于cookie中时
                if (cs.getName().equals("historyPids")) {

                    String[] pids = cs.getValue().split("-");
                    asList = Arrays.asList(pids);
                    pidsList = new LinkedList<String>(asList);

                    if(pidsList.contains(pidStr)){
                        pidsList.remove(pidStr);
                    }
                    pidsList.addFirst(pidStr);

                    if(pidsList == null || pidsList.isEmpty()){
                        historyPids = pidStr;
                    }else{

                        //3.1.1 用cookie记录浏览过的产品ID
                        for (int i = 0; i < pidsList.size(); i++) {
                            if (i < pidsList.size() - 1) {
                                String a = pidsList.get(i) + "-";
                                historyPids = historyPids + a;
                            }else {
                                historyPids = historyPids + pidsList.get(i);
                            }
                        }

                        c1 = new Cookie("historyPids", historyPids);
                        response.addCookie(c1); //将cookie存入response

                        flag = 2;  //标识此处已new了一个Cookie
                    }

                    break; //跳出大for循环
                }

            } //大for循环结束

        }

        //3.2 当historyPids还不存在于cookie中时
        if(flag == 1){
            c1 = new Cookie("historyPids", pidStr); // 3.2.1 用cookie记录浏览过的产品ID
            response.addCookie(c1); //将cookie存入response

        }

        //4 设置new Cookie("historyPids", pidStr)的有效时间：5分钟
        c1.setMaxAge(5*60);
        System.out.println("historyPids:"+historyPids); //调试

        //5.new一个cartList集合：作存放购物车，存放产品对象
        if (request.getSession().getAttribute("cartList") == null) {
            List cartList = new ArrayList();
            request.getSession().setAttribute("cartList", cartList); //将cartList集合放入session
        }


        //6.new一个HashMap集合：存放产品对象的数量
        /*if (request.getSession().getAttribute("pNumHM") == null) {
            Map<String,Object> pNumHM = new HashMap<String,Object>();
            request.getSession().setAttribute("pNumHM", pNumHM); //将cartList集合放入session
        }*/


        //7.转发到
        request.getRequestDispatcher("product-view.jsp").forward(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
