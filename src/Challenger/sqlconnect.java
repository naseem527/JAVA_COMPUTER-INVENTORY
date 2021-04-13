/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class sqlconnect {public  Statement stat2;
   public Statement sqlconnect_stat(){
  try{  Class.forName("com.mysql.jdbc.Driver"); 
        
         Connection con3 = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/inventory?"
              + "user=root&password=527482");
         
        stat2= con3.createStatement();
     
     System.out.println("SQL Connection for database access");

  return stat2;
  
      
 

 }
       catch(Exception e){
                         
          JOptionPane.showMessageDialog(null,
   "Database Failed To connect,Contact your IT Department \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
       
       
       }
    return null;
        
}
          
  public Connection sqlconnect_con(){
  try{  Class.forName("com.mysql.jdbc.Driver"); 
        
         Connection con3 = DriverManager
        .getConnection("jdbc:mysql://localhost:3306/inventory?"
              + "user=root&password=527482");
         
        stat2= con3.createStatement();
     
     System.out.println("SQL Connection for database access");

  return con3;
  
      
 

 }
       catch(Exception e){
                         
          JOptionPane.showMessageDialog(null,
   "DB connection Error\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
          }
    return null;
        
}
          
}

