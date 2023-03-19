package demo.email;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToEmailListServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		//Send Response to browser
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!doctype html> \n"
				+"<html> \n"
				+"<head> \n"
				+"  <title> Test Page</title> \n"
				
				+"<head> \n"
				+"<body> \n"
				+"<h1> Thanks for Joining our Email </h1> \n"
				+"<table> \n"
				+ "<tr> \n"
				+ " <td> Firstname </td> \n"
				+ " <td>"+firstName+"</td> \n"
				+"</tr> \n"
				+ " <td> Lastname </td> \n"
				+ " <td>"+lastName+"</td> \n"
				+"</tr> \n"
				+ " <td> email </td> \n"
				+ " <td>"+email+"</td> \n"
				+"</tr> \n"
				+"</table>\n "
				+"</body> \n"
				+"</html> \n");
		
		out.close();
		
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}

}
