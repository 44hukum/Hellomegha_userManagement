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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wanu
 */
public class CountUser implements UserCounter{
private DatabaseConnection connection=new DatabaseConnection();
    
    @Override
    public int countUser() {
     Connection con=connection.makeConnection();
     String sql="SELECT COUNT(*) FROM userRegistration;";
    try {
        ResultSet a=con.createStatement().executeQuery(sql);
        while(a.next()){
            return a.getInt(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CountUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
        return 0;
    }

    @Override
    public int countAdmin() {
  Connection con=connection.makeConnection();
     String sql="SELECT COUNT(*) FROM admin;";
    try {
        ResultSet a=con.createStatement().executeQuery(sql);
        while(a.next()){
            return a.getInt(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CountUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
        return 0;
    }

    @Override
    public int countBlockedUser() {
   Connection con=connection.makeConnection();
     String sql="SELECT COUNT(*) FROM userRegistration where Status='Blocked';";
    try {
        ResultSet a=con.createStatement().executeQuery(sql);
        while(a.next()){
            return a.getInt(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CountUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
        return 0;
    }
    public int countUserInDifferentDate(String date) {
        Date start;
    try {
        start = new SimpleDateFormat("yyyy-MM-dd").parse(date);
         java.sql.Date startDate = new java.sql.Date(start.getTime());
    
        //start date and end date
   
     Connection con=connection.makeConnection();
     String sql="SELECT COUNT(*) FROM userHistory where Date=? AND Activity_log=?;";
        PreparedStatement statement=con.prepareStatement(sql);
        statement.setDate(1, startDate);
        statement.setString(1, "Account created");
        ResultSet a=statement.executeQuery();
        while(a.next()){
            return a.getInt(1);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CountUser.class.getName()).log(Level.SEVERE, null, ex);
    }catch (ParseException ex) {
        Logger.getLogger(CountUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        
        return 0;
    }
    public static void main(String[] args) {
        CountUser obj=new CountUser();
            System.out.println( obj.countBlockedUser());
            System.out.println( obj.countAdmin());
            System.out.println( obj.countUser());
      
    }
}
