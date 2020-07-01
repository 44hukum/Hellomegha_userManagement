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
public class RegisteredUser {
    private DatabaseConnection connection=new DatabaseConnection();
    String []registered=new String[8];
    public String[] countUser(){
     //make connection 
    Connection con=connection.makeConnection();
    int frequency=0;
    for(int i=1;i<=24;i=i+3){
        
        int a=i;
        int b=i+3;
        if(i==20){
        a=i;
        b=i+4;
        }
        String start=a+":00:00";
        String end=b+":00:00";
        String sql="SELECT COUNT(*) FROM userHistory where time<? AND time>=? AND Activity_log='Account created'";
        try {
            //prepare first statement
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1, end);
            statement.setString(2, start);
           ResultSet result= statement.executeQuery();
           while(result.next()){
           registered[frequency]=String.valueOf(result.getInt(1));
           } 
        } catch (SQLException ex) {
            Logger.getLogger(RegisteredUser.class.getName()).log(Level.INFO, "userCounter", ex);
        }catch(Exception e){
        e.printStackTrace();
        }
        frequency = frequency+1;
    }
    
    //count the number or say get the number 
    return registered;
    
    } 
    //make connection 
    
    //execute the query
    //count the number or say get the number 
    public static void main(String[] args) {
        RegisteredUser user=new RegisteredUser();
        String[] x=user.countUser();
        for(int i=0;i< x.length;i++){
                System.out.println(x[i]);
        }
           }
            
    
}
