/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;
import Challenger.Item_Allocation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import Challenger.sqlconnect.*;
/**
 *
 * @author Admin
 */
public class Item_transfer_form extends javax.swing.JFrame {

    /**
     * Creates new form Item_transfer_form
     */
    public Item_transfer_form() {
        initComponents();
    }
    public Item_transfer_form(String msg,String date) {
        initComponents();
         jTextField2.setText(msg);
        jTextField1.setText(date);
       // fillcompany();
       //  filldivision();
        // filluser();
        fillALLTogether();
     //    filluser1();
    }
    
    public void fillALLTogether(){
    String sql = "SELECT * FROM company where company_Name !=''" ;
   // String sql1 = "SELECT * FROM user_ittranscnprevilege WHERE AllowedDivision !='' && AllowedCompany='"+jComboBox6.getSelectedItem()+"'";
    String sql2 = "SELECT * FROM user_master where user_Name !=''" ;
        try{  //System.out.println("0");
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox6.addItem(company_Name);
   // System.out.println("3");
    }
    //PreparedStatement pst1=con.prepareStatement(sql1);
// ResultSet rs1=pst1.executeQuery();
   //System.out.println("2");
  //  while(rs1.next()){
      
 // String division_Name= rs1.getString("division_Name");
//jComboBox7.addItem(division_Name);
   // System.out.println("3");
   // }
     PreparedStatement pst2=con.prepareStatement(sql2);
    ResultSet rs2=pst2.executeQuery();
     //System.out.println("2");
    while(rs2.next()){
      
  String user_Name= rs2.getString("user_Name");
jComboBox4.addItem(user_Name);
jComboBox5.addItem(user_Name);
   // System.out.println("3");
    }
    
    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    private void divisionfill(){
    
    String sql1 = "SELECT DISTINCT division_Name FROM companydivisionbind WHERE division_Name !='' && company_Name='"+jComboBox6.getSelectedItem()+"'";
    try{
        
    sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
        PreparedStatement pst1=con.prepareStatement(sql1);
 ResultSet rs1=pst1.executeQuery();
   System.out.println("2");
    while(rs1.next()){
      
  String AllowedDivision= rs1.getString("division_Name");
jComboBox7.addItem(AllowedDivision);
   // System.out.println("3");

    }
    }
    catch(Exception e){}
    
    }
    
  /**  
    
    public void filluser(){
    String sql = "SELECT * FROM user_master where user_Name !=''" ;
        try{  //System.out.println("0");
       // Connection con = DriverManager
        //.getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482"); System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String user_Name= rs.getString("user_Name");
jComboBox4.addItem(user_Name);
jComboBox5.addItem(user_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
   /** public void filluser1(){
    String sql = "SELECT * FROM user_master where user_Name !=''" ;
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
      
  String user_Name= rs.getString("user_Name");
jComboBox5.addItem(user_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void fillcompany(){
    String sql = "SELECT * FROM company where company_Name !=''" ;
        try{  //System.out.println("0");
      //  Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
      
  String company_Name= rs.getString("company_Name");
jComboBox6.addItem(company_Name);
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
    public void filldivision(){
    String sql = "SELECT * FROM division_name WHERE iddivision_Name !=''";
        try{  //System.out.println("0");
      //  Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           ///   + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String division_Name= rs.getString("division_Name");
jComboBox7.addItem(division_Name);
 
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }   */
     public void filldepartment(){
    String sql = "SELECT * FROM department WHERE department_Name !=''";
        try{  //System.out.println("0");
     //   Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs.next()){
       String department_Name= rs.getString("department_Name");

 
   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Serial No:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("To User");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Approved By");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Remarks");

        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Transfer!");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jButton1MouseDragged(evt);
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Go Home Page");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 102, 102));
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox4.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 102, 102));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("   Item Transfer Form");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setBackground(new java.awt.Color(204, 255, 204));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("From Company");

