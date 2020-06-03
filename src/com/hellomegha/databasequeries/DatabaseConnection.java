package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import databasemanagement.Initiate;

public class DatabaseConnection {
	Initiate obj=new Initiate();
	String url=obj.getDatabaseUrl()+obj.getHost();
	Connection connect=null;
	
	public Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, obj.getUser(), obj.getPassword());
			con.prepareStatement("use userManagement;").execute();			
			return con;
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connect;
	}
	
}
