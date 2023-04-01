package demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.data.UserIO;
import demo.model.User;

public class AddToEmailListServletMVC extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException,IOException{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		
		//get a relative file name
		
		ServletContext sc=getServletContext();
		
		String fullpath= sc.getRealPath("/WEB-INF/EmailList.txt");//Relative Path
		
		//Use Regular Java Classes
		
		User user=new User(firstName,lastName,email);
		UserIO.add(user, fullpath);
		
		
		//Store the User Object in request object
		
		request.setAttribute("bappa", user);
		
		
		//forward request and response objects to jsp page
		String url="/pages/display.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
		
		rd.forward(request, response);
		

	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
}
