/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.databasequeries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public static void main(String[] args) {
        CountUser obj=new CountUser();
            System.out.println( obj.countBlockedUser());
            System.out.println( obj.countAdmin());
            System.out.println( obj.countUser());
      
    }
}
