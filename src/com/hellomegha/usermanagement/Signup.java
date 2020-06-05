package com.hellomegha.usermanagement;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hellomegha.databasequeries.DatabaseConnection;
import com.hellomegha.databasequeries.FindUser;
import com.hellomegha.databasequeries.InsertRecord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Signup extends HttpServlet{
	
	/**
	 * 
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                //creates the session
                HttpSession session=req.getSession();
		try{
                    //get Attributes from welcome.jsp for a login
                        String username= req.getParameter("username");	
			String email= req.getParameter("email");
			String phonenumber= req.getParameter("phonenumber");
			String password=req.getParameter("password");
                    //check wether the user exist or not
                    FindUser user=new FindUser();
                    ResultSet isAuser=user.getUser(username);
                    
               if(isAuser.next() == false){ //checks wether the user already exist or not    
                    isAuser.close();
                    InsertRecord insertRecord=new InsertRecord();
                    boolean result=insertRecord.intoUserRegistration(username, password, email, phonenumber);
                    if(result){ //if the user creation is successfull
                       
                        //getuser 
                          ResultSet userData=user.getUser(username);
                        //set history user creation time and user login time
                        while(userData.next()){              
                        //create session
                       
                        session.setAttribute("userID", userData.getInt("userID"));
                        insertRecord.intoUserHistory(userData.getInt("userID"),"Account created");
                        } //session creation successfull and histiry creation to
                         userData.close();
                         session.setAttribute("username", username);
                         session.setAttribute("role", "user");
                        resp.sendRedirect("Dashboard");
                      } 
                    else{
                    session.setAttribute("error", "User creation unsuccessfull please try again in 30sec");
                    session.setMaxInactiveInterval(10);
                    resp.sendRedirect("welcome.jsp");
                   }
                }//endif
                   else{
                    session.setAttribute("error", "user already exist!");
                    session.setMaxInactiveInterval(10);
                    resp.sendRedirect("welcome.jsp");
                   }
                }  catch (SQLException ex) {
                Logger.getLogger(Signup.class.getName()).log(Level.INFO, "Error", ex);
                  }         		
                  catch(Exception e) {
			
		}
	
}           
        //when the servlet is refreshed and set for forgetpassword 
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	         
            HttpSession userSession=req.getSession();
		
		
		try(PrintWriter out=resp.getWriter()){out.println("hello  i am from inside get");	
                }		
                    catch(Exception e) {
			
		}
        
}
}
