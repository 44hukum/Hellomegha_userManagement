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

public class Dashboard extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	
	
	if(session.getAttribute("username") !=null) {
		 System.out.println("from insidefdsa");
		RequestDispatcher toDashboard=request.getRequestDispatcher("homepage.jsp");
		toDashboard.forward(request, response);
		/*
		 * 
		 */
	
		System.out.println(session.getAttribute("data"));
		System.out.println(session.getAttribute("role"));

		
		/*
	 * session.removeAttribute("username"); session.removeAttribute("role");
	 */
		
		
		
	}
	else {
		//if the session is deleted then is returned to the welcome page
	response.sendRedirect("welcome.jsp");
				
		
	}
}
}
