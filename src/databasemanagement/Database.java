package databasemanagement;

import java.sql.SQLException;

/**
 * Responsible for database driver detection, database creation,
 * database deletion and database use for the current application
 * creates the userManagement database and use it
 * 
 *implemented by CreateDatabase class
 * **/
public interface Database {	
	//create and configure the database
	public boolean configureDatabase() throws ClassNotFoundException, SQLException;
}
