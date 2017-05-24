package com.action;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.AuthCode;





/**
 * Servlet implementation class GetAuthCode
 */
@WebServlet("/GetAuthCode.do")
public class GetAuthCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAuthCode() {
        super();
    }




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*String authCode=AuthCode.getAuthCode();
		request.getSession().setAttribute("authCode", authCode);*/

		String authCode = "";

		if(request.getParameter("time") == null){
			authCode = request.getSession().getAttribute("authCode").toString();
			System.out.println("GetAuthCode-if-authCode:"+authCode);
		}else{
			authCode= AuthCode.getAuthCode(); //调用com.common.AuthCode 中的静态方法：getAuthCode()
			request.getSession().setAttribute("authCode", authCode);
			System.out.println("GetAuthCode-else-authCode:"+authCode);
		}

		System.out.println("---GetAuthCode-authCode:"+authCode);

		ImageIO.write(AuthCode.getAuthImg(authCode),"JPEG", response.getOutputStream());

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
