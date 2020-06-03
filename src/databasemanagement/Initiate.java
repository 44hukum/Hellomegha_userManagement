package databasemanagement;

import java.sql.SQLException;
public class Initiate {
	//currently support mysql only
		private String databaseUrl="jdbc:mysql://";
		//change credential here
		private String user="wanu";
		private String password="hukumGosain123";
		private String host="localhost";
		
		
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
			(new Initiate()).createDb();;
		}
	
} 
  