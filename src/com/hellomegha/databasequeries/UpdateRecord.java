/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wanu
 */
public class UpdateRecord {
    private DatabaseConnection connect=new DatabaseConnection();
    
/**
 * @return  boolean
 * update user data when the user or admin call for update record
 *@param  Array userdata 
 *@param  username
 * 
 */
    public boolean updateUser(String[] userData,Integer userId){
        try {
            String username,firstname,lastname,email,phonenumber,githubLink,About,Address;
                          
            username=userData[0];
            firstname=userData[1];
            lastname=userData[2];
            email=userData[3];
            phonenumber=userData[4];
            githubLink=userData[5];
            About=userData[6];
            Address=userData[7];
            
            //declare Sql
            String sql="update userRegistration set username=?, firstname=?,"
                    +"lastname=?,email=?,phonenumber=?,githubLink=?,About=?,Address=? where userID=?";
            
            
     
                //make connection
                Connection con=connect.makeConnection();
                //prepare statement
                PreparedStatement  statement = con.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, firstname);
                statement.setString(3, lastname);
                statement.setString(4, email);
                statement.setString(5, phonenumber);
                statement.setString(6, githubLink);
                statement.setString(7, About);
                statement.setString(8, Address);
                statement.setInt(9, userId);
                boolean result=statement.execute();
                
                //close statement
                connect.closeConnection(null, statement, con);
                //return result
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UpdateRecord.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            return false;
        }//end of userupdate
  
    
    
    
/**
 * @return  boolean
 * update admin data when admin call to update profile
 *@param  Array userdata 
 *@param  username
 * 
 */
    public boolean updateAdmin(String[] userData,Integer userId){
        String username,firstname,lastname,email,phonenumber,githubLink,About,Address;
        username=userData[0];
        firstname=userData[1];
        lastname=userData[2];
        email=userData[3];
        phonenumber=userData[4];
        githubLink=userData[5];
        About=userData[6];
        Address=userData[7];
      
        //declare Sql
        String sql="update admin set username=?, firstname=?,"
                +"lastname=?,email=?,phonenumber=?,githubLink=?,About=?,Address=? where adminID=?";
       
        
        try {
             //make connection
            Connection con=connect.makeConnection();
               //prepare statement
          PreparedStatement  statement = con.prepareStatement(sql);
         statement.setString(1, username);
          statement.setString(2, firstname);
           statement.setString(3, lastname);
            statement.setString(4, email);
             statement.setString(5, phonenumber);
              statement.setString(6, githubLink);
               statement.setString(7, About);
                statement.setString(8, Address);
                statement.setInt(9, userId);
               boolean result=statement.execute();
           
          //close statement
            connect.closeConnection(null, statement, con);
            //return result
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRecord.class.getName()).log(Level.SEVERE, null, ex);
        
        }     
            
        return false;
    }
    
    public boolean updatePassword(int userID,String password){
             String sql="update userRegistration set password=? where userID=?";
            Connection con=connect.makeConnection();
        try {
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, userID);
            if(!statement.execute())return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e){
        e.printStackTrace();
        }
    return false;
    }
    
    //update internal record
    
    public boolean updateUsername(String username, String usernameC){
        try {
          
                 
            //declare Sql
            String sql="update userRegistration set username=? where username=?";
                   
     
                //make connection
                Connection con=connect.makeConnection();
                //prepare statement
                PreparedStatement  statement = con.prepareStatement(sql);
                statement.setString(1, usernameC);
                statement.setString(2,username);
                boolean result=statement.execute();
                
                //close statement
                connect.closeConnection(null, statement, con);
                //return result
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(UpdateRecord.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
            return false;
        }//end of userupdate
    public static void main(String[] args) {
        UpdateRecord obj=new UpdateRecord();
        
    }
}
