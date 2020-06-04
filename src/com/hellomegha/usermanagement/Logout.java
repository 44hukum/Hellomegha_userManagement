package com.hellomegha.usermanagement;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hellomegha.databasequeries.InsertRecord;

public class Logout extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1089;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		if(session.getAttribute("id")==null) {
			ResultSet res=(ResultSet) session.getAttribute("data");
			//saving logout history
			try {
				if(session.getAttribute("role").equals("admin")) {
					(new InsertRecord()).intoAdminHistory(res.getInt("adminID"),"Successfully logged out of the system");
				}
				else if(session.getAttribute("role").equals("user")) {
					(new InsertRecord()).intoUserHistory(res.getInt("userID"),"Successfully logged out of the system");
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			session.removeAttribute("data");
			session.removeAttribute("firstname");
			session.removeAttribute("lastname");
			session.removeAttribute("email");
			session.removeAttribute("phonenumber");
			session.removeAttribute("spcialSite");
			session.removeAttribute("github");
			session.removeAttribute("status");
			session.removeAttribute("profilepic");
		}
		else {
	
			try {
				(new InsertRecord()).intoUserHistory((Integer)session.getAttribute("id"),"Successfully logged out of the system");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		//deleting all the session
		session.removeAttribute("username");
		session.removeAttribute("role");
		System.out.println(session.getAttribute("username"));
	//logging out of the system0
		response.sendRedirect("welcome.jsp");
		
	}
}
