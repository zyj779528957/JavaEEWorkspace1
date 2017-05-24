package com.action;


import com.common.AuthCode;
import com.entity.Product;
import com.service.INewsService;
import com.service.IProductCategoryService;
import com.service.IProductService;
import com.service.impl.AppUtil;
import com.service.impl.NewsService;
import com.service.impl.ProductCategoryService;
import com.service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aeyjie on 2017-04-20.
 */
@WebServlet("/IndexAction.do")
public class IndexAction extends HttpServlet {

    /**
     * doPost方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("---IndexAction-doPost方法---"); //调试

        //取页面数据
        //1.得到产品父类别对象集合与产品子类别对象集合
        IProductCategoryService pcs = new ProductCategoryService();
        List listPCParent = pcs.getAllParent();
        List listPCChild = pcs.getAllChild();
        //将得到产品父类别对象集合与产品子类别对象集合放入request
        request.setAttribute("listPCParent", listPCParent);
        request.setAttribute("listPCChild", listPCChild);

        //2.得到产品对象集合
        IProductService ps = new ProductService();
        List listP = ps.getAll();
        //将得到产品对象集合放入request
        request.setAttribute("listP", listP);


        //3.取cookie
        String cUid = "";
        String cUpwd = "";
        String historyPids = null;
        List historyPidsList = new ArrayList(); //浏览过的产品对象集合

        Cookie[] carr = request.getCookies();
        if (carr != null) { //大if开始
            for (Cookie c1 : carr) {
                if (c1.getName().equals("cUid")) { //3.1 得到用户名
                    cUid = c1.getValue();
                    //解密中文
                    cUid = AppUtil.decode(cUid);
                }
                if (c1.getName().equals("cUpwd")) { //3.2 得到密码
                    cUpwd = c1.getValue();
                }
                if (c1.getName().equals("historyPids")) {
                    c1.setMaxAge(-1);
                    historyPids = c1.getValue();
                    System.out.println("-----IndexAction-historyPids:" + historyPids);
                }
            }

            //3.3 得到产品浏览记录
            System.out.println("IndexAction-historyPids:"+historyPids);
            if (historyPids != null) {

                String[] pids = historyPids.split("-");
                List<String> asList = Arrays.asList(pids);
                List<String> pidsList = new LinkedList<String>(asList);

                //3.3.1通过pid得到产品对象，并将得到的产品对象放入list集合
                for (int i = 0; i < pidsList.size(); i++) {
                    int historyPid = Integer.parseInt(pidsList.get(i));
                    Product p1 = ps.getObjById(historyPid);
                    historyPidsList.add(p1);
                }
                //3.3.2 将产品浏览记录的产品对象集合放入request
                request.setAttribute("historyPidsList", historyPidsList);

            }  //小if结束

            //3.4 将cookie值（用户名和密码）放入session
            request.getSession().setAttribute("cUid", cUid);
            request.getSession().setAttribute("cUpwd", cUid);

            //4通过业务层实现类，得到所有新闻对象集合
            INewsService ns = new NewsService();
            List list = ns.getAll();
            //将新闻对象集合放入session
            request.getSession().setAttribute("nList", list);
        } //大if结束


        //5.预先得到验证码的随机数
        String authCode = AuthCode.getAuthCode(); //调用com.common.AuthCode 中的静态方法：getAuthCode()
        request.getSession().setAttribute("authCode", authCode);
        System.out.println("---IndexAction-authCode:" + authCode);


        //转发到index页面
        request.getRequestDispatcher("index.jsp").forward(request, response); //  "/index.jsp"为绝对路径：localhost:8080/index.jsp
    }


    /**
     * doGet方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("---IndexAction-doGet方法---"); //调试
        doPost(request, response);
    }
}
