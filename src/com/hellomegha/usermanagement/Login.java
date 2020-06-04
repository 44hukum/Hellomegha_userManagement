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

public class Login extends HttpServlet{
	 String[] uri= {"0","0"};
	/**
	 * 
	 */
	private static final long serialVersionUID = 1001;
	private FindUser userdetails=new FindUser();
	
 public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	 try {
	 uri=(request.getRequestURI()).split("/hellomegha/login/");
	 if(uri[1].equals("resetpassword")) {
			forgetPassword(request, response);
		}
	 }catch(Exception e) {}
	 
	
	 HttpSession session=request.getSession();
	 
	 
		if(session.getAttribute("username") == null) { 
		 System.out.println("from inside");
		 
	 //if request contains the reset header call forgetPassword function
	 
	 //else
	 //get the login credentials 
	 String username=request.getParameter("username");
	 String password=request.getParameter("password");
	 
	 //validate the user and user role
	 	//get the user details with username on it
	 
	 FindUser user=new FindUser();
	 
	 try(PrintWriter out=response.getWriter()) {
		 ResultSet result=user.getAdmin(username,password); //if the user exist as a admin then result is not empty
		 if(result.next() == false) { //user pass 
			ResultSet res=user.getUser(username);
			if(res.next() !=false) {
				//check password
				if(res.getString("password").equals(password)) {
				//create session
				session.setAttribute("username", username);
				session.setAttribute("data", res);
				session.setAttribute("role", "user");
				//save history
				
				(new InsertRecord()).intoUserHistory(res.getInt("userID"),"Successfully logged into the system"); //create and log login history
				//redirect to the dashboard
				response.sendRedirect("Dashboard");
			}
				//please re-enter your password
				request.setAttribute("loginerr", "loginerror");
				RequestDispatcher toDashboard=request.getRequestDispatcher("welcome.jsp");
				toDashboard.forward(request, response);
		}
			//please proceed to signup
			request.setAttribute("notAuser", "notAuser");
			RequestDispatcher tofirst=request.getRequestDispatcher("welcome.jsp");
			tofirst.forward(request, response);

		}//end of first if statement
		
		
		//admin pass
		else{
			//check password
			if(result.getString("password").equals(password)) {
			//create session
				session.setAttribute("username", username);
				session.setAttribute("data", result);
				session.setAttribute("role", "admin");
			//save history
				(new InsertRecord()).intoAdminHistory(result.getInt("adminID"),"Successfully logged into the system");
			
				//redirect to the dashboard
				response.sendRedirect("Dashboard");
			}
			//please re-enter your password
			request.setAttribute("loginerr", "loginerror");
			RequestDispatcher tofirst=request.getRequestDispatcher("welcome.jsp");
			tofirst.forward(request, response);
		}
		
	} catch (SQLException e) {
		System.out.println("please open mysql database");
		
	}catch(Exception e) {
		
	}
	}
	 //redirect the user to the dashboard is found
	 else {
		 response.sendRedirect("Dashboard");
	 }//end of redirection
		
	
 }
 
 //password reset
 public void forgetPassword(HttpServletRequest request,HttpServletResponse response) throws IOException {
	 //load the password reset page
	 //get the username 
	 //demand the phonenumber 
	 //get the userDetails using username if user exist ask for phonenumber 
	 //if phonenumber match 
	 //ask user to input the password
	 //save password to the database
	 //redirect the user to login
	 try(PrintWriter out=response.getWriter()){
		 out.println("reset success");
	 }
	 
 }
}
