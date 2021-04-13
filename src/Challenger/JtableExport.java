/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

/**
 *
 * @author Admin
 */

    

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

class Form extends JFrame{
    ResultSet rs;
    Form(){
    final Vector columnNames = new Vector();
        final Vector data = new Vector();
        JButton button=new JButton("Export");
    JPanel panel=new JPanel();
    JPanel panel1=new JPanel();
    JPanel panel2=new JPanel();
      try{
    Connection con = null;
    Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "527482");
        Statement st = con.createStatement();
        rs= st.executeQuery("Select * from company");
    ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++) {
columnNames.addElement( md.getColumnName(i) );
}
while (rs.next()) {
Vector row = new Vector(columns);
for (int i = 1; i <= columns; i++) {
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
}
catch(Exception e){}
JTable table = new JTable(data, columnNames);
JScrollPane scrollPane = new JScrollPane(table);
panel1.add(scrollPane);
panel2.add(button);
panel.add(panel1);
panel.add(panel2);
add(panel);
button.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ev){
try{
Connection con = null;
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "527482");
Statement st = con.createStatement();
rs= st.executeQuery("Select * from company");
HSSFWorkbook wb = new HSSFWorkbook();
HSSFSheet sheet = wb.createSheet("Excel Sheet");
HSSFRow rowhead = sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue(" comp_id");
rowhead.createCell((short) 1).setCellValue(" company_Name");
rowhead.createCell((short) 2).setCellValue(" company_Remark");
//rowhead.createCell((short) 3).setCellValue(" Salary");
int index=1;
while(rs.next()){
HSSFRow row = sheet.createRow((short)index);
row.createCell((short) 0).setCellValue(rs.getInt(1));
row.createCell((short) 1).setCellValue(rs.getString(2));
row.createCell((short) 2).setCellValue(rs.getString(3));
//row.createCell((short) 3).setCellValue(rs.getInt(4));
index++;
}
System.out.println("Error before file out");
FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Admin\\Desktop\\clinic\\Hello.xls");
System.out.println("Error after file out");
wb.write(fileOut);
fileOut.close();
Runtime rt = Runtime.getRuntime();
rt.exec("cmd.exe /C start C:\\Users\\Admin\\Desktop\\clinic\\Hello.xls");
}
catch(Exception e){System.out.println("Exception in excel write");}
}
});
}
}
 class JtableExport {
  public static void main(String arg[])
  {
    try
    {
    Form frame=new Form();
    frame.setSize(450,200);
    frame.setVisible(true);
    }
  catch(Exception e)
    {}
  }
}