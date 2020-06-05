package com.hellomegha.usermanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hellomegha.databasequeries.FindUser;
import com.hellomegha.databasequeries.InsertRecord;

public class Login extends HttpServlet{
	 String[] uri= {"0","0"};
	/**
	 * 
	 */
	private static final long serialVersionUID = 1001;
	private FindUser userdetails=new FindUser();
	
 public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	
 }
 
 //password reset
 public void forgetPassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
	 //load the password reset page
	 //get the username 
	 //demand the phonenumber 
	 //get the userDetails using username if user exist ask for phonenumber 
	 //if phonenumber match 
	 //ask user to input the password
	 //save password to the database
	 //redirect the user to login
	 try(PrintWriter out=response.getWriter()){
		 out.println("reset success");
	 }
	 
 }
 
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
	 //load the password reset page
	 //get the username 
	 //demand the phonenumber 
	 //get the userDetails using username if user exist ask for phonenumber 
	 //if phonenumber match 
	 //ask user to input the password
	 //save password to the database
	 //redirect the user to login
	response.sendError(HttpServletResponse.SC_NOT_FOUND);
	 
 }
 
}
