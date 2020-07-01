/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.com.hellomegha.testing;

import com.hellomegha.databasequeries.BlockUser;
import com.hellomegha.databasequeries.DatabaseConnection;
import com.hellomegha.databasequeries.DeleteRecord;
import com.hellomegha.databasequeries.FindUser;
import com.hellomegha.databasequeries.InsertRecord;
import com.hellomegha.databasequeries.UpdateRecord;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author wanu
 */
public class DataBaseUnitTesting {
    //create DatabaseConnection
    Connection connection=null;
    FindUser user=null;
    UpdateRecord update=null;
    InsertRecord insert=null;
    DeleteRecord delete=null;
    BlockUser block=null;
    
    public DataBaseUnitTesting() {
        connection=(new DatabaseConnection()).makeConnection();
        user= new FindUser();
        insert=new InsertRecord();
        update=new UpdateRecord();
        delete=new DeleteRecord();
        block=new BlockUser();
    }

     @Test
    public void crud_userRegistration_table() throws SQLException{
        try{
     
        connection.setAutoCommit(false);    //begin transaction
    //create connection
            //C: Create user
            String udata[]={"Testa","password","email@1","977980980"};
            String udata2[]={"Testb","password2","email@2","977980981"};
            String udata3[]={"Testc","password3","email@3","977980982"};
        
        boolean createU=insert.intoUserRegistration(udata[0], udata[1], udata[2], udata[3]);
        boolean createU2=insert.intoUserRegistration(udata2[0], udata2[1], udata2[2], udata2[3]);
        boolean createU3=insert.intoUserRegistration(udata3[0], udata3[1], udata3[2], udata3[3]);
      
        //checks if the user creation is successfull 
        assertTrue(createU);
        assertTrue(createU2);
        assertTrue(createU3);
        
  
    //R: Read User table data
//         ResultSet result=user.getUser(udata[0]);
//         assertFalse(result.next()==false); //tests if the  resultSet contain values or no
//              while(result.next()){
//                     assertEquals("Testa", result.getString("username")); //tests if the  resultSet contain values or no
//                     assertEquals("password", result.getString("password"));
//                       assertEquals("email@1", result.getString("email"));
//                         assertEquals("977980980", result.getString("977980980"));
//                         
//                         /**
//                          create history and check if the history creation is successful
//                          **/
//                       assertTrue(crud_userHistory_table(result.getInt("userID")),"History creation");
//                      fail("ddd");
//      
//              }
       //3:Update
        boolean updateR=update.updateUsername("Testa","update");
            
       //4:delete
       boolean deleted=delete.deleteUser("update");
       assertTrue(deleted);
        
        boolean deletedb=delete.deleteUser("Testb");
       assertTrue(deletedb);
        
        boolean deletedc=delete.deleteUser("Testc");
       assertTrue(deletedc);
       
        
        }catch(Exception e){   
        }
         
         finally {
             connection.rollback();
              connection.close();
  }  
    }
//    
     public boolean crud_userHistory_table(int id){
        try {//create connection
                    return insert.intoUserHistory(id,"Testing");
        } catch (SQLException ex) {
          
        }
        return false;
        
        //user record is deleted on user deletion
    }
     
     @Test
     public void check_user_history_data(){
        try {
            //check for the userhistory verification
            boolean test=(user. userHistoryTableRecord()).next() ==false;
            assertTrue(test, "user history exist");
        } catch (SQLException ex) {
          
        }
     }

  @Test
    public void admin_table(){
//      
          try {
              //R:checks if the admin created while initializzation is success       
              boolean test=(user. adminTableRecord()).next()==false;
            assertFalse(test, "Admin record doesnot exist");
        } catch (SQLException ex) {
          
        }
//        
   }
//     
   @Test
    public void crud_blockedUser_table() throws SQLException{
       
              connection.setAutoCommit(false);    //begin transaction
    //create connection
            //C: Create user
            String udata[]={"Testa","password","email@1","977980980"};
           
        
        boolean createU=insert.intoUserRegistration(udata[0], udata[1], udata[2], udata[3]);
       
      
        //checks if the user creation is successfull 
        assertTrue(createU,"ucreated");
          
  
    //R: Read User table data
         ResultSet result=user.getUser(udata[0]);
         assertEquals(true, result.next()); //tests if the  resultSet contain values or no
             
//                    
//                     /**
//                      block user
//                      * 
//                      **/
//                     assertTrue(block.blockUser(result.getString("username")));
//                     
//                     /**
//                      check user blocked database
//                      ***/
//                     ResultSet isBlocked=user.blockedUser(result.getString("username"));
//                        boolean isb=isBlocked.next() == true;
//                        assertTrue(isb);
//                     /**
//                      unblock user
//                      **/
//                      assertTrue(block.unblockUser(result.getString("username")));
//                      fail("dsdd");
//                      /**
//                      check user blocked database
//                      ***/
//                      ResultSet isUnblocked=user.blockedUser(result.getString("username"));
//                        boolean isab=isUnblocked.next() == true;
//                        assertTrue(isab);
//              
       
       //4:delete
       boolean deleted=delete.deleteUser("Testa");
       assertTrue(deleted);
       
        
        
             connection.rollback();
              connection.close();
    
    }
    
//    @Test
//    public void crud_adminHistory_table(){
//    //create connection
//    //
//        
//    }
}
