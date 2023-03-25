package com.download.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.download.data.UserIO;
import com.download.model.User;
import com.download.util.CookieUtil;

public class CheckUserServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		
		String productCode=request.getParameter("productCode");
		
		HttpSession session=request.getSession();
		session.setAttribute("productCode", productCode);
		User user= (User)session.getAttribute("user");
		String url="";
		
		if(user==null) {
			Cookie[]  cookies=request.getCookies();
			String emailAddress=CookieUtil.getCookieValue(cookies, "emailCookie");
			
			if(emailAddress==null || emailAddress.isEmpty()) {
				url="/pages/register.jsp";
			}else {
				ServletContext sc=getServletContext();
				String path =sc.getRealPath("WEB-INF/EmailList.txt");
				user=UserIO.getUser(emailAddress,path);
				session.setAttribute("user", user);
				url="/pages/"+productCode+"_download.jsp";
			}
		}else {
			url="/pages/"+productCode+"_download.jsp";
		}
		
		RequestDispatcher rd= getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		doGet(request,response);
	}

}
