package com.hellomegha.databasequeries;
/*
 * Insertition of data in various table
 * 
 * */

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;


public interface RecordInsertition {
public boolean intoUserHistory(int userID, Date date, Time time, String reason) throws SQLException; 
public boolean intoBlockedUser() throws SQLException;
public boolean intoUserRegistration(String username,String email,String phonenumber) throws SQLException;
//there must be another function that recieve full attributes of the userREgistration

public boolean intoAdmin(String username,String email,String phonenumber) throws SQLException;
}
