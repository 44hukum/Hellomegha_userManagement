package com.hellomegha.usermanagement;

import com.hellomegha.databasequeries.FindUser;
import com.hellomegha.databasequeries.InsertRecord;
import com.hellomegha.databasequeries.UpdateRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Dashboard extends HttpServlet{
    
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
             System.out.println("com.hellomegha.usermanagement.Dashboard.doPost()");
             
         }
    
        public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	HttpSession session=request.getSession();
        
     
       if(request.getRequestURI().equals("/hellomegha/updateAccount")){ //if request for update is sent
           String user=(String)session.getAttribute("username");
          try {
              if(session.getAttribute("changeU") ==null){
                  
                  
                //for more to edit insert insertition data here and update edit profile page
                //for current user
                String username,firstname,lastname,email,phonenumber,githublink,about,address;
                 username=request.getParameter("username");
                 firstname=request.getParameter("firstname");
                 phonenumber=request.getParameter("phonenumber");
                about=request.getParameter("description");
                lastname=request.getParameter("lastname");
                address=request.getParameter("address");
                email=request.getParameter("email"); 
                githublink=request.getParameter("githublink");
                Integer userId=(Integer) session.getAttribute("userID");
                  //if there is no value for the attribute
                  if(githublink.isEmpty())githublink=null;
                  if(firstname.isEmpty())firstname=null;
                  if(lastname.isEmpty())lastname=null;
                  if(address.isEmpty())address=null;                 
                     
                      //assign all the given input int an array
                      String[] users={username,firstname,lastname,email,phonenumber,githublink,about,address};
                     
                      if(session.getAttribute("role").equals("admin")){
                          boolean re=(new UpdateRecord()).updateAdmin(users,userId);
                             if(re){
                            userId=(Integer) session.getAttribute("userID");
                          (new InsertRecord()).intoAdminHistory(userId,"Account details updated");
                          session.setAttribute("username", username);
                        }
                      }
                        if(session.getAttribute("role").equals("user")){
                          boolean re=(new UpdateRecord()).updateUser(users,userId);
                             if(re){
                            userId=(Integer) session.getAttribute("userID");
                          (new InsertRecord()).intoUserHistory(userId,"Account details updated");
                          session.setAttribute("username", username);
                        }
                      }
                                                       
              }else{
                  String ui=(String)session.getAttribute("changeU");
                  Integer id=Integer.parseInt(ui);
                  //for user
                   String username,firstname,lastname,email,phonenumber,githublink,about,address;
                 username=request.getParameter("username");
                 firstname=request.getParameter("firstname");
                 phonenumber=request.getParameter("phonenumber");
                about=request.getParameter("description");
                lastname=request.getParameter("lastname");
                address=request.getParameter("address");
                email=request.getParameter("email"); 
                githublink=request.getParameter("githublink");
              
                  //if there is no value for the attribute
                  if(githublink.isEmpty())githublink=null;
                  if(firstname.isEmpty())firstname=null;
                  if(lastname.isEmpty())lastname=null;
                  if(address.isEmpty())address=null;                 
                     
                      //assign all the given input int an array
                      String[] users={username,firstname,lastname,email,phonenumber,githublink,about,address};
                     
                          boolean re=(new UpdateRecord()).updateUser(users,id);
                             if(re){
                         
                          (new InsertRecord()).intoUserHistory(id,"Account details updated byadmin");
                          session.setAttribute("username", username);
                        }
                         
                  
                  System.out.print("hellllo ::done");
                  session.removeAttribute("changeU");
              }response.sendRedirect("Dashboard");
        } catch (SQLException ex) {
         Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
          }
   
       }else{
            
         RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
         rd.forward(request, response);
       }

}//end class
        
         public void doGet(HttpServletRequest request,HttpServletResponse response)
         throws IOException, ServletException {
             System.out.println("com.hellomegha.usermanagement.Dashboard.doPost()");
         
         }
}
