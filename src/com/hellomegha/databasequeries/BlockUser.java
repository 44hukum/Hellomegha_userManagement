/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author wanu
 */
public class BlockUser {
    private DatabaseConnection connection=new DatabaseConnection();
    //block user
    public  boolean blockUser(int userID){
       		
		String sql="update userRegistration set Status='Blocked' where userID=?";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=null;
        try {
            statement = con.prepareStatement(sql);       
		statement.setInt(1,userID);  
                
	 
		try {			
			if(statement.execute() == false){
				return true;
				
			}
		}catch(Exception e) {}
	
		if(statement !=null) {
			statement.close();
		}
		if(con !=null) {
			con.close();
		}
              } catch (SQLException ex) {
            Logger.getLogger(DeleteRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
return false;
    }
    
      //unblock user
    public  boolean unblockUser(int userID){
       		
		String sql="update userRegistration set Status='Active' where userID=?";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=null;
        try {
            statement = con.prepareStatement(sql);       
		statement.setInt(1,userID);
		
                
                
	 
		try {			
			if(statement.execute() == false){
				return true;
				
			}
		}catch(Exception e) {}
	
		if(statement !=null) {
			statement.close();
		}
		if(con !=null) {
			con.close();
		}
              } catch (SQLException ex) {
            Logger.getLogger(DeleteRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
return false;
    }
    //unblock user
     public  boolean unblockUser(String username){
       		
		String sql="update userRegistration set Status='Active' where username=?";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=null;
        try {
            statement = con.prepareStatement(sql);       
		statement.setString(1,username);
		
                
                
	 
		try {			
			if(statement.execute() == false){
				return true;
				
			}
		}catch(Exception e) {}
	
		if(statement !=null) {
			statement.close();
		}
		if(con !=null) {
			con.close();
		}
              } catch (SQLException ex) {
            Logger.getLogger(DeleteRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
return false;
    }
    
    
    //block user with username
     public  boolean blockUser(String username){
       		
		String sql="update userRegistration set Status='Blocked' where username=?";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=null;
        try {
            statement = con.prepareStatement(sql);       
		statement.setString(1,username);  
                
	 
		try {			
			if(statement.execute() == false){
				return true;
				
			}
		}catch(Exception e) {}
	
		if(statement !=null) {
			statement.close();
		}
		if(con !=null) {
			con.close();
		}
              } catch (SQLException ex) {
            Logger.getLogger(DeleteRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
return false;
    }
}
