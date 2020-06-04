package com.hellomegha.usermanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.hellomegha.databasequeries.DatabaseConnection;
import com.hellomegha.databasequeries.FindUser;
import com.hellomegha.databasequeries.InsertRecord;


public class Signup extends HttpServlet{
	private DatabaseConnection connection=new DatabaseConnection();
	private int frequency =0;
	private static final long serialVersionUID = 109090;
	/**
	 * change in serail value code changes everything
	 */
	

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession userSession=req.getSession();
		
		Connection con=connection.makeConnection();
		try(PrintWriter out=resp.getWriter()){
			
			
		
			String username=req.getParameter("username");	
			String email=req.getParameter("email");
			String phonenumber=req.getParameter("phonenumber");
			String password="helo";
			
			 ResultSet user=(new FindUser()).getUser(username);
			//user authentication
			
			 if(user.next() == false) {
			 
			//user insertion in table UserRegistration and history
			InsertRecord dataInsertion=new InsertRecord();
			//user creation
			boolean createUser=dataInsertion.intoUserRegistration(username, password, email, phonenumber);
			
				if(createUser) {
					FindUser usern=new FindUser();
					ResultSet recentuser=usern.getUser(username); 
					  //create session
					userSession.setAttribute("username",username);
					 userSession.setAttribute("role", "user");
					
					 while(recentuser.next()) {
					userSession.setAttribute("id", recentuser.getInt("userID")); 	 //get the user id						
					dataInsertion.intoUserHistory(recentuser.getInt("userID"),"Created account"); //create and log signup history
				 dataInsertion.intoUserHistory(recentuser.getInt("userID"),"Successfull login"); //create and log login history
				 }
				
					resp.sendRedirect("Dashboard");
				}
			 } 		
				 else { req.setAttribute("signupError", "user Already exist");
				 RequestDispatcher tofirstpage=req.getRequestDispatcher("welcome.jsp");
				 tofirstpage.forward(req, resp); }
				 
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}catch(Exception e) {
			
		}
	
}

}
