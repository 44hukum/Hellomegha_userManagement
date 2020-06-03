package databasemanagement;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * Table creation for database userManagement it defines the abstract rules implemented by
 * all the tables in userManagement Database which extends their own rule. Each method reflect each 
 * table in database
 * 
 * 
 * @Hukum Gosain 
 * */
public interface Table {
	//user REgistration
	public void userRegistration(Connection connect) throws SQLException,ClassNotFoundException;	
	public void userHistory(Connection connect) throws SQLException, ClassNotFoundException;
	public void admin(Connection connect) throws SQLException,ClassNotFoundException;
	public void blockedUser(Connection connect) throws SQLException,ClassNotFoundException;

}
