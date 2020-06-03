package databasemanagement;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTable implements Table {

	@Override
	public void userRegistration(Connection connect) throws SQLException, ClassNotFoundException {
		//schemas for user Registration //user id must be changed to varchar autoincrement using Trigger
		String query="create table userRegistration(userID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,username VARCHAR(150) UNIQUE NOT NULL,"
				+ "password VARCHAR(15) NOT NULL,firstName VARCHAR(100), lastName VARCHAR(100), email VARCHAR(150) UNIQUE NOT NULL,phoneNumber VARCHAR(18) NOT NULL,"
				+ "githubLink VARCHAR(100) UNIQUE, SocialSitelinK VARCHAR(100) UNIQUE,Status VARCHAR(15) DEFAULT 'Active',"
				+ "role varchar(10) DEFAULT 'user',profilepic blob)";
		try {
		connect.prepareStatement(query).execute();
		System.out.println("table userRegistration creation success");
		}catch(Exception e) {
			System.out.println("Table ********** blocked user *********** creation ******** successfull ********* ");
			e.printStackTrace();
		}
	}

	@Override
	public void userHistory(Connection connect) throws SQLException, ClassNotFoundException {
		//schemas for userHistory where UserId is a foreign key 
			String query="create table userHistory(userID INT NOT NULL, FOREIGN KEY (userID) REFERENCES userRegistration (userID) ON DELETE CASCADE,"
					+ "Date DATE NOT NULL,time TIME NOT NULL,Activity_log VARCHAR(200) NOT NULL)";
				try {
				connect.prepareStatement(query).execute();
				System.out.println("Table ********** user History *********** creation ******** successfull ********* ");
				}catch(Exception e) {
					System.out.println("table userHistorycreation unsuccessfull"+e);
					
				}
	}

	@Override
	public void admin(Connection connect) throws SQLException, ClassNotFoundException {
		String query="create table admin(adminID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,username VARCHAR(150) UNIQUE NOT NULL,"
				+ "password VARCHAR(15) NOT NULL,firstName VARCHAR(100), lastName VARCHAR(100), email VARCHAR(150) UNIQUE NOT NULL,phoneNumber VARCHAR(18) NOT NULL,"
				+ "githubLink VARCHAR(100) UNIQUE,profilepic blob,SocialSitelinK VARCHAR(100) UNIQUE,role varchar(10) DEFAULT 'admin')";
			try {
			connect.prepareStatement(query).execute();
			System.out.println("Table **********  *********** creation ******** successfull ********* ");
			}catch(Exception e) {
				System.out.println("table admin creation unsuccessfull check this and make sure everything is ok: " +e);
				
			}
		
	}

	@Override
	public void blockedUser(Connection connect) throws SQLException, ClassNotFoundException {
		String query="create table blockedUser(userID INT NOT NULL, FOREIGN KEY (userID) REFERENCES userRegistration (userID) ON DELETE CASCADE,"
				+ "Date DATE NOT NULL,time TIME NOT NULL, Reason_log VARCHAR(200) NOT NULL)";
			try {
			connect.prepareStatement(query).execute();
			System.out.println("Table ********** blocked user *********** creation ******** successfull ********* ");
			}catch(Exception e) {
				System.out.println("table blockedUser creation unsuccessfull, please check you driver is oky: "+ e);
				
			}
		
	}

}
