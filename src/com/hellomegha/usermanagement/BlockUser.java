/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.usermanagement;

import com.hellomegha.databasequeries.InsertRecord;
import com.hellomegha.databasequeries.UserBlock;
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
public class BlockUser extends HttpServlet {
    private   UserBlock block=new UserBlock();
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
     if(request.getParameter("blockUser")!=null){
           Integer user=Integer.parseInt((request.getParameter("blockUser")));
            if( block.blockUser(user)){
               try {
                   (new InsertRecord()).intoUserHistory(user,"Account blocked by Admin"); //recorded if the account is deleted
                   response.sendRedirect("Dashboard");
               } catch (SQLException ex) {
                   Logger.getLogger(BlockUser.class.getName()).log(Level.SEVERE, null, ex);
               }
                     }else{
           
         System.out.println("block user"+request.getParameter("blockUser"));
     }
     }else{
     if(request.getParameter("unblockUser")!=null){
            Integer user=Integer.parseInt((request.getParameter("unblockUser")));
            if( block.unblockUser(user)){
               try {
                   (new InsertRecord()).intoUserHistory(user,"Account unblocked by Admin"); //recorded if the account is deleted
                   response.sendRedirect("Dashboard");
               } catch (SQLException ex) {
                   Logger.getLogger(BlockUser.class.getName()).log(Level.SEVERE, null, ex);
               }
                     }else{
            
            
      System.out.println("unblock User"+request.getParameter("unblockUser"));
     }//end of inner else statement
     }//end of second if statement
    }//end of else
    }//end of class
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
