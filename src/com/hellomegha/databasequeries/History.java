package com.hellomegha.databasequeries;

import java.sql.Date;
import java.sql.Time;

public class History implements UserHistory{
	private DatabaseConnection connection=new DatabaseConnection();
	@Override
	public void loginTime(int userID, Date date, Time time, String activity) {
		//call userHistory table
		connection.makeConnection();
		//save data
		
	}

	@Override
	public void logoutTime(int userID, Date date, Time time, String activity) {
		//call userHistory table and save data
		
	}

}
