/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.usermanagement;

import com.hellomegha.databasequeries.DeleteRecord;
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

/**
 *
 * @author wanu
 */
public class DeleteProfile extends HttpServlet {
  private DeleteRecord deleteU=new DeleteRecord(); //to delete user
    /**
     * 
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
        if(session.getAttribute("userID")!=null){
         Integer user=(Integer)(session.getAttribute("userID"));
                if(deleteU.deleteUser(user)){ 
             try {
                session.removeAttribute("username");
                session.removeAttribute("userID");
                session.removeAttribute("role");
                
                response.sendRedirect("welcome.jsp");
                
             } catch (Exception ex) {
                 Logger.getLogger(DeleteUser.class.getName()).log(Level.INFO, "user deleted", ex);
             }
        } //end if  
                
         System.out.println(user.getClass().getName());
        }//end if
    }
}