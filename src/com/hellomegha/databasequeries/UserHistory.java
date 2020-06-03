package com.hellomegha.databasequeries;

import java.sql.Date;
import java.sql.Time;

public interface UserHistory {
//login date and time
	public void loginTime(int userID, Date date, Time time,String activity);
	//logout date and time
	public void logoutTime(int userID, Date date, Time time,String activity);
}
