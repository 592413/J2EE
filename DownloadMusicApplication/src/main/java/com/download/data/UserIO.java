package com.download.data;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.download.model.User;





public class UserIO {

	
	public static void add(User user,String filepath) throws IOException{
		
		File file=new File(filepath);
		PrintWriter out =new PrintWriter(new FileWriter(file,true));
		out.println(user.getEmail()+ "|" + user.getFirstName() + "|" + user.getLastName()  );
		
		out.close();
	}

	public static User getUser(String emailAddress, String path) {
		File file = new File(path);
		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Iterator<String> itr =lines.iterator();
		    while (itr.hasNext()) {
		    	String text=itr.next();
		      System.out.println(text);
		    String [] values=text.split("|");
		    System.out.println(values);
		    
		    if(values[0].equalsIgnoreCase(emailAddress)) {
		    	User user= new User(values[1], values[2], values[0]);
		    	return user;
		    }
		    
		  }
		
		return null;
	}
}
