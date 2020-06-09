/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.databasequeries;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wanu
 */
public class ResetPassword extends HttpServlet {
   
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
            //user phonenumber 
            String username=request.getParameter("username");
            String phonenumber=request.getParameter("phonenumber");
            boolean isAvalidUser=false;
            String password =request.getParameter("password");
            
        try {
            ResultSet user=(new FindUser()).getUser(username);
            //if match found accept other
                while(user.next()){
                    if(phonenumber.equals(user.getString("phoneNumber"))){
                          //update database
                         boolean done=(new UpdateRecord()).updatePassword(user.getInt("userID"),password);
                         if(done){
                              //save history
                              (new InsertRecord()).intoUserHistory(user.getInt("userID"), "Password reset Successfull");                             //redirect to login
                              response.sendRedirect("welcome.jsp");
                         }
                    }else{
                                   
                  //else reject all
                    session.setAttribute("ER", "password reset unsuccessFull");
                           response.sendRedirect("resetPassword.jsp");
                    }
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(ResetPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
