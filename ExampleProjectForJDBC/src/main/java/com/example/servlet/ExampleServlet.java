package com.example.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.User;

public class ExampleServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		
		//Use Regular Java Classes
		User user=new User(firstName,lastName,email);
		
		//Create Database Connection & insert Data
		Connection conn=null;
		Statement statement=null;
		try {
			String dbUrl="jdbc:mysql://localhost:3306/myc";
			String userName="root";
			String password="root";
			//Load the Driver class
			Class.forName("com.mysql.jdbc.Driver");
			
			//Coonection object required to communicate with Database
			conn=DriverManager.getConnection(dbUrl, userName, password);
			
			
			statement=conn.createStatement();
			
			//Executing Insert Statement
			String query= "INSERT INTO registerUser (firstName,lastName,email) values('"+firstName+"' ,'"+lastName+"' , '"+email+"')";
			int rowCount=statement.executeUpdate(query);
			
			//Execute Select Statement & Get the resultset from Database
			ResultSet result=statement.executeQuery("SELECT * FROM registerUser");
			
			//Iterate over ResultSet
			while(result.next()) {
				String fName=result.getString("firstName");
				String lName=result.getString("lastName");
				String emailId=result.getString("email");
				
				System.out.println("FirstName: "+fName+" LastName: "+lName+" email: "+emailId);
				
			}
			
			result.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//closing the conn and statement
			
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Store the User Object in request object
		
		request.setAttribute("finalUser", user);
		

		//forward request and response objects to jsp page
		String url="/pages/display.jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
		
		rd.forward(request, response);
				
	
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		
		doPost(request,response);
		
	}

}
