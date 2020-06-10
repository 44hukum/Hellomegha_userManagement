/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hellomegha.databasequeries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wanu
 */
public class GenerateReport {
    java.sql.Date date=new java.sql.Date(Calendar.getInstance().getTime().getTime());
      ResultSet result=null;
//take start and end date
    
     /*
    Generate the report on the basis of the user blocked in given date range
    */
    public ResultSet blocked_user_report(String start, String end){
     
     Date startD;
       Date endD;
    
    
       try {
            startD = new SimpleDateFormat("yyyy-MM-dd").parse(start); //get the date
             endD = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        //start date and end date
    java.sql.Date startDate = new java.sql.Date(startD.getTime());
    java.sql.Date endDate = new java.sql.Date(endD.getTime());
       
            //query the database with two date
          result=(new FindUser()).blockedUserTableRecord(startDate, endDate);
            //get the blocked user data
            while(result.next()){
                System.out.println(result.getInt("userID"));
            
            }
            
            //count total blocked user  and save data
            //print all the user
        } catch (SQLException ex) {
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        }
       return result;
    }
    
    /*
    Generate the report on the basis of the user created in given date range
    */
    public ResultSet user_created_report(Date start, Date end){
              
       try {
            
       //start date and end date
    java.sql.Date startDate = new java.sql.Date(start.getTime());
    java.sql.Date endDate = new java.sql.Date(end.getTime());
       
            //query the database with two date
             result=(new FindUser()).user_created_in_a_date_range(startDate, endDate);
            //get the blocked user data
            while(result.next()){
                System.out.println(result.getInt("userID"));
            
            }
            
            //count total blocked user  and save data
            //print all the user
        } catch (SQLException ex) {
            Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
        } 
       return result;
    }
    
    public static void main(String[] args) throws ParseException {
        GenerateReport obj=new GenerateReport();
       
    }
}
