package com.hellomegha.usermanagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hellomegha.databasequeries.DatabaseConnection;


public class Signup extends HttpServlet{
	private DatabaseConnection connection=new DatabaseConnection();
	private static final long serialVersionUID = 109090;
	/**
	 * change in source code changes everything
	 */
	

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession userSession=req.getSession();
		Connection con=connection.makeConnection();
		try(PrintWriter out=resp.getWriter()){
			
			//user authentication
			//user validation
			//user creation
			String username=req.getParameter("username");	
			String email=req.getParameter("email");
			//String password=req.getParameter("password");
			String phonenumber=req.getParameter("phonenumber");
			//Sql Statement
			String sql="insert into userRegistration(username,email,phoneNumber) values(?,?,?)";
			
			
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setString(3, phonenumber);
			
			boolean stat=statement.execute();
			
			if(stat == false) {
			
			}
					
				
				if(con !=null) {
					con.close();
				}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
}

}
