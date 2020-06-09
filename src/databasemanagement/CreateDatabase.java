package databasemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CreateDatabase implements Database{
	private String dburl;
	private String dbuser;
	private String dbpassword;
	private String dbhost;
	private int frequency =0;
	Connection connection=null;
	
	
	public CreateDatabase(String dburl, String dbuser, String dbpassword, String dbhost) {
		this.dburl = dburl;
		this.dbuser = dbuser;
		this.dbpassword = dbpassword;
		this.dbhost = dbhost;
	}
        public void insertAdminData(Connection ad){
                String sql="insert into admin(username,password,firstname,lastname,email,phonenumber) values('hukum','123','a','b','a@b','980980')";
            try {
                ad.createStatement().execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(CreateDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
        
        }
	@Override
	public boolean configureDatabase() throws ClassNotFoundException, SQLException {
		System.out.println("Hello, My name is Rocketman, I am a your guide to create and manage database :  ");
		try {
			for(int i=0;i<=10;i++) {
				
				if(i==6) {
					Thread.sleep(500);	
					   //create a link to the driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection=DriverManager.getConnection(dburl+dbhost+"/"+"?"+"user="+dbuser+"&password="+dbpassword);
					
				}
				System.out.println("Analysing database ##:" +i*(10)+"%");				
			}
			
		} catch (InterruptedException e) {
			
		}
		System.out.println();
			
		ResultSet database=connection.getMetaData().getCatalogs();//check if the database exist or not if database exist returns
		while(database.next()) {
		
		if(database.getString(1).equals("userManagement")) {//query database name if database name is equal to parameterIndexname return 
			System.out.println("Found ****** database  ## usermanagement");
			System.out.println("dropping ****** database usermanagement");
			connection.prepareStatement("drop database userManagement").execute(); 
		   }
		}
		
	
		database.close();	//close the resultset
			
		boolean isResultSet=connection.prepareStatement("create database userManagement").execute(); //prepared statement create database name 
		if( isResultSet == false) {
			System.out.println("creating ********** usermanagement *********** database ********* ");
			System.out.println("Database ********** usermanagement *********** creation ******** successfull ********* ");
			connection.prepareStatement("use userManagement").execute(); 
			
                        
			CreateTable  table=new CreateTable();	//creates table for userManagement 		
			table.userRegistration(connection);
			table.admin(connection);
			table.blockedUser(connection);
			table.userHistory(connection);
			table.adminHistory(connection);
			System.out.println("done!! ******* Record Insertion processig ...");
                        
			insertAdminData(connection);
                        System.out.println("");
			return true;
		}	
		return false;
	}
	
}
