package com.hellomegha.databasequeries;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

//creates the connection and returns the users
public class FindUser implements UserRecord{
	private DatabaseConnection connection=new DatabaseConnection();
	ResultSet result=null;
	
        //use the usermanagement database
      
	public ResultSet userTableRecord() throws SQLException {	//Takes the connection to the database
		return connection.makeConnection().prepareStatement("select * from userRegistration;").executeQuery();
	}
	
	public ResultSet getUser(String username) throws SQLException {	//checks if the user exist or not in the users database
		try {
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from userRegistration where "
				+ "username=?");
		statement.setString(1, username);
		result=statement.executeQuery();
		}catch(Exception e)	{
			return result;
		}
		return result;
				
	}//end of is user
	
	/*
	 * Get the Admin details
	 * */
	public ResultSet adminTableRecord() throws SQLException{	 //Takes the connection to the database
				return connection.makeConnection().prepareStatement("select * from admin;").executeQuery();
	}
		//returns all the given user
	public ResultSet getAdmin(String username) throws SQLException {	//checks if the user exist or not in the users database
			PreparedStatement statement=connection.makeConnection().prepareStatement("select * from admin where "
					+ "username=?");
			statement.setString(1, username);
			return statement.executeQuery();
			
	}
	//for a particular user
	public ResultSet getAdmin(String username,String password) throws SQLException {	//checks if the user exist or not in the users database
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from admin where "
				+ "username=? AND password=?");
		statement.setString(1, username);
		statement.setString(2, password);
		return statement.executeQuery();
		
}
	/*
	 *returns the userHistory 
	 * */
	 
	public ResultSet userHistoryTableRecord() throws SQLException {	 //Takes the connection to the database
		return connection.makeConnection().prepareStatement("select * from userHistory;").executeQuery();
	}

	public ResultSet userHistory(int userID) throws SQLException {	 	//user History of a certain user
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from userHistory where "
				+ "userID=?");
		statement.setInt(1, userID);
		return statement.executeQuery();
		
	}
	
	/*
	 *returns the blocked user 
	 * */
	
	public ResultSet blockedUserTableRecord(Date start,Date end) throws SQLException {	 //Takes the connection to the database
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from blockedUser where "
				+ "Date>=? AND  Date<=? AND Reason_log='Blocked'");
		statement.setDate(1, start);		
		statement.setDate(2, end);		
		return statement.executeQuery();	
	}
	
	public ResultSet blockedUser(String username) throws SQLException {	//returns the record of a particular user
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from blockedUser where "
				+ "username=?");
		statement.setString(1, username);		
		return statement.executeQuery();		
	}
	
	/*
	 * returns the admin history
	 * */
	public ResultSet adminHistory(int userID) throws SQLException {	 	//user History of a certain user
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from adminHistory where "
				+ "adminID=?");
		statement.setInt(1, userID);
		return statement.executeQuery();
		
	}
	/*
        *user created in a given date range
         
         */
        
        
	public ResultSet user_created_in_a_date_range(Date start,Date end) throws SQLException {	 //Takes the connection to the database
		PreparedStatement statement=connection.makeConnection().prepareStatement("select * from userHistory where "
				+ "Date>=? AND  Date<=? AND Activity_log='Account created'");
		statement.setDate(1, start);		
		statement.setDate(2, end);		
		return statement.executeQuery();	
	}
        
}
