/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Date2 {
 String dateget(){
    Calendar now = Calendar.getInstance();
     SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
     String now2=sdf.format(now.getTime()); 
 return now2;}
long Date1(){
long millis=System.currentTimeMillis();  
java.sql.Date date=new java.sql.Date(millis);  
System.out.println(date);  
return millis;

}
}