        jLabel10.setBackground(new java.awt.Color(204, 255, 204));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Company Division");

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(204, 255, 204));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("From User");

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(0, 102, 102));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("To Company");

        jComboBox5.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox5MouseClicked(evt);
            }
        });

        jComboBox6.setBackground(new java.awt.Color(204, 255, 255));
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

        jComboBox7.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox7MouseClicked(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField7MouseClicked(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton3.setText("Search");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("To Company Div");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox7, 0, 174, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, 174, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField6))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(416, 416, 416))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(127, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void senderfill(){
   
    String sql = "SELECT * FROM inventory_allocation where inventory_sn='"+jTextField7.getText()+"' ";
System.out.println(1);    
//if(sql.isEmpty()){System.out.println("empty");}
    try{  
        
        //Connection con = DriverManager
        //.getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");System.out.println("2");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
 // System.out.println(pst); 
  ResultSet rs1= pst.executeQuery();
 if( rs1.next()==false){
     JOptionPane.showMessageDialog(null,
   " Entered item ' "+jTextField7.getText()+" ' is not present in stock,Check report of inventory stock details","Inane warning",
    JOptionPane.ERROR_MESSAGE);
     jTextField7.setText("");
     jTextField6.setText("");
     jTextField5.setText("");
     jTextField4.setText("");
     
     }
  
  ResultSet rs=pst.executeQuery();
   //System.out.println(rs); 
     System.out.println("3");
    while(rs.next()){ System.out.println("4");
       String  Location_Status1=rs.getString("Location_Status");
       System.out.println(Location_Status1);
if(    "ON_TRANSIT".equals(Location_Status1)){JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is already in transfer to other location,Check report of inventory transfer for details","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");
    int y=0/0;}
if(    "WRITE_OFF".equals(Location_Status1)){JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is already WRITE OFF,Check report of WRITE OFF for details","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");
    int y=0/0;}
    //  String inventory_sn= rs.getString("inventory_sn");
   // System.out.println("3");
//jTextField6.setText(inventory_sn);
  String inventory_company= rs.getString("inventory_company");
jTextField6.setText(inventory_company);
 String inventory_division= rs.getString("inventory_division");
jTextField5.setText(inventory_division);
 String inventory_allotUser= rs.getString("inventory_allotUser");
jTextField4.setText(inventory_allotUser);
//System.out.println(""+inventory_company);
 // System.out.println("3");
   
     }
    //int x=7/0;
   
    }
  catch(Exception e){ 
      
      
      
  }
       

}

public void transferupdate(){ //Statement  statement4;
 System.out.println("0.0");
    try{//sqlconnect sc=new sqlconnect();
  // statement4= sc.sqlconnect1();
   //  Class.forName("com.mysql.jdbc.Driver"); 
        
     //    Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //   + "user=root&password=527482");
     //   Statement stat=con.createStatement();
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         Statement statement4= con.createStatement();
  String sql = "INSERT INTO inventory_transfer( inventory_sn,inventory_FromUser,inventory_ToCompany,inventory_ToDiv,inventory_ToUser,transfer_approvBy,IT_operationBy,Transcn_Start_date,InitialTranscn_remark) " +
           "VALUES ('"+jTextField7.getText()+"','"+jTextField4.getText()+"','"+jComboBox6.getSelectedItem()+"','"+jComboBox7.getSelectedItem()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox5.getSelectedItem()+"','"+jTextField2.getText()+"','"+jTextField1.getText()+"','"+jTextField3.getText()+"')";
    statement4.executeUpdate(sql); 
      String query = "update inventory_allocation set Location_Status='ON_TRANSIT' where inventory_sn='"+jTextField7.getText()+"' ";
  //  stat.executeQuery(query); 
    JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is succesfully iniitiated the transfer process to user '"+jComboBox4.getSelectedItem()+"' in transfer table ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
     stockupdate();
    }catch(Exception e){
      JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is failed to start transfer process to user '"+jComboBox4.getSelectedItem()+"'\n in transfer Table ,Contact IT Department ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
    jTextField7.setText(" ");
    }
}
public void stockupdate(){
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update inventory_allocation set Location_Status='ON_TRANSIT' where inventory_sn='"+jTextField7.getText()+"' ";
       
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is succesfully reflected in stock for transfer status ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);jTextField7.setText(" ");
    
   }catch(Exception e){
JOptionPane.showMessageDialog(null,
   " Entered item '" +jTextField7.getText()+ "' is failed to reflect in stock for transfer process ","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");

}
}
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

       String   msg=jTextField2.getText();
      String date= jTextField1.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void jComboBox6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox6MouseClicked
        // TODO add your handling code here:
         jComboBox7.removeAllItems();
        jComboBox7.setSelectedIndex(0);
        divisionfill();
       
      //  fillcompany();
      
    }//GEN-LAST:event_jComboBox6MouseClicked

    private void jComboBox7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox7MouseClicked
        // TODO add your handling code here:
    //    jComboBox7.removeAllItems();
      //  filldivision();
    }//GEN-LAST:event_jComboBox7MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    try{  String x=jTextField7.getText();
        if("".equals(x)){int y=0/0;}
        
        
        senderfill();}catch(Exception e){jTextField6.setText("");
        jTextField5.setText("");
        jTextField4.setText("");
            JOptionPane.showMessageDialog(null,
   "Entered no value\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");}
        
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jTextField7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseClicked
        // TODO add your handling code here:
       jTextField7.setText("");
    }//GEN-LAST:event_jTextField7MouseClicked

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
        // TODO add your handling code here:
     //  jComboBox4.removeAllItems();
      //  filluser();
        
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jComboBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseClicked
        // TODO add your handling code here:
 //      jComboBox5.removeAllItems();
   //    filluser1();
    }//GEN-LAST:event_jComboBox5MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
                   
        if( jComboBox4.getSelectedItem() =="Please Select" || jComboBox5.getSelectedItem() =="Please Select" || jComboBox6.getSelectedItem() =="Please Select" ||  
            jComboBox7.getSelectedItem() =="Please Select"){JOptionPane.showMessageDialog(null,
   "Kindly Select All Mandatory Fields & resubmit\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
    int y=0/0;
    }
        String z=jTextField6.getText();
        if("NO Parent Company".equals(z)){
        JOptionPane.showMessageDialog(null,
   "Kindly Note the division '"+jTextField5.getText()+"' is not assigned to any parent company,Kindly contact IT department \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
    int y=0/0;
        }
        try{  String x=jTextField7.getText();
     
     String a=(String) jComboBox6.getSelectedItem();
     String b=(String) jComboBox7.getSelectedItem();
     String c=(String) jComboBox4.getSelectedItem();
     String d=(String) jComboBox5.getSelectedItem();
      //   System.out.println("comb6"+a);    
        if("".equals(x)||"".equals(z)||"".equals(a)||"".equals(c)||"".equals(d)){int y=0/0;}
        sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
      String sql = "SELECT * FROM  user_ittranscnprevilege WHERE AllowedCompany='"+jTextField6.getText()+"' && AllowedDivision='"+jTextField5.getText()+"' && It_User='"+jTextField2.getText()+"'  " ;
   ResultSet rs=stat.executeQuery(sql);
   if(rs.next()==false){
 JOptionPane.showMessageDialog(null,
   "You have no access for doing this transfer as Selected item stock's location is not  "
           + "assigned for you to do this operation,Kindly ask System manager to give you the access for company '"+jTextField6.getText()+"' & its division  '"+jTextField5.getText()+"' "
           + "","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int g=0/0;
    
}         
        
         transferupdate();
     // stockupdate(); ** Stock update i add inside transferupdate() function
       JOptionPane.showMessageDialog(null,
   "item serial number '" +jTextField7.getText()+ "' transfer process is initiated to user '" +jComboBox4.getSelectedItem()+ "' Succesfully\n "
           + "Ask Reciepient '" +jComboBox4.getSelectedItem()+ "' to  recieve the item mentioned \n ","plane message",
    JOptionPane.INFORMATION_MESSAGE);
      jTextField7.setText("");
      jTextField6.setText("");
      jTextField5.setText("");
      jTextField4.setText("");
       jTextField3.setText("");
      jComboBox6.removeAllItems();
      jComboBox7.removeAllItems();
      jComboBox4.removeAllItems();
      jComboBox5.removeAllItems();
     
         }catch(Exception e){JOptionPane.showMessageDialog(null,
   "item serial number not entered \n OR \n entered item number is not searched\n OR No access for current IT user to perform this operation due to location restricton","Inane warning",
    JOptionPane.ERROR_MESSAGE);jTextField7.setText(" ");
         jTextField6.setText("");
      jTextField5.setText("");
      jTextField4.setText("");
         jTextField3.setText("");
         
         
         }
  //try{
     //   transferupdate();
     //   stockupdate();
     //  jTextField6.setText("");
       // jTextField5.setText("");
    //   jTextField4.setText("");
    //  JOptionPane.showMessageDialog(null,
  // "item serial number '"+jTextField7.getText()+"' is transferred \n ","plane message",
  //  JOptionPane.INFORMATION_MESSAGE);
  //    }catch(Exception e){System.out.println("transfer error or stock update error");}                          
        
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseDragged

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        // TODO add your handling code here:
        jComboBox7.removeAllItems();
        divisionfill();
    }//GEN-LAST:event_jComboBox6ItemStateChanged

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
            java.util.logging.Logger.getLogger(Item_transfer_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item_transfer_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item_transfer_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item_transfer_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item_transfer_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
