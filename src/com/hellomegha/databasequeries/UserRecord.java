package com.hellomegha.databasequeries;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserRecord {
	
	public ResultSet blockedUser(String username) throws SQLException; //get the blockeduser data
	public ResultSet blockedUserTableRecord() throws SQLException; //get the full list of blocked user
	public ResultSet userHistory(int username) throws SQLException; //get the history of a user
	public ResultSet userHistoryTableRecord() throws SQLException; //get the history of all the users
	public ResultSet getUser(String username) throws SQLException; //returns the user
	public ResultSet getAdmin(String username) throws SQLException; //extracts the admin details
	public ResultSet adminTableRecord() throws SQLException; //returns the admin list
	public ResultSet userTableRecord() throws SQLException ; //returns the users list
        public ResultSet adminHistory(int userID) throws SQLException;//returns the admin History
}
