/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessLayer;

import databasemanagement.Initiate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *This routine is used to create and close all the database access throughout this
 * project
 * @author wanu
 */
public class ReadTable {
    //calling the initiate.java file to access the database
    private Initiate details=new Initiate();
    private Connection connection=null;
    private ResultSet result=null;
    private Statement statement=null;
    private String url=details.getDatabaseUrl()+details.getHost()+"/?autoReconnect=true&useSSL=false";
    
    //create connection
        public Connection createConnection() throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url, details.getUser(), details.getPassword());
            System.err.println(connection.isValid(1));
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
        
}
