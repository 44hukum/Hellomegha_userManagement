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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
	 public void doPost(HttpServletRequest request,HttpServletResponse response)
         throws IOException, ServletException {
             
            
             HttpSession session=request.getSession();
             try(PrintWriter out=response.getWriter()){
                 //take the password and username
             String username=request.getParameter("username");
             String password=request.getParameter("password");
             
                 try {
                     //1.
                     ResultSet isAdmin=(new FindUser()).getAdmin(username); //check and validate admin admin                    
                              while(isAdmin.next()){
                              if(isAdmin.getString("password").equals(password)){
                                  session.setAttribute("username", username);
                                  session.setAttribute("role", "admin");
                                  session.setAttribute("userID",isAdmin.getInt("adminId"));
                                    Integer adminId=(Integer) session.getAttribute("userID");
              (new InsertRecord()).intoAdminHistory(adminId,"Successfully logged in to the system");
                                  response.sendRedirect("Dashboard");
                                  }              
                              }
                           
                              
                         //2.                   //for user
                         ResultSet isUser=(new FindUser()).getUser(username);
                          while(isUser.next()){
                            if(isUser.getString("password").equals(password)){
                               session.setAttribute("username", username);
                                  session.setAttribute("role", "user");
                                  session.setAttribute("userID",isUser.getInt("userId"));
                                    Integer userId=(Integer) session.getAttribute("userID");
        (new InsertRecord()).intoUserHistory(userId,"Successfully logged in to the system");
                                  response.sendRedirect("Dashboard");
                              }
                            }               
                          
                          //3.
                          session.setAttribute("loginError","Wrong credential");
                          response.sendRedirect("welcome.jsp");
                     } catch (SQLException ex) {
                     Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                 }catch(NullPointerException e){}
                 catch(Exception e){}
             }
            }
         
       
}
