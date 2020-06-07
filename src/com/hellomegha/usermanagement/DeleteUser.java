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

/**
 *
 * @author wanu
 */
public class DeleteUser extends HttpServlet {
        private DeleteRecord deleteU=new DeleteRecord();

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
        if(request.getParameter("deleteUser") !=null){
         Integer user=Integer.parseInt((request.getParameter("deleteUser")));
                if(deleteU.deleteUser(user)){
             try {
                 (new InsertRecord()).intoUserHistory(user,"Account deleted by Admin"); //recorded if the account is deleted
                 response.sendRedirect("Dashboard");
                
             } catch (SQLException ex) {
                 Logger.getLogger(DeleteUser.class.getName()).log(Level.SEVERE, null, ex);
             }
        } //end if  
                
         System.out.println(user.getClass().getName());
        }//end if
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "user Deletion servlet";
    }// </editor-fold>

}
