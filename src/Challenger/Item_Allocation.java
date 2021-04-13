/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.Calendar;
import Challenger.Date2;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class Item_Allocation extends javax.swing.JFrame {
  //  private Object JOptionPane;

    /**
     * Creates new form Item_Allocation
     */
    public Item_Allocation() {
        initComponents();
    }
    public Item_Allocation(String msg,String date) {
        initComponents();
          jTextField6.setText(msg);
        jTextField5.setText(date);
       // fillcombo();
       //fillcombo1();
        // fillcombo2();
        //  fillcombo3();
        //  fillcombo5();
         // fillcombo4();
        fillcomboALLTogether();
          setText();
    }

//class Task extends Thread{}
    public void fillcomboALLTogether(){
    String sql = "SELECT DISTINCT AllowedCompany FROM user_ittranscnprevilege where AllowedCompany !='' && It_User= '"+jTextField6.getText()+"'" ;
    String sql1 = "SELECT * FROM item_typemaster WHERE item_typeName !='' && Status_Active='YES'" ;
    String sql2 = "SELECT * FROM item_brandmaster WHERE item_brandName !='' && Status_Active='YES' ";
   // String sql3 = "SELECT * FROM division_name WHERE iddivision_Name !='' && Status_Active='YES' ";
    String sql4 = "SELECT * FROM user_master where user_Name !='' && Status_Active='YES'"  ;
    String sql5 = "SELECT * FROM department where department_Name !='' && Status_Active='YES'" ;
        try{  //System.out.println("0");
     //   Connection con = DriverManager
       /// .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String AllowedCompany= rs.getString("AllowedCompany");
jComboBox3.addItem(AllowedCompany);
   // System.out.println("3");
    }
    PreparedStatement pst1=con.prepareStatement(sql1);
    ResultSet rs1=pst1.executeQuery();
  //S1ystem.out.println("2");
    while(rs1.next()){
       String item_typeName= rs1.getString("item_typeName");
       
 jComboBox2.addItem(item_typeName);
 
 
   // System.out.println("3");
    }
    PreparedStatement pst2=con.prepareStatement(sql2);
    ResultSet rs2=pst2.executeQuery();
   //System.out.println("2");
    while(rs2.next()){
       String item_brandName= rs2.getString("item_brandName");
jComboBox4.addItem(item_brandName);
 
   // System.out.println("3");
    }
  /*    PreparedStatement pst3=con.prepareStatement(sql3);
    ResultSet rs3=pst3.executeQuery();
  //System.out.println("2");
    while(rs3.next()){
       String division_Name= rs3.getString("division_Name");
jComboBox5.addItem(division_Name);
 
   // System.out.println("3");
    }  */
    PreparedStatement pst4=con.prepareStatement(sql4);
    ResultSet rs4=pst4.executeQuery();
  //System.out.println("2");
    while(rs4.next()){
      
  String user_Name= rs4.getString("user_Name");
jComboBox6.addItem(user_Name);
   // System.out.println("3");
    }
     
  PreparedStatement pst5=con.prepareStatement(sql5);
    ResultSet rs5=pst5.executeQuery();
     //System.out.println("2");
    while(rs5.next()){
      
  String department_Name= rs5.getString("department_Name");
jComboBox7.addItem(department_Name);
   // System.out.println("3");
    }

    
    

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    
    
    
    
     public void fillcombo(){
    String sql = "SELECT * FROM item_typemaster WHERE item_typeName !=''" ;
        try{  //System.out.println("0");
      //  Connection con = DriverManager
        //.getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
            //  + "user=root&password=527482");// System.out.println("1");
    sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
       
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String item_typeName= rs.getString("item_typeName");
       
 jComboBox2.addItem(item_typeName);
 
 
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillcombo1(){
    String sql = "SELECT * FROM item_brandmaster WHERE item_brandName !=''";
        try{  //System.out.println("0");
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
       
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String item_brandName= rs.getString("item_brandName");
jComboBox4.addItem(item_brandName);
 
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}}
 public void fillcombo2(){
    String sql = "SELECT * FROM company where company_Name !=''" ;
        try{  //System.out.println("0");
     //   Connection con = DriverManager
       /// .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox3.addItem(company_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void filldivision(){
    String sql = "SELECT * FROM user_ittranscnprevilege WHERE It_User= '"+jTextField6.getText()+"' && AllowedDivision !='' && AllowedCompany = '"+jComboBox3.getSelectedItem()+"'";
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
       String AllowedDivision= rs.getString("AllowedDivision");
jComboBox5.addItem(AllowedDivision);
 
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillcombo4(){
    String sql = "SELECT * FROM user_master where user_Name !=''" ;
        try{  //System.out.println("0");
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
       
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String user_Name= rs.getString("user_Name");
jComboBox6.addItem(user_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillcombo5(){
    String sql = "SELECT * FROM department where department_Name !=''" ;
        try{  //System.out.println("0");
       // Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
       
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String department_Name= rs.getString("department_Name");
jComboBox7.addItem(department_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    
    public void setText(){
    String sql = "SELECT * FROM user_master where user_Name='"+jComboBox6.getSelectedItem()+"'" ;
    System.out.println("1"+jComboBox6.getSelectedItem());
    try{  //System.out.println("0");
      //  Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");// System.out.println("1");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
       
  PreparedStatement pst=con.prepareStatement(sql);
  System.out.println("2");
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
  while(rs.next()) {
  System.out.println("3");
    System.out.println("5"+jComboBox6.getSelectedItem()); 
    System.out.println("6"+rs);
  String user_companyid= rs.getString("user_companyid"); System.out.println("4");
  System.out.println("3"+user_companyid);
jTextField1.setText(user_companyid);
   // System.out.println("3");
  }
   

    }catch(Exception e){System.out.println("Error in setText");}}
 public class getconnection{
        private Object jTextField1;
void getconnectionmethod(){ 
try{
       sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
       
        // Class.forName("com.mysql.jdbc.Driver"); 
        
        // Connection con = DriverManager
        //.getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");
         
        // Statement stat= con.createStatement();
       //  System.out.println("DB connection OKey in MySQL0");
  
// stat = con.createStatement();
  // System.out.println("DB connection OKey in MySQL1");

   String x= jDateChooser1.getDate().toString();
  System.out.println(x);
String sql = "INSERT INTO inventory_allocation( inventory_sn,inventory_type,inventory_brand,inventory_company,inventory_division,inventory_areaAlloted,inventory_allotUser,inventory_FirstIntroduction,inventory_IntroductionRemark) " +
           "VALUES ('"+jTextField9.getText()+"','"+jComboBox2.getSelectedItem()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox3.getSelectedItem()+"','"+jComboBox5.getSelectedItem()+"','"+jComboBox7.getSelectedItem()+"','"+jComboBox6.getSelectedItem()+"','"+jDateChooser1.getDate()+"','"+jTextField2.getText()+"')";
  System.out.println("DB connection OKey in MySQL2");
      stat.executeUpdate(sql);   
    //   System.out.println(""+  stat.executeUpdate(sql));
JOptionPane.showMessageDialog(null,
   "Item with mentioned serial number  are alocated succesfully \n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
 

 }
       catch(Exception e){
        
          
          JOptionPane.showMessageDialog(null,
   "Error! Item Allocation is not done \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);

           System.out.println("DB connection Error");}
        
    
        
        
 
}
 
 }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateUtil1 = new com.toedter.calendar.DateUtil();
        dateUtil2 = new com.toedter.calendar.DateUtil();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        dateUtil3 = new com.toedter.calendar.DateUtil();
        dateUtil4 = new com.toedter.calendar.DateUtil();
        dateUtil5 = new com.toedter.calendar.DateUtil();
        dateUtil6 = new com.toedter.calendar.DateUtil();
        dateUtil7 = new com.toedter.calendar.DateUtil();
        dateUtil8 = new com.toedter.calendar.DateUtil();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Item allocation ");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Company");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Division");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Department");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Item S/N");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Item Brand");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Item Type");

        jComboBox2.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox2FocusGained(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });

        jComboBox3.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
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

        jComboBox4.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
        });

        jComboBox5.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox5MouseEntered(evt);
            }
        });

        jComboBox6.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });
        jComboBox6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox6MouseClicked(evt);
            }
        });

        jComboBox7.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jComboBox7.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox7MouseClicked(evt);
            }
        });
        jComboBox7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox7KeyPressed(evt);
            }
        });

        jTextField9.setBackground(new java.awt.Color(0, 102, 102));
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField9MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(0, 102, 102));
        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Remark");

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home Page");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jDateChooser1.setBackground(new java.awt.Color(153, 204, 255));
        jDateChooser1.setForeground(new java.awt.Color(204, 204, 255));
        jDateChooser1.setMinSelectableDate(new java.util.Date(-62135776723000L));

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 102, 102));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 683, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(31, 31, 31))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                                .addGap(120, 120, 120)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
String msg,date;
        msg=jTextField6.getText();
       date= jTextField5.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        String x=jTextField9.getText();
        x.isEmpty();
        System.out.println("Nas:"+jTextField9.getText());
    if(x.isEmpty()||jComboBox2.getSelectedItem() =="Please Select" || jComboBox3.getSelectedItem() =="Please Select"  || jComboBox6.getSelectedItem() =="Please Select" || jComboBox4.getSelectedItem() =="Please Select"|| jComboBox5.getSelectedItem() =="Please Select" ||
            jComboBox7.getSelectedItem() =="Please Select"){JOptionPane.showMessageDialog(null,
   "Kindly Select All Mandatory Fields & resubmit\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
    int y=0/0;
    }
        
        
        try{
        getconnection gc=new getconnection();
        gc.getconnectionmethod();
    
     }catch(Exception e){}
      
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
           
  //  jComboBox2.removeAllItems(); 
      
       // fillcombo();
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
        // TODO add your handling code here:
         // jComboBox4.removeAllItems(); 
      
       // fillcombo1();
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox2FocusGained
        // TODO add your handling code here:
       // jComboBox2.removeAllItems();
    }//GEN-LAST:event_jComboBox2FocusGained

    private void jComboBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox3MouseClicked
        // TODO add your handling code here:
       // jComboBox3.removeAllItems(); 
      
   //     fillcombo2();
        
    }//GEN-LAST:event_jComboBox3MouseClicked

    private void jComboBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseClicked
        // TODO add your handling code here:
     //    jComboBox5.removeAllItems(); 
      
      //  fillcombo3();
    }//GEN-LAST:event_jComboBox5MouseClicked

    private void jComboBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseClicked
        // TODO add your handling code here:
        //  jComboBox6.removeAllItems(); 
      
     //   fillcombo4();
      //  setText();
        
        
       
        //4
    }//GEN-LAST:event_jComboBox6MouseClicked

    private void jComboBox7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox7KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox7KeyPressed

    private void jComboBox7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox7MouseClicked
        // TODO add your handling code here:
      //  jComboBox7.removeAllItems(); 
      
       // fillcombo5();
    }//GEN-LAST:event_jComboBox7MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        // TODO add your handling code here:
            setText();
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        // TODO add your handling code here:
      
       setText();
                
                
               
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jTextField9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField9MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextField9MouseClicked

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
     jComboBox5.removeAllItems();
        filldivision();
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5MouseEntered

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
          
    

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
            java.util.logging.Logger.getLogger(Item_Allocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item_Allocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item_Allocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item_Allocation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item_Allocation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.DateUtil dateUtil1;
    private com.toedter.calendar.DateUtil dateUtil2;
    private com.toedter.calendar.DateUtil dateUtil3;
    private com.toedter.calendar.DateUtil dateUtil4;
    private com.toedter.calendar.DateUtil dateUtil5;
    private com.toedter.calendar.DateUtil dateUtil6;
    private com.toedter.calendar.DateUtil dateUtil7;
    private com.toedter.calendar.DateUtil dateUtil8;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
