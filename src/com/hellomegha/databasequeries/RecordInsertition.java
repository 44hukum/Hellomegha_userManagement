package com.hellomegha.databasequeries;
/*
 * Insertition of data in various table
 * 
 * */

import java.sql.SQLException;


public interface RecordInsertition {
public boolean intoUserHistory(int userID,String reason) throws SQLException; 
public boolean intoBlockedUser() throws SQLException;
public boolean intoUserRegistration(String username,String password,String email,String phonenumber) throws SQLException;
//there must be another function that recieve full attributes of the userREgistration

public boolean intoAdmin(String username,String email,String phonenumber) throws SQLException;
public boolean intoAdminHistory(int adminID,String reason) throws SQLException ;
}
