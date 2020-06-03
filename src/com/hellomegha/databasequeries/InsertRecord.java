package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class InsertRecord implements RecordInsertition{
	private DatabaseConnection connection=new DatabaseConnection();
	
	@Override
	public boolean intoUserHistory(int userID, Date date, Time time, String reason) throws SQLException {
		String sql="insert into userHistory(userID,Date,time,Activity_log) values(?,?,?)";
		
		Connection con=connection.makeConnection();		
		PreparedStatement statement=con.prepareStatement(sql);
		try {
			
			statement.execute();
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
	public boolean intoUserRegistration(String username, String email, String phonenumber) throws SQLException {
String sql="insert into userHistory(userID,Date,time,Activity_log) values(?,?,?)";
		
		Connection con=connection.makeConnection();		
		PreparedStatement statement=con.prepareStatement(sql);
		try {
			
			statement.execute();
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
		// TODO Auto-generated method stub
		return false;
	}
	
}
