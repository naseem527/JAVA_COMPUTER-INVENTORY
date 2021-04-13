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
public class user_menuAssigning {
 
    
    public void user_menuAssigning(String name){
    try{
       
       //  Class.forName("com.mysql.jdbc.Driver"); 
        
      //   Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");
   sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();       
         Statement stat= con.createStatement();
         System.out.println("DB connection OKey in MySQL0");
  
 stat = con.createStatement();
   System.out.println("DB connection OKey in MySQL1");

   
String sql1 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','1','M1- Company / Division Add')";
String sql2 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','2','M2- User / Department  Add')";
String sql3 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','3','M3-Item Type / Brand  Add')";
String sql4 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','4','M4-Master Management -Access')";
String sql6 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','6','R1- Inventory Stock Report')";
String sql7 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','7','R2- Inventory Transfer Report')";

        String sql8 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','8','R3- Master_ALLData_FromDB-Report')";
String sql11 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','11','F1-Inventory item add page')";
String sql12 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','12','F2-Item Allocation Updation Page')";
String sql13 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','13','F3-Item Deletion/Writeoff Page')";
String sql14 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','14','F4-Item  Transfer  Page')";
String sql15 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','15','F5-Inventory item Recieption Page')";
String sql21 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','21','S1-IT User Security & Assign')";
String sql22 = "INSERT INTO user_menusecurity(name,access_modules_id,access_module_Name) " +
           "VALUES ('"+name+"','22','S2-Company & Division Assign')";

  System.out.println("DB connection OKey in MySQL2.1");
      stat.executeUpdate(sql1); 
       stat.executeUpdate(sql2); 
        stat.executeUpdate(sql3); 
         stat.executeUpdate(sql4); 
         stat.executeUpdate(sql6); 
          stat.executeUpdate(sql7);
          stat.executeUpdate(sql8); 
           stat.executeUpdate(sql11); 
       stat.executeUpdate(sql12); 
        stat.executeUpdate(sql13); 
         stat.executeUpdate(sql14); 
          stat.executeUpdate(sql15);
               stat.executeUpdate(sql21);
                 stat.executeUpdate(sql22);
     System.out.println(""+ "2.2");
JOptionPane.showMessageDialog(null,
   "Success!!!   User succesfully assigned to menu access \n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
 

 }
       catch(Exception e){
        
          
          JOptionPane.showMessageDialog(null,
   "Failed! Error while USER assigning for menu access ,contact software designer \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);

           System.out.println("DB connection Error1");}
        
    
        
        
 
}
    
    
    }

