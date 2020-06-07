/*
 * 
 */
package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *class Delete the user record from the database
 * @author wanu
 */
public class DeleteRecord {
    //make connection
    private DatabaseConnection connection=new DatabaseConnection();
    //delete user
    public  boolean deleteUser(int userID){
       		
		String sql="Delete from userRegistration where userID=?";
		Connection con=connection.makeConnection();		
		PreparedStatement statement=null;
        try {
            statement = con.prepareStatement(sql);       
		statement.setInt(1,userID);
		
                
                
	 
		try {			
			if(statement.execute() == false){
				return true;
				
			}
		}catch(Exception e) {}
	
		if(statement !=null) {
			statement.close();
		}
		if(con !=null) {
			con.close();
		}
              } catch (SQLException ex) {
            Logger.getLogger(DeleteRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
return false;
    }

}
