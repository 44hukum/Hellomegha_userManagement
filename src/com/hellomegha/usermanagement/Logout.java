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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logout extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1089;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                HttpSession session=request.getSession(); 
                Integer userId=(Integer) session.getAttribute("userID");
               //for user
                if(session.getAttribute("role") =="user"){
                (new InsertRecord()).intoUserHistory(userId,"Successfully logged out of the system");
               
                }
                //for admin
                if(session.getAttribute("role") =="admin"){
                (new InsertRecord()).intoAdminHistory(userId,"Successfully logged out of the system");
               
                }
                //save history
                
                session.removeAttribute("username");
                session.removeAttribute("userID");
                session.removeAttribute("role");
                response.sendRedirect("welcome.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(Logout.class.getName()).log(Level.SEVERE, null, ex);
            }
		
	}
}
