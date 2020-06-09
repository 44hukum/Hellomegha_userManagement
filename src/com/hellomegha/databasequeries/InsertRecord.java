package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

public class InsertRecord implements RecordInsertition{
	private DatabaseConnection connection=new DatabaseConnection();
	
	@Override
	public boolean intoUserHistory(int userID,String reason) throws SQLException {
		//creates the time stamp
		java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
		java.sql.Timestamp time=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			
		String sql="insert into userHistory(userID,Date,time,Activity_log) values(?,?,?,?)";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setInt(1,userID);
		statement.setDate(2, date);
		statement.setTimestamp(3, time);
		statement.setString(4, reason);
		
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
		return false;
	}
//admin history data insertition
	public boolean intoAdminHistory(int adminID,String reason) throws SQLException {
		//creates the time stamp
		java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
		java.sql.Timestamp time=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
			
		String sql="insert into adminHistory(adminID,Date,time,Activity_log) values(?,?,?,?)";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setInt(1,adminID);
		statement.setDate(2, date);
		statement.setTimestamp(3, time);
		statement.setString(4, reason);
		
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
		return false;
	}
	
	@Override
	public boolean intoBlockedUser() throws SQLException {
		return false;
	}

	@Override
	public boolean intoUserRegistration(String username,String password, String email, String phonenumber) throws SQLException {
		String sql="insert into userRegistration(username,password,email,phoneNumber) values(?,?,?,?)";
		
                
		Connection con=connection.makeConnection();		
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		statement.setString(3, email);
		statement.setString(4, phonenumber);
		
		try {
			
			if(statement.execute() == false) {
				return true;
			}
			
		}catch(Exception e) {}
	
		if(statement !=null) {
			statement.close();
		}
		if(con !=null) {
			con.close();
		}
		return false;
	}

	@Override
	public boolean intoAdmin(String username, String email, String phonenumber) throws SQLException {
		
		return false;
	}
	
}
