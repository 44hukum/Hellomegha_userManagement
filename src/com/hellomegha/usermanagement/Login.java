package com.hellomegha.usermanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hellomegha.databasequeries.FindUser;

public class Login extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1001;
	private FindUser userdetails=new FindUser();
	
 public void service(HttpServletRequest request,HttpServletResponse response) {
	 HttpSession session=request.getSession();
	 //if request contains the reset header call forgetPassword function
	 
 //else
	 //get the login credentials 
	 String username=request.getParameter("username");
	 String password=request.getParameter("password");
	 
	 //validate the user and user role
	 try {
		 ResultSet res=userdetails.getAdmin(username);
		 while(res.next()) { //works for bboth user and non user  run for O(N)  
				if(res.getString("username").equals(username)) {
					if(res.getString("password").equals(password)){
						//create the HttpSession
						session.setAttribute("user", username);
						session.setAttribute("role","admin");
						//register login time
						
						//redirect to dashboard
						//dashboard under construction
					}
				}
			}
		 res.close();
		 
		 ResultSet result=userdetails.getUser(username);
		while(result.next()) { //works for bboth user and non user
			if(result.getString("username").equals(username)) {
				if(result.getString("password").equals(password)){
					//create the HttpSession
					session.setAttribute("user", username);
					session.setAttribute("role","user");
					//register logintime
					//redirect to dashboard
				}
			}
		}
		
	 } catch (SQLException e) {
	
		e.printStackTrace();
	}
	 //create session
	 //register the login time
	 //redirect to the dashboard
 }
 
 //password reset
 public void forgetPassword() {
	 //load the password reset page
	 //get the username 
	 //demand the phonenumber 
	 //get the userDetails using username if user exist ask for phonenumber 
	 //if phonenumber match 
	 //ask user to input the password
	 //save password to the database
	 //redirect the user to login
	 
	 
 }
}
