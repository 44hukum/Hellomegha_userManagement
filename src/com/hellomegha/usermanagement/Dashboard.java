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

import com.hellomegha.databasequeries.FindUser;

public class Dashboard extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	
	if(session.getAttribute("username") !=null) {
	response.sendRedirect("homepage.jsp");
	
	}
	
	else {
		//if the session is deleted then is returned to the welcome page
	response.sendRedirect("welcome.jsp");
				
		
	}
}
}
