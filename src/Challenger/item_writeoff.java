/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Admin
 */
public class item_writeoff extends javax.swing.JFrame {

    /**
     * Creates new form item_writeoff
     */
    public item_writeoff() {
        initComponents();
    }
 public item_writeoff(String msg,String date) {
        initComponents();
         jTextField6.setText(msg);
        jTextField7.setText(date);
     //    fillApprovedBy();
        //  fillCompany();
         // fillDivision();
        fillALLTogether();
    }
 
 public void fillALLTogether(){
    String sql = "SELECT * FROM company where company_Name !=''" ;
     String sql1 = "SELECT * FROM division_name WHERE iddivision_Name !=''";
     String sql2 = "SELECT * FROM user_master where user_Name !=''" ;
        try{  //System.out.println("0");
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox2.addItem(company_Name);
   // System.out.println("3");
    }
     PreparedStatement pst1=con.prepareStatement(sql1);
    ResultSet rs1=pst1.executeQuery();
  //int y=0;   //System.out.println("2");
    while(rs1.next()){
       String division_Name= rs1.getString("division_Name");
jComboBox3.addItem(division_Name);
 
   // System.out.println("3");
    }
    PreparedStatement pst2=con.prepareStatement(sql2);
    ResultSet rs2=pst2.executeQuery();
  //int y=0;   //System.out.println("2");
    while(rs2.next()){
      
  String user_Name= rs2.getString("user_Name");
jComboBox4.addItem(user_Name);
   // System.out.println("3");
    }


    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
 
 public void stockupdateforWriteoff(){
  try{  
    // Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
      //       + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update inventory_allocation set Location_Status='WRITE_OFF' where inventory_sn='"+jTextField5.getText()+"' ";
       
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " SUCCESS!!! Entered item '" +jTextField5.getText()+ "' is succesfully reflected in stock table for Write OFF ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(Exception e){
JOptionPane.showMessageDialog(null,
   "ATTENTION!  Entered item '" +jTextField5.getText()+ "' is failed to reflect in stock table for WRITE OFF process,Contact IT ","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField5.setText(" ");

}}
 public void ViewStockAll1(){
   String sql = "SELECT  inventory_allocation.inventory_sn,writeoff.idwriteoff as 'Write_OFF Process Id',writeoff.writeOff_DoneBy,writeoff.writeOff_Date as 'Write Off done On',inventory_allocation.inventory_company as 'items Last Company',inventory_allocation.inventory_division as 'items Last Division',inventory_allocation.inventory_allotUser as 'items Last User' FROM inv.writeoff inner join inv.inventory_allocation  on  writeoff.inventory_sn=inventory_allocation.inventory_sn "
      + "where inventory_allocation.Location_Status='WRITE_OFF' && inventory_allocation.inventory_company='"+jComboBox2.getSelectedItem()+"' &&"
           + "inventory_allocation.inventory_division='"+jComboBox3.getSelectedItem()+"'";
          
    
    try{ 
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}

}
 public void ViewStockAll2(){
   String sql = "SELECT  inventory_allocation.inventory_sn,writeoff.idwriteoff as 'Write_OFF Process Id',writeoff.writeOff_DoneBy,writeoff.writeOff_Date as 'Write Off done On',inventory_allocation.inventory_company as 'items Last Company',inventory_allocation.inventory_division as 'items Last Division',inventory_allocation.inventory_allotUser as 'items Last User' FROM inv.writeoff inner join inv.inventory_allocation  on  writeoff.inventory_sn=inventory_allocation.inventory_sn "
      + "where inventory_allocation.Location_Status='WRITE_OFF' && inventory_allocation.inventory_company='"+jComboBox2.getSelectedItem()+"'";
          
    
    try{ 
     //   Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}

}
 /*public void fillCompany(){
    String sql = "SELECT * FROM company where company_Name !=''" ;
        try{  //System.out.println("0");
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox2.addItem(company_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillDivision(){
    String sql = "SELECT * FROM division_name WHERE iddivision_Name !=''";
        try{  //System.out.println("0");
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String division_Name= rs.getString("division_Name");
jComboBox3.addItem(division_Name);
 
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillApprovedBy(){
    String sql = "SELECT * FROM user_master where user_Name !=''" ;
        try{  //System.out.println("0");
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String user_Name= rs.getString("user_Name");
jComboBox4.addItem(user_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }*/
 public void senderfill(){
   
    String sql = "SELECT * FROM inventory_allocation where inventory_sn='"+jTextField5.getText()+"' && Location_Status='ON_STOCK'";
System.out.println(1);    
//if(sql.isEmpty()){System.out.println("empty");}
    try{  
        
      //  Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");System.out.println("2");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
 // System.out.println(pst); 
  ResultSet rs1= pst.executeQuery();
 if( rs1.next()==false){
     JOptionPane.showMessageDialog(null,
   " Entered item ' "+jTextField5.getText()+" ' is not present in stock (in STOCK table) on specified location\n,Check report of inventory stock details\n OR \n Previous Write off reports","Inane warning",
    JOptionPane.ERROR_MESSAGE);
     jTextField1.setText("");
     jTextField2.setText("");
     jTextField3.setText("");
     jTextField4.setText("");
     
     }
  
  ResultSet rs=pst.executeQuery();
   //System.out.println(rs); 
     System.out.println("3");
    while(rs.next()){ System.out.println("4");
       String  Location_Status1=rs.getString("Location_Status");
       System.out.println(Location_Status1);
if(    "ON_TRANSIT".equals(Location_Status1)||"WRITE_OFF".equals(Location_Status1)){int y=0/0;}
    //  String inventory_sn= rs.getString("inventory_sn");
   // System.out.println("3");
//jTextField6.setText(inventory_sn);
  String inventory_company= rs.getString("inventory_company");
jTextField2.setText(inventory_company);
 String inventory_division= rs.getString("inventory_division");
jTextField3.setText(inventory_division);
 String inventory_allotUser= rs.getString("inventory_allotUser");
jTextField1.setText(inventory_allotUser);
String inventory_areaAlloted= rs.getString("inventory_areaAlloted");
jTextField4.setText(inventory_areaAlloted);
//System.out.println(""+inventory_company);
 // System.out.println("3");
   
     }
    //int x=7/0;
   
    }
  catch(Exception e){ JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is already in transfer to other location,Check report of inventory transfer for details","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");
  }
       

}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("           Write Off page");

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item SN");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item current User");

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Item curnt compny");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 102, 102));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Item curnt Div.");

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Item curnt Department");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Select");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WRITE_OFF" }));

