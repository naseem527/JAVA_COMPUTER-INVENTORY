/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;
import Challenger.sqlconnect.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class menuSecurity {
   
    public String menuSecurity(String name1,int menuid1) {
        
         String sql= "SELECT * FROM inventory.user_menusecurity where name='"+name1+"' && access_modules_id='"+menuid1+"'";
        //    + "&& access_modules_id='menuid')";
      System.out.println(sql);
   try{Class.forName("com.mysql.jdbc.Driver"); 
        
     //    Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
   sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();


 System.out.println(333);
while(rs.next()){
 String x=rs.getString("Acess_Status");
 System.out.println(x);
 return x;
   }}
   catch(Exception e){
       System.out.println(444);
     JOptionPane.showMessageDialog(null,
   "Stopping the Menu Item \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);}
   return null; 
    }
    
}
