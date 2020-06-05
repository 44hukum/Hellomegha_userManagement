package com.hellomegha.usermanagement;

import com.hellomegha.databasequeries.InsertRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Dashboard extends HttpServlet{
public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
	HttpSession session=request.getSession();
       
        //saving history
         try {
            Integer userId=(Integer) session.getAttribute("userID");
        (new InsertRecord()).intoUserHistory(userId,"Successfully logged in to the system");
        } catch (SQLException ex) {
         Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    
        try(PrintWriter write=response.getWriter()){
        write.print(session.getAttribute("userID"));
        response.sendRedirect("homepage.jsp");
        }
	
}
}