        jLabel12.setBackground(new java.awt.Color(0, 102, 102));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Action");

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 102, 102));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox4.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Approved By");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jTextField5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home Page ");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Write Off", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Write OFF Table ");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Select Filter");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox2.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });
        jComboBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox3MouseClicked(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Export item WriteOFF");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void insertToWriteOff(){
try{sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
String sql = "INSERT INTO writeoff( inventory_sn,writeOff_DoneBy,writeOff_Date,WriteOff_permission,Location_Status) " +
       "VALUES ('"+jTextField5.getText()+"','"+jTextField6.getText()+"','"+jTextField7.getText()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox1.getSelectedItem()+"')";
  stat.executeUpdate(sql);  
   JOptionPane.showMessageDialog(null,
   "SUCCESS!!! Entered item '" +jTextField5.getText()+ "' is added to write off table","plain message",
    JOptionPane.PLAIN_MESSAGE);
}catch(Exception e){
 JOptionPane.showMessageDialog(null,
   " ATTENTION! Entered item '" +jTextField5.getText()+ "' maybe  already write off ,Check report of write off table for details","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}


}

public void writeOff_WriteExcel(){
 String sql = "SELECT * FROM writeoff";
try{
Connection con = null;
sqlconnect sc=new sqlconnect();
      Connection con1= sc.sqlconnect_con();
      System.out.println("0"); 
  PreparedStatement pst=con1.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
HSSFWorkbook wb = new HSSFWorkbook();
HSSFSheet sheet = wb.createSheet("Excel Sheet");
 System.out.println("01"); 
HSSFRow rowhead = sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue(" idwriteoff");
rowhead.createCell((short) 1).setCellValue(" inventory_sn");
rowhead.createCell((short) 2).setCellValue(" writeOff_DoneBy");
rowhead.createCell((short) 3).setCellValue(" writeOff_Date");
rowhead.createCell((short) 4).setCellValue(" WriteOff_permission");

int index=1;
while(rs.next()){
     System.out.println("02"); 
HSSFRow row = sheet.createRow((short)index);
row.createCell((short) 0).setCellValue(rs.getInt(1));
row.createCell((short) 1).setCellValue(rs.getString(2));
row.createCell((short) 2).setCellValue(rs.getString(3));
row.createCell((short) 3).setCellValue(rs.getString(4));
row.createCell((short) 4).setCellValue(rs.getString(5));
index++;
}
System.out.println("1");
FileOutputStream fileOut = new FileOutputStream("C:\\Reports1\\Write_OFF_Report.xls");
System.out.println("2");
wb.write(fileOut);
fileOut.close();
Runtime rt = Runtime.getRuntime();
rt.exec("cmd.exe /C start C:\\Reports1\\Write_OFF_Report.xls");
}
catch(Exception e){System.out.println("Exception in excel write");}



}


public void checkaccess() throws Exception{
  String sql = "SELECT * FROM user_ittranscnprevilege where AllowedCompany='"+jTextField2.getText()+"' && AllowedDivision='"+jTextField3.getText()+"' && It_User='"+jTextField6.getText()+"'";
             
try{sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
ResultSet rs=stat.executeQuery(sql);
if(rs.next()==false){
    JOptionPane.showMessageDialog(null,
   " Please ! Entered item '" +jTextField5.getText()+ "' is not authorized for you to Write_OFF,Check system manager","Inane warning",
    JOptionPane.ERROR_MESSAGE);
    
int y=0/0;
}

}catch(SQLException e){}

}


    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
          String   msg=jTextField6.getText();
      String date= jTextField7.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
      
        senderfill();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    if(jComboBox4.getSelectedItem()=="Please Select"){
            JOptionPane.showMessageDialog(null,
   "Kindly Select Approved By & resubmit\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
            int y=0/0;}

    
    
       try{      checkaccess();
           
           String x=jTextField5.getText();
     String z=jTextField1.getText();
     
      //   System.out.println("comb6"+a);    
        if("".equals(x)||"".equals(z)){int y=0/0;}
        
        
         insertToWriteOff();
   stockupdateforWriteoff();
       JOptionPane.showMessageDialog(null,
   "item serial number '" +jTextField5.getText()+ "' write off process is done ' "
           + " ","plane message",
    JOptionPane.INFORMATION_MESSAGE);
      jTextField1.setText("");
      jTextField2.setText("");
      jTextField5.setText("");
      jTextField4.setText("");
       jTextField3.setText("");
    jComboBox4.removeAllItems();
     jComboBox1.removeAllItems();
         }catch(Exception e){JOptionPane.showMessageDialog(null,
   "item serial number '" +jTextField5.getText()+ "' not write off\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
           jTextField1.setText("");
      jTextField2.setText("");
      jTextField5.setText("");
      jTextField4.setText("");
       jTextField3.setText("");
        jComboBox4.removeAllItems();
     jComboBox1.removeAllItems();
         
         
         } 
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
        //  ViewStockAll1();
      //   jComboBox2.setSelectedIndex(0);
       //  ViewStockAll2();
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
        // TODO add your handling code here:
     //  jComboBox3.removeAllItems(); 
      
      //  fillDivision();
      //  ViewStockAll1();
    }//GEN-LAST:event_jComboBox3MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
                     jComboBox3.setSelectedIndex(0);
            ViewStockAll2();
          
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
          ViewStockAll1();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
        // TODO add your handling code here:
      //  fillApprovedBy();
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        //writeOff_WriteExcel();
         try {
            exportTable et=new exportTable();
            // TODO add your handling code here:
            et.exportTable(jTable1,new File("C:\\Reports1\\WriteOFF_Master_Report.xls"));
            Runtime rt = Runtime.getRuntime();
rt.exec("cmd.exe /C start C:\\Reports1\\WriteOFF_Master_Report.xls");
        } catch (IOException ex) {
            Logger.getLogger(Table_View_StockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(item_writeoff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(item_writeoff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(item_writeoff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(item_writeoff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new item_writeoff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables

    private static class SQLExceptoin {

        public SQLExceptoin() {
        }
    }
}
