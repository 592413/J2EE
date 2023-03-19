package demo.data;

import java.io.*;

import demo.model.User;



public class UserIO {

	
	public static void add(User user,String filepath) throws IOException{
		
		File file=new File(filepath);
		PrintWriter out =new PrintWriter(new FileWriter(file,true));
		out.println(user.getEmail()+ " | " + user.getFirstName() + " | " + user.getLastName()  );
		
		out.close();
	}
}
