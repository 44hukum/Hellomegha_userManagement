package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import databasemanagement.Initiate;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
	 //calling the initiate.java file to access the database
    private Initiate details=new Initiate();
    private Connection connection=null;
    private ResultSet result=null;
    private Statement statement=null;
    private String url=details.getDatabaseUrl()+details.getHost()+"/?autoReconnect=true&useSSL=false";
    
    //create connection

      
    
    /**
     *
     * @return connection
     */
        public Connection makeConnection() {
		try {
			  Class.forName("com.mysql.cj.jdbc.Driver");
                connection=DriverManager.getConnection(url, details.getUser(), details.getPassword());
                System.err.println(connection.isValid(1));
                     try {
              
                Statement statement=connection.createStatement();
                statement.execute("use userManagement");
             
            } catch (SQLException ex) {
                Logger.getLogger(FindUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
		} catch (ClassNotFoundException e) {e.printStackTrace();}
                catch (SQLException e) {e.printStackTrace();
		}
	  return connection;	
          
        }
        
    //close connection
        public void closeConnection(ResultSet result,Statement statement,Connection connection) throws SQLException{
        if(result !=null){
        result.close();
        }
        if(statement !=null){
        statement.close();
        }
        if(connection !=null){
        connection.close();
            }
        }
   } //end of class
