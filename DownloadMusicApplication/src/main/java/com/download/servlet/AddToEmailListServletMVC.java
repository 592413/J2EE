package com.download.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

import com.download.data.UserIO;
import com.download.model.*;



public class AddToEmailListServletMVC extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		
		//get a relative file name
		
		ServletContext sc=getServletContext();
		
		String fullpath= sc.getRealPath("/WEB-INF/EmailList.txt");//Relative Path
		
		
		
		
		
		//Use Regular Java Classes
		
		User user=new User(firstName,lastName,email);
		UserIO.add(user, fullpath);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		
		String productCode=request.getParameter("productCode");
		
		Cookie emailCookie=new Cookie("emailCookie",email);
		emailCookie.setMaxAge(60*60*24*365*2);
		emailCookie.setPath("/");
		response.addCookie(emailCookie);
		
		
		
		//forward request and response objects to jsp page
		String url="/pages/"+productCode+"_download.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
		
		rd.forward(request, response);
		

	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
}
