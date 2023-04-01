package com.example.listener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.data.ConnectionPool;
import java.util.*;
import com.example.model.*;

public class UserListListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Get the ServletContext
		
		ServletContext sc=event.getServletContext();
		
		//Create A list of Users for Storing user from Database
		List<User> userList=new ArrayList<User>();
		
		//Get All the Users at the Start Using Connection Pool
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn= pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			 ps=conn.prepareStatement("SELECT * FROM registerUser");
			 rs=ps.executeQuery();
			 
			 while(rs.next()) {
				 User user=new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("email")); 
				 userList.add(user);
			 }
			 
			 sc.setAttribute("users", userList);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				pool.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
