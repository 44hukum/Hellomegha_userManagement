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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends HttpServlet{
	
	/**
	 * 
	 */
	
	private FindUser userdetails=new FindUser();
	
 public void doPost(HttpServletRequest request,HttpServletResponse response)
         throws IOException, ServletException {
        	
         System.out.println("hello world");       
 }
 
}
