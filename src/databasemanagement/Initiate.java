package databasemanagement;

import java.sql.SQLException;
public class Initiate {
	//currently support mysql only
		private String databaseUrl="jdbc:mysql://";
		/**
		 * 
		 * ***************************CHANGE BELOW HERE************************
		 *  user name from wanu to you username
		 *  pasword hukumGosain123 to your passowrd
		 *  localhost to your local hostshow
		 * 
		 * 
		 * ***/
		private String user="wanu";
		private String password="hukumGosain123";
		private String host="localhost";
                
		
		/**
		 * 
		 * ***************************CHANGE  UP HERE************************
		 * 
		 * 
		 * 
		 * ***/
		
		public String getDatabaseUrl() {
			return databaseUrl;
		}
		public String getUser() {
			return user;
		}
		public String getPassword() {
			return password;
		}
		public String getHost() {
			return host;
		}
		
		
		public void createDb() throws ClassNotFoundException, SQLException {
			(new CreateDatabase(databaseUrl,user,password,host)).configureDatabase();
		}
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			(new Initiate()).createDb();
		}
	
} 
  