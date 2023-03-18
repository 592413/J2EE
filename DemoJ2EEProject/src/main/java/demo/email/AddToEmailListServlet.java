package demo.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddToEmailListServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
	}

}
