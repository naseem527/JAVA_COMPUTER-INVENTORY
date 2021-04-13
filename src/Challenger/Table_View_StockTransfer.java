/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Admin
 */
public class Table_View_StockTransfer extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Table_View_StockTransfer
     */
    public Table_View_StockTransfer() {
        initComponents();
         
    }
    public Table_View_StockTransfer(String msg,String date) {
        initComponents();
         jTextField2.setText(msg);
        jTextField5.setText(date);
       //  fillCompanyR() ;
        fillCompanyDivsionITOPR();
       //  fillDivisionR();
         jComboBox17.addItem("ON_TRANSIT");
        jComboBox17.addItem("RECIEVED");
        jComboBox17.addItem("REJECTED");
       // fillITOPR();
    }
    public void fillCompanyDivsionITOPR(){
    String sqlCompany = "SELECT * FROM company where company_Name !=''" ;
    String sqlDiv = "SELECT * FROM division_name WHERE iddivision_Name !=''";
    String sqlITUSer = "SELECT * FROM user_loginsecurity where user_name !=''" ;
        try{  //System.out.println("0");
        //Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sqlCompany);
    ResultSet rs=pst.executeQuery();
    PreparedStatement pst1=con.prepareStatement(sqlDiv);
    ResultSet rs1=pst1.executeQuery();
    PreparedStatement pst2=con.prepareStatement(sqlITUSer);
    ResultSet rs2=pst2.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox9.addItem(company_Name);

   // System.out.println("3");
    }
     while(rs1.next()){
 
String division_Name= rs1.getString("division_Name");
jComboBox10.addItem(division_Name);

   // System.out.println("3");
    }
    while(rs2.next()){
    String user_name= rs2.getString("user_name");
jComboBox1.addItem(user_name);}

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    
    
  /**   public void fillCompanyR(){
    String sql = "SELECT * FROM company where company_Name !=''" ;
        try{  //System.out.println("0");
        //Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox9.addItem(company_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillDivisionR(){
    String sql = "SELECT * FROM division_name WHERE iddivision_Name !=''";
        try{  //System.out.println("0");
    //    Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
             // + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String division_Name= rs.getString("division_Name");
jComboBox10.addItem(division_Name);
 
   // System.out.println("3");
    }

    }catch(Exception e){
        System.out.println("Error in filling combobox");}

    }
    public void fillITOPR(){
    String sql = "SELECT * FROM user_loginsecurity where user_name !=''" ;
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
      
  String user_name= rs.getString("user_name");
jComboBox1.addItem(user_name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }  */
public void ViewStockAll1(){
    String sql = "SELECT * FROM inventory_allocation where inventory_company='"+jTextField3.getText()+"' && Location_Status='ON_TRANSIT' ";
    
    try{ 
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
        //      + "user=root&password=527482");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}}
public void AllStockTrasfer_WriteExcel(){
 String sql = "SELECT * FROM inventory_transfer";
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
rowhead.createCell((short) 0).setCellValue(" id_transfer");
rowhead.createCell((short) 1).setCellValue(" inventory_sn");
rowhead.createCell((short) 2).setCellValue(" inventory_FromUser");
rowhead.createCell((short) 3).setCellValue(" inventory_ToCompany");
rowhead.createCell((short) 4).setCellValue("inventory_ToDiv");
rowhead.createCell((short) 5).setCellValue(" inventory_ToUser");
rowhead.createCell((short) 6).setCellValue("transfer_approvBy");
rowhead.createCell((short) 7).setCellValue(" Location_Status");
rowhead.createCell((short) 8).setCellValue(" IT_operationBy");

rowhead.createCell((short) 9).setCellValue(" Transcn_Start_date");
rowhead.createCell((short) 10).setCellValue("InitialTranscn_remark");
rowhead.createCell((short) 11).setCellValue(" Transcn_End_date");
rowhead.createCell((short) 12).setCellValue("recievORrjct_IT");
rowhead.createCell((short) 13).setCellValue(" recievORrjct_Remrk");

//rowhead.createCell((short) 3).setCellValue(" Salary");
int index=1;
while(rs.next()){
     System.out.println("02"); 
HSSFRow row = sheet.createRow((short)index);
row.createCell((short) 0).setCellValue(rs.getInt(1));
row.createCell((short) 1).setCellValue(rs.getString(2));
row.createCell((short) 2).setCellValue(rs.getString(3));

row.createCell((short) 3).setCellValue(rs.getString(4));
row.createCell((short) 4).setCellValue(rs.getString(5));
row.createCell((short) 5).setCellValue(rs.getString(6));
row.createCell((short) 6).setCellValue(rs.getString(7));
row.createCell((short) 7).setCellValue(rs.getString(8));
row.createCell((short) 8).setCellValue(rs.getString(9));
row.createCell((short) 9).setCellValue(rs.getString(10));
row.createCell((short) 10).setCellValue(rs.getString(11));
row.createCell((short) 11).setCellValue(rs.getString(12));
row.createCell((short) 12).setCellValue(rs.getString(13));
row.createCell((short) 13).setCellValue(rs.getString(14));

index++;
}
System.out.println("1");
FileOutputStream fileOut = new FileOutputStream("C:\\Reports1\\Complete_Stock_Transfer.xls");
System.out.println("2");
wb.write(fileOut);
fileOut.close();
Runtime rt = Runtime.getRuntime();
rt.exec("cmd.exe /C start C:\\Reports1\\Complete_Stock_Transfer.xls");
}
catch(Exception e){System.out.println("Exception in excel write");}



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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox();
        jComboBox10 = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox17 = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Report For tracking transfers");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Item Serial Number");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField3.setBackground(new java.awt.Color(204, 255, 255));
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Retrieve Transfer History");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Item Transfer History");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setBackground(new java.awt.Color(0, 102, 102));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Transfer Window Report - Choose filters below ");
        jLabel16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel11.setBackground(new java.awt.Color(0, 102, 102));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setBackground(new java.awt.Color(0, 102, 102));
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Reciever");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setBackground(new java.awt.Color(0, 102, 102));
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Company");

        jLabel20.setBackground(new java.awt.Color(0, 102, 102));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Division");

        jComboBox9.setForeground(new java.awt.Color(204, 255, 255));
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox9.setToolTipText("");
        jComboBox9.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox9ItemStateChanged(evt);
            }
        });
        jComboBox9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox9MouseClicked(evt);
            }
        });
        jComboBox9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox9ActionPerformed(evt);
            }
        });

        jComboBox10.setForeground(new java.awt.Color(204, 255, 255));
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox10.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox10ItemStateChanged(evt);
            }
        });
        jComboBox10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox10MouseClicked(evt);
            }
        });
        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox9, 0, 179, Short.MAX_VALUE)
                    .addComponent(jComboBox10, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel12.setBackground(new java.awt.Color(0, 102, 102));
        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setBackground(new java.awt.Color(0, 102, 102));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Frm IT Opr.");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox1.setForeground(new java.awt.Color(204, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jComboBox17.setForeground(new java.awt.Color(204, 255, 255));
        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox17.setToolTipText("");
        jComboBox17.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox17ItemStateChanged(evt);
            }
        });
        jComboBox17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox17MouseClicked(evt);
            }
        });
        jComboBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox17ActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(0, 102, 102));
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Transfer Status");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                                .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(19, 19, 19))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Table View Stock Transfer or Reception -Report");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 102, 102));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Go Home page");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 102, 102));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Current Status of Item");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Export Full Stock Transfer To Excel ");
        jButton4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(506, 506, 506)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(415, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(264, 264, 264)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(388, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
       jComboBox9.setSelectedIndex(0);
       jComboBox10.setSelectedIndex(0);
       jComboBox17.setSelectedIndex(0);
      jComboBox1.setSelectedIndex(0);
      jTextField4.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
      
        jTextField4.setText("");
       setLocationstatus(); 
        Viewhistory();
        
     //   jTextField1.setText("Where");
    }//GEN-LAST:event_jButton2MouseClicked

    private void jComboBox9ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox9ItemStateChanged
        // TODO add your handling code here:
      
      jComboBox9.actionPerformed(null);
     //   jComboBox10.setSelectedIndex(0);
      //  jComboBox17.setSelectedIndex(0);
      //  jComboBox1.setSelectedIndex(0);
       // transfertableC();
    }//GEN-LAST:event_jComboBox9ItemStateChanged

    private void jComboBox9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox9MouseClicked
        // TODO add your handling code here:
       
        
     //   jComboBox9.removeAllItems();
       // fillCompanyR() ;
       // transfertableC();
    }//GEN-LAST:event_jComboBox9MouseClicked

    private void jComboBox10ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox10ItemStateChanged
        // TODO add your handling code here:

       jComboBox10.actionPerformed(null);
       jComboBox17.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
    }//GEN-LAST:event_jComboBox10ItemStateChanged

    private void jComboBox10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox10MouseClicked
        // TODO add your handling code here:
       // jComboBox10.removeAllItems();
       
      //  fillDivisionR();
      //  transfertableCD();
    }//GEN-LAST:event_jComboBox10MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:

        transfertableCDSI();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:

      //  jComboBox1.removeAllItems();
       // fillITOPR();
        //transfertableCDSI();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox17ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox17ItemStateChanged
        // TODO add your handling code here:
      //  jComboBox1.setSelectedIndex(0);
      //  transfertableCDS();
        jComboBox17.actionPerformed(null);
    }//GEN-LAST:event_jComboBox17ItemStateChanged

    private void jComboBox17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox17MouseClicked
        // TODO add your handling code here:
      //  jComboBox17.removeAllItems();
       // jComboBox17.addItem("ON_TRANSIT");
       // jComboBox17.addItem("RECIEVED");
       // jComboBox17.addItem("REJECTED");
     //   transfertableCDS();
    }//GEN-LAST:event_jComboBox17MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        String   msg=jTextField2.getText();
        String date= jTextField5.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox9ActionPerformed
        // TODO add your handling code here:
      jTextField4.setText("");
        jTextField3.setText("");
        jComboBox10.setSelectedIndex(0);
        jComboBox17.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        transfertableC();
    }//GEN-LAST:event_jComboBox9ActionPerformed

    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        // TODO add your handling code here:
         jComboBox17.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
        transfertableCD();
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jComboBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox17ActionPerformed
        // TODO add your handling code here:
         jComboBox1.setSelectedIndex(0);
        transfertableCDS();
    }//GEN-LAST:event_jComboBox17ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        //AllStockTrasfer_WriteExcel();
        try {
            exportTable et=new exportTable();
            // TODO add your handling code here:
            et.exportTable(jTable1,new File("C:\\Reports1\\Stock_Transfer_Report.xls"));
            Runtime rt = Runtime.getRuntime();
rt.exec("cmd.exe /C start C:\\Reports1\\Stock_Transfer_Report.xls");
        } catch (IOException ex) {
            Logger.getLogger(Table_View_StockDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4MouseClicked
public void Viewhistory(){
     String sql = "SELECT inventory_transfer.id_transfer as 'Transaction Id',inventory_transfer.inventory_sn as 'Item Serial',inventory_transfer.inventory_FromUser as 'From User',inventory_transfer.inventory_ToUser as 'To User',inventory_transfer.IT_operationBy as 'Tranfr IT operator',inventory_transfer.transfer_approvBy as 'Approved Manager',inventory_transfer.recievORrjct_IT as 'reciev OR rjct_IT',inventory_transfer.Location_Status as 'Current Status',inventory_transfer.Transcn_Start_date as 'Transfr initiated On',inventory_transfer.Transcn_End_date as 'Transcn End On',inventory_transfer.recievORrjct_Remrk as 'Recv or Rjct Rmrk' FROM inv.reception_table right join inv.inventory_transfer on inv.reception_table.id_transfer=inv.inventory_transfer.id_transfer\n" +
"where inventory_sn='"+jTextField3.getText()+"'";
   
     try{ 
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}

}
public void transfertableC(){
     String sql = "SELECT inventory_transfer.id_transfer as 'Transaction Id',inventory_transfer.inventory_sn as 'Item Serial',inventory_transfer.inventory_FromUser as 'From User',inventory_transfer.inventory_ToUser as 'To User',inventory_transfer.IT_operationBy as 'Tranfr IT operator',inventory_transfer.transfer_approvBy as 'Approved Manager',inventory_transfer.recievORrjct_IT as  'recv/rejctd. IT operator',inventory_transfer.Transcn_Start_date as 'Transfr initiated On',inventory_transfer.Location_Status as 'Item Transfer Status',inventory_transfer.Transcn_End_date as 'recv/reject On',inventory_transfer.recievORrjct_Remrk as 'Recv or Rjct Rmrk' FROM inv.reception_table right join inv.inventory_transfer on inv.reception_table.id_transfer=inv.inventory_transfer.id_transfer\n" +
" where  inventory_transfer.inventory_ToCompany='"+jComboBox9.getSelectedItem()+"'";
   
     try{ 
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}
     
}
public void transfertableCD(){
     String sql = "SELECT inventory_transfer.id_transfer as 'Transaction Id',inventory_transfer.inventory_sn as 'Item Serial',inventory_transfer.inventory_FromUser as 'From User',inventory_transfer.inventory_ToUser as 'To User',inventory_transfer.IT_operationBy as 'Tranfr IT operator',inventory_transfer.transfer_approvBy as 'Approved Manager',inventory_transfer.recievORrjct_IT as  'recv/rejctd. IT operator',inventory_transfer.Transcn_Start_date as 'Transfr initiated On',inventory_transfer.Location_Status as 'Item Transfer Status',inventory_transfer.Transcn_End_date as 'recv/reject On',inventory_transfer.recievORrjct_Remrk as 'Recv or Rjct Rmrk' FROM inv.reception_table right join inv.inventory_transfer on inv.reception_table.id_transfer=inv.inventory_transfer.id_transfer\n" +
" where  inventory_transfer.inventory_ToCompany='"+jComboBox9.getSelectedItem()+"' && inventory_transfer.inventory_ToDiv='"+jComboBox10.getSelectedItem()+"' ";
   
     try{ 
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
        //      + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}
     
}

public void transfertableCDS(){
     String sql = "SELECT inventory_transfer.id_transfer as 'Transaction Id',inventory_transfer.inventory_sn as 'Item Serial',inventory_transfer.inventory_FromUser as 'From User',inventory_transfer.inventory_ToUser as 'To User',inventory_transfer.IT_operationBy as 'Tranfr IT operator',inventory_transfer.transfer_approvBy as 'Approved Manager',inventory_transfer.recievORrjct_IT as  'recv/rejctd. IT operator',inventory_transfer.Transcn_Start_date as 'Transfr initiated On',inventory_transfer.Location_Status as 'Item Transfer Status',inventory_transfer.Transcn_End_date as 'recv/reject On',inventory_transfer.recievORrjct_Remrk as 'Recv or Rjct Rmrk' FROM inv.reception_table right join inv.inventory_transfer on inv.reception_table.id_transfer=inv.inventory_transfer.id_transfer\n" +
" where inventory_transfer.inventory_ToCompany='"+jComboBox9.getSelectedItem()+"' && inventory_transfer.inventory_ToDiv='"+jComboBox10.getSelectedItem()+"' &&  inventory_transfer.Location_Status='"+jComboBox17.getSelectedItem()+"'  ";
   
     try{ 
  //      Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}
     
}
public void transfertableCDSI(){
     String sql = "SELECT inventory_transfer.id_transfer as 'Transaction Id',inventory_transfer.inventory_sn as 'Item Serial',inventory_transfer.inventory_FromUser as 'From User',inventory_transfer.inventory_ToUser as 'To User',inventory_transfer.IT_operationBy as 'Tranfr IT operator',inventory_transfer.transfer_approvBy as 'Approved Manager',inventory_transfer.recievORrjct_IT as  'recv/rejctd. IT operator',inventory_transfer.Transcn_Start_date as 'Transfr initiated On',inventory_transfer.Location_Status as 'Item Transfer Status',inventory_transfer.Transcn_End_date as 'recv/reject On',inventory_transfer.recievORrjct_Remrk as 'Recv or Rjct Rmrk' FROM inv.reception_table right join inv.inventory_transfer on inv.reception_table.id_transfer=inv.inventory_transfer.id_transfer\n" +
" where inventory_transfer.inventory_ToCompany='"+jComboBox9.getSelectedItem()+"' && inventory_transfer.inventory_ToDiv='"+jComboBox10.getSelectedItem()+"' &&  inventory_transfer.Location_Status='"+jComboBox17.getSelectedItem()+"' &&  inventory_transfer.IT_operationBy='"+jComboBox1.getSelectedItem()+"'  ";
   
     try{ 
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
            //  + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
   
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){System.out.println("Error in filling jTable1 -(View all Table)");}
     
}
public void setLocationstatus(){
     String sql1 = "SELECT inventory_allocation.Location_Status from inventory_allocation where inventory_allocation.inventory_sn='"+jTextField3.getText()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Location_Status");
   jTextField4.setText(x);
   }
    

    }catch(Exception e){
         jTextField4.setText("");
        System.out.println("Item not found)");}

}

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
            java.util.logging.Logger.getLogger(Table_View_StockTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table_View_StockTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table_View_StockTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table_View_StockTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Table_View_StockTransfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox17;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
