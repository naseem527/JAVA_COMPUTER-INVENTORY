/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

import Challenger.Inventory_Mainpage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Item_Recieption extends javax.swing.JFrame {

    /**
     * Creates new form Item_Recieption
     */
    public Item_Recieption() {
        initComponents();
    }
     public Item_Recieption(String msg,String date,String sn)  {              
         initComponents();
         jTextField1.setText(msg);
        jTextField16.setText(date);
        jTextField4.setText(sn);
        filldepartment();
    }
     public void clear1()
     {
          jTextField3.setText(""); 
      jTextField4.setText("");  
      jTextField14.setText("");
     jTextField8.setText(""); 
     jTextField9.setText("");   
     jTextField10.setText(""); 
     jTextField11.setText("");   
     jTextField12.setText(""); 
         jTextField5.setText("");
          jTextField6.setText(""); 
     jTextField7.setText("");   
     jTextField13.setText(""); 
         jTextField17.setText("");
         jComboBox1.removeAllItems();
    
     
     
     }
public void rejectupdate(){
    try{  
       // Connection con = DriverManager
        //.getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");System.out.println("000");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
                   Statement st=con.createStatement();
              String query = "update inventory_allocation set Location_Status='ON_STOCK' where inventory_sn='"+jTextField4.getText()+"'";
 String query1 = "update inventory_transfer set Location_Status='REJECTED' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'"; 
  String query2="update inventory_transfer set Transcn_End_date='"+jTextField16.getText()+"' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'";
  String query3="update inventory_transfer set recievORrjct_IT='"+jTextField1.getText()+"' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'"; 
 String query4="update inventory_transfer set recievORrjct_Remrk='"+jTextField2.getText()+"' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'"; 
  //   System.out.println("1111"+query);
      
st.executeUpdate(query);
st.executeUpdate(query1);
st.executeUpdate(query2);
  st.executeUpdate(query3);
st.executeUpdate(query4);  
    }catch(Exception e){
System.out.println("Error");

}

}
public void sendfill(){
   
    String sql = "SELECT * FROM inventory_allocation where inventory_sn='"+jTextField4.getText()+"' && Location_Status='ON_TRANSIT'";
System.out.println(1);    
//if(sql.isEmpty()){System.out.println("empty");}
    try{  
        
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");System.out.println("2");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
 // System.out.println(pst); 
    ResultSet rs=pst.executeQuery();
   //System.out.println(rs); 
      boolean g=rs.next();
      if(g==false){int y=0/0;}
   ResultSet rs1=pst.executeQuery(); 
    while(rs1.next()){
   
      
   

  String inventory_company= rs1.getString("inventory_company");
jTextField8.setText(inventory_company);
 String inventory_division= rs1.getString("inventory_division");
jTextField9.setText(inventory_division);
 String inventory_allotUser= rs1.getString("inventory_allotUser");
jTextField14.setText(inventory_allotUser);
//System.out.println(""+inventory_company);
 // System.out.println("3");
   
    }
    //int x=7/0;
   
    }
  catch(Exception e){ JOptionPane.showMessageDialog(null,
   " Entered item is not in transferred from any location or already receieved before,check Stock report","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");
    jTextField8.setText("");
     jTextField9.setText("");
      jTextField14.setText("");
  }
       

}
 public void filldepartment(){
    String sql = "SELECT * FROM department WHERE department_Name !=''";
        try{  //System.out.println("0");
       // Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String department_Name= rs.getString("department_Name");
jComboBox1.addItem(department_Name);
 
    System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}
     }

public void recieverinfofromsender(){
    
String sql = "SELECT * FROM inventory_transfer where  Location_status='ON_TRANSIT' && inventory_sn='"+jTextField4.getText()+"'";
System.out.println(1+sql);    
//if(sql.isEmpty()){System.out.println("empty");}
    try{  
        
        //Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
        //      + "user=root&password=527482");System.out.println("2");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery(); System.out.println("3");
 // System.out.println(rs.next());
   while(rs.next()){
   System.out.println("4");
  String inventory_ToCompany= rs.getString("inventory_ToCompany");
jTextField10.setText(inventory_ToCompany);
 String inventory_ToDiv= rs.getString("inventory_ToDiv");
jTextField11.setText(inventory_ToDiv);
 String inventory_ToUser= rs.getString("inventory_ToUser");
jTextField12.setText(inventory_ToUser);
//System.out.println(""+inventory_company);
 // System.out.println("3");
String IT_operationBy= rs.getString("IT_operationBy");
   jTextField5.setText(IT_operationBy);
 String transfer_approvBy= rs.getString("transfer_approvBy");
jTextField6.setText(transfer_approvBy);
String InitialTranscn_remark= rs.getString("InitialTranscn_remark");
jTextField7.setText(InitialTranscn_remark);
  String Transcn_Start_date= rs.getString("Transcn_Start_date");
jTextField17.setText(Transcn_Start_date);
  int id_transfer= rs.getInt("id_transfer");
String id1=String.valueOf(id_transfer);
System.out.println("id"+id_transfer);
   jTextField13.setText(id1);
   }
    //int x=7/0;
   
    }
  catch(Exception e){ JOptionPane.showMessageDialog(null,
   " Nas on experiment","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");
    jTextField8.setText("");
     jTextField9.setText("");
      jTextField14.setText("");
  }
       

}
public void storeaccept(){

 try{//sqlconnect sc=new sqlconnect();
  // statement4= sc.sqlconnect1();
    // Class.forName("com.mysql.jdbc.Driver"); 
        
     //    Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
                Statement statement4= con.createStatement();
          System.out.println("george cheriyan 3");
  String sql = "INSERT INTO reception_table( id_transfer,rcvd_FromCompany,rcvd_FromDivisn,rcvd_ToDepartment) " +
           "VALUES ('"+jTextField13.getText()+"','"+jTextField8.getText()+"','"+jTextField9.getText()+"','"+jComboBox1.getSelectedItem()+"')";
  System.out.println("2");
 
  statement4.executeUpdate(sql); 
   // statement4.executeUpdate(sql2); 
  JOptionPane.showMessageDialog(null,
   "Updated storeaccept fn. in stock reception table & transfer table\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
   System.out.println("3");
    }catch(Exception e){
       System.out.println("Err");
    JOptionPane.showMessageDialog(null,
   "Failed storeaccept in stock stock reception & transfer table\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);}
}





public void acceptupdate(){
    try{  
       // Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");System.out.println("000");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
            Statement st=con.createStatement();
              String query1 = "update inventory_allocation set Location_Status='ON_STOCK' where inventory_sn='"+jTextField4.getText()+"'";
            //  String query22 = "update inventory_allocation set inventory_allotUser='"+jTextField12.getText()+"' where inventory_sn='"+jTextField4.getText()+"'";
              System.out.println("111");
 String query2 = "update inventory_allocation set inventory_company='"+jTextField10.getText()+"' where inventory_sn='"+jTextField4.getText()+"'";
 String query3 = "update inventory_allocation set inventory_division='"+jTextField11.getText()+"' where inventory_sn='"+jTextField4.getText()+"'";
String query4 = "update inventory_allocation set inventory_allotUser='"+jTextField12.getText()+"' where inventory_sn='"+jTextField4.getText()+"'"; 
String query5 = "update inventory_allocation set inventory_areaAlloted='"+jComboBox1.getSelectedItem()+"' where inventory_sn='"+jTextField4.getText()+"'";    
//String query4 = "update inventory_allocation set inventory_allotUser='"+jComboBox3.getSelectedItem()+"' where inventory_sn='"+jTextField4.getText()+"' ";    
 //System.out.println("1111"+query1);
  String query6 = "update inventory_transfer set Location_Status='RECIEVED' where  id_transfer= '"+jTextField13.getText()+"'"; 
  String query7="update inventory_transfer set Transcn_End_date='"+jTextField16.getText()+"' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'";

   String query8 = "update inventory_transfer set recievORrjct_IT='"+jTextField1.getText()+"' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'";
String query9 = "update inventory_transfer set recievORrjct_Remrk='"+jTextField3.getText()+"' where inventory_sn='"+jTextField4.getText()+"' && id_transfer= '"+jTextField13.getText()+"'"; 
//String query10 = "update inventory_transfer set inventory_areaAlloted='"+jComboBox1.getSelectedItem()+"' where inventory_sn='"+jTextField4.getText()+"'";
  
  
  st.executeUpdate(query1);
//st.executeUpdate(query22);
st.executeUpdate(query2);
st.executeUpdate(query3);
st.executeUpdate(query4);
st.executeUpdate(query5);
st.executeUpdate(query6);
 st.executeUpdate(query7);
 st.executeUpdate(query8);
 st.executeUpdate(query9);
 
 JOptionPane.showMessageDialog(null,
   "Updated acceptupdate fn. in stock transfer & allocation table\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
    storeaccept(); 
    }catch(Exception e){
System.out.println("Error");
JOptionPane.showMessageDialog(null,
   "Failed acceptupdate in stock transfer & allocation table\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
}}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField13 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(new java.awt.Color(0, 102, 102));
        label1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label1.setEnabled(false);
        label1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Inventory Item Recieption");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("From Company");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("To company");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Frm Cmpny Dvsn");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("To Cmpny Dvsn");

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Serial Number");

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 102, 102));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Recieve With Comment");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Transferred By: ");

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(0, 102, 102));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home Page");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Reject  With Comment");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(204, 255, 255));

        jTextField3.setBackground(new java.awt.Color(204, 255, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Transfer Remark");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Approval From");

        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(0, 102, 102));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(0, 102, 102));
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("To User");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("To department");

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(0, 102, 102));
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Current User ");

        jTextField10.setBackground(new java.awt.Color(0, 102, 102));
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));

        jTextField11.setBackground(new java.awt.Color(0, 102, 102));
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));

        jTextField12.setBackground(new java.awt.Color(0, 102, 102));
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(0, 102, 102));
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox1.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
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

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(0, 102, 102));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Transfer ref & Date");

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(0, 102, 102));

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setText("Select");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField14, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(47, 47, 47)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
      String   msg=jTextField1.getText();
      String date= jTextField16.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        
          try{  String x=jTextField4.getText();
     String z=jTextField8.getText();
        
        if("".equals(x)||"".equals(z)){
            
            int y=0/0;}
         sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
      String sql = "SELECT * FROM  user_ittranscnprevilege WHERE AllowedCompany='"+jTextField10.getText()+"' && AllowedDivision='"+jTextField11.getText()+"' &&"
              + "It_User='"+jTextField1.getText()+"'" ;
   ResultSet rs=stat.executeQuery(sql);
   if(rs.next()==false){
 JOptionPane.showMessageDialog(null,
   "You have no access for doing this rejection   "
           + ",Kindly ask System manager to give you the access for company '"+jTextField10.getText()+"' & its division  '"+jTextField11.getText()+"' to reject this item ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int g=0/0;
    
}          
      
         rejectupdate();
          JOptionPane.showMessageDialog(null,
   "The item serial '" +jTextField4.getText()+"' is transferred back to user '" +jTextField14.getText()+"'  ","Inane warning",
    JOptionPane.PLAIN_MESSAGE); 
             clear1();
    
          }catch(Exception e){JOptionPane.showMessageDialog(null,
   "Error with data in form or if not able to correct yourself contact IT service\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);clear1();}
        
        
                                         
        
       
                                        

        
        
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        try{if(jComboBox1.getSelectedItem()=="Please Select"){
            JOptionPane.showMessageDialog(null,
   "Kindly Select Depeartment & resubmit\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
            int y=0/0;}
       sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
      String sql = "SELECT * FROM  user_ittranscnprevilege WHERE AllowedCompany='"+jTextField10.getText()+"' && AllowedDivision='"+jTextField11.getText()+"' &&"
              + "It_User='"+jTextField1.getText()+"'" ;
   ResultSet rs=stat.executeQuery(sql);
   if(rs.next()==false){
 JOptionPane.showMessageDialog(null,
   "You have no access for doing this reception   "
           + ",Kindly ask System manager to give you the access for company '"+jTextField10.getText()+"' & its division  '"+jTextField11.getText()+"' to continue this reception ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int g=0/0;
    
}          
        
          acceptupdate();
        // storeaccept();
        JOptionPane.showMessageDialog(null,
   "The item serial '" +jTextField4.getText()+"' is transferred to user '" +jTextField12.getText()+"'  & stock updated succesfully  ","Inane warning",
    JOptionPane.PLAIN_MESSAGE); 
        clear1();
        }
        catch(Exception e ){
        JOptionPane.showMessageDialog(null,
   "Error ! ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
        clear1();
        }
      
        
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
      //  jComboBox1.removeAllItems();
    //    filldepartment();
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
       jTextField10.setText("");
       jTextField11.setText("");
       jTextField12.setText("");
      jTextField5.setText("");
      jTextField6.setText("");
      jTextField13.setText("");
      jTextField17.setText("");
     sendfill();
   recieverinfofromsender();
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
            java.util.logging.Logger.getLogger(Item_Recieption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item_Recieption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item_Recieption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item_Recieption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item_Recieption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
