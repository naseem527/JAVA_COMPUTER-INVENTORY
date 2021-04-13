/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Challenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Admin
 */
public class CompanyAndDivision_Binding extends javax.swing.JFrame {

    /**
     * Creates new form CompanyAndDivision_Binding
     */
    public CompanyAndDivision_Binding() {
        initComponents();
    }
 public CompanyAndDivision_Binding(String msg,String Date) {
        initComponents();
        fillcomboCompanyAndDiv();
         jTextField3.setText(msg);
        jTextField4.setText(Date);
        
    }
 
 public void fillcomboCompanyAndDiv(){
    String sql = "SELECT * FROM company where company_Name !='' && Status_Active='YES'" ;
    String sql1 = "SELECT * FROM division_name WHERE iddivision_Name !='' && Status_Active='YES'";
        try{  //System.out.println("0");
     //   Connection con = DriverManager
       /// .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
          //    + "user=root&password=527482");// System.out.println("1");
            sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
         PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs1=pst.executeQuery();
  int y=0;   //System.out.println("2");
    while(rs1.next()){
      
  String company_Name= rs1.getString("company_Name");
jComboBox1.addItem(company_Name);
   // System.out.println("3");
    }
   
         PreparedStatement pst1=con.prepareStatement(sql1);
    ResultSet rs2=pst1.executeQuery();
 // int y=0;   //System.out.println("2");
    while(rs2.next()){
      
  String division_Name= rs2.getString("division_Name");
jComboBox2.addItem(division_Name);
jComboBox3.addItem(division_Name);

   // System.out.println("3");
    }

    }catch(Exception e){System.out.println("Error in filling combobox");}

    }
 
 void getconnectionmethod() throws Exception{ 
try{
       sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
        // Class.forName("com.mysql.jdbc.Driver"); 
        
     //    Connection con = DriverManager
       // .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=nasm&password=1234baby");
         
       //  Statement stat= con.createStatement();
        // System.out.println("DB connection OKey in MySQL0");
  
// stat = con.createStatement();
  // System.out.println("DB connection OKey in MySQL1");
String sql = "INSERT INTO companydivisionbind( company_Name,division_Name,Remark) " +
       "VALUES ('"+jComboBox1.getSelectedItem()+"','"+jComboBox2.getSelectedItem()+"','ADDBY IT:' '-' '"+jTextField3.getText()+ "')";
  //System.out.println("DB connection OKey in MySQL2");
      stat.executeUpdate(sql); 
      JOptionPane.showMessageDialog(null,
   "Binding Done  Succesfully \n ","plain messge",
    JOptionPane.INFORMATION_MESSAGE); 
      System.out.println("DB connection OKey in MySQL3");
 
 divisionUpdateToCurrentCompany() ;

 }
       catch(SQLException e){
        
          
          JOptionPane.showMessageDialog(null,
   "Value Already added \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
           
           System.out.println("Error caught");}
        
    
        
        
}
 public void View_CompanyBind() throws Exception{
   String sql = "SELECT company_Name as 'Company',division_Name as 'Binded Divisions',Remark FROM companydivisionbind where idCDBind !='' && company_Name='"+jComboBox1.getSelectedItem()+"'";
    
    try{ 
       // Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
     PreparedStatement pst1=con.prepareStatement(sql);
    ResultSet rs1=pst1.executeQuery();
  boolean x=rs1.next();
    if(x==false){
                   JOptionPane.showMessageDialog(null,
   "Company has no binds currently \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); int y=0/0;
    }
   System.out.println("5");
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
  System.out.println("6");
    }catch(SQLException e){
       
DefaultTableModel model = new DefaultTableModel();
 jTable1.setModel(model);
        
        System.out.println("Error in filling jTable1 -(View all Table)");}

}
 
 public void View_DivisionBind(){
   String sql = "SELECT division_Name,company_Name as 'Current Binded Company' FROM companydivisionbind where idCDBind !='' && division_name='"+jComboBox3.getSelectedItem()+"'";
    
    try{ 
       // Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql);
    ResultSet rs=pst.executeQuery();
     PreparedStatement pst1=con.prepareStatement(sql);
      ResultSet rs1=pst1.executeQuery();
  boolean x=rs1.next();
    if(x==false){
                   JOptionPane.showMessageDialog(null,
   "Division has no binds currently \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); int y=0/0;
    }
   System.out.println("5");
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
  System.out.println("6");
    }catch(Exception e){
        DefaultTableModel model = new DefaultTableModel();
 jTable1.setModel(model);
        
        System.out.println("Error in filling jTable1 -(View all Table)");}

}
 public void unbinddivision(){
         
   String sql = "DELETE FROM companydivisionbind where division_Name='"+jTextField1.getText()+"'" ;
    String sql1 = "DELETE FROM user_ittranscnprevilege where AllowedDivision='"+jTextField1.getText()+"'" ;
    
    try{ 
       // Connection con = DriverManager
      //  .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
         //     + "user=root&password=527482");
        sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
      // PreparedStatement pst1=con.prepareStatement(sql);
       //System.out.println("Ns"+pst1);
     /*  ResultSet rs1=pst1.executeQuery();
    boolean x=rs1.next();
    if(x==false){
                   JOptionPane.showMessageDialog(null,
   "Division has no binds currently to be removed \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); int y=0/0;
    }
        System.out.println("Ns1");*/
  PreparedStatement pst=con.prepareStatement(sql);
 int x=  pst.executeUpdate();
    System.out.println("Ns "+ x);
    if(x==0){
        
                   JOptionPane.showMessageDialog(null,
   "Entered Division has no bind's currently to be removed \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); int y=0/0;
    
    }else {PreparedStatement pst1=con.prepareStatement(sql1);pst1.executeUpdate();
    JOptionPane.showMessageDialog(null,
   "Entered Division's bind  is succesfully removed \n Kindly Note The user's assosciated  to  unbinded division got removed automatically  ","plain message",
    JOptionPane.INFORMATION_MESSAGE);}
   
    
   System.out.println("5");
   
  System.out.println("6");
    }catch(Exception e){System.out.println("Action not Done");}}
 public void divisionUpdateToNo_Company_ForDiv() throws Exception{
try{sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
        
            String query = "update inventory_allocation set inventory_company='NO Parent Company' where inventory_division='"+jTextField1.getText()+"' ";
 PreparedStatement pst=con.prepareStatement(query);
 pst.executeUpdate();
            JOptionPane.showMessageDialog(null,
   "Success!!! .. Entered Company '" +jComboBox3.getSelectedItem()+ "' is succesfully  updated for function divisionUpdateToNo_Company() in inventory_allocation db table","plain message",
    JOptionPane.PLAIN_MESSAGE);

}catch(SQLException e){
JOptionPane.showMessageDialog(null,
   " Entered Company '" +jComboBox3.getSelectedItem()+ "' is failed to update for divisionUpdateToNo_Company() in inventory_allocation db table","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}


}
 public void divisionUpdateToCurrentCompany() throws Exception{
try{sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
        
            String query = "update inventory_allocation set inventory_company='"+jComboBox1.getSelectedItem()+"' where inventory_division='"+jComboBox2.getSelectedItem()+"' ";
 PreparedStatement pst=con.prepareStatement(query);
 pst.executeUpdate();
            JOptionPane.showMessageDialog(null,
   "Success!!! .. Entered Division '" +jComboBox2.getSelectedItem()+ "' is succesfully  binded with company '" +jComboBox1.getSelectedItem()+ "' ","plain message",
    JOptionPane.PLAIN_MESSAGE);

}catch(SQLException e){
JOptionPane.showMessageDialog(null,
   " Entered Division '" +jComboBox2.getSelectedItem()+ "' is failed to bind with company '" +jComboBox1.getSelectedItem()+ "'","Inane warning",
    JOptionPane.ERROR_MESSAGE);

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
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Company & Division Binding ");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jComboBox1.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Company");

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Division");

        jComboBox2.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Bind ");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Release /Un-Bind");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("UnBind The Division from its Parent Company");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Division");

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Current Parent Company");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addGap(28, 28, 28))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(309, 309, 309))
        );

        jComboBox3.setBackground(new java.awt.Color(0, 153, 153));
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));

        jLabel7.setText("Division");

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Check Selected Division's Bind");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95)))
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))))
        );

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Go HomePage");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Selected Company's Current  Bind");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, 213, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(4, 4, 4)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
     if(jComboBox1.getSelectedItem() =="Please Select"||jComboBox2.getSelectedItem() =="Please Select" ||jComboBox2.getSelectedItem() ==null){JOptionPane.showMessageDialog(null,
   "Kindly Select All Mandatory Fields & resubmit\n ","plain message",
    JOptionPane.PLAIN_MESSAGE);
    int y=0/0;
    }
        
       try{ 
    getconnectionmethod();
  //  divisionUpdateToCurrentCompany() ;
    
     }catch(Exception e){}
      
                      
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    try{   jComboBox3.setSelectedIndex(0);
         jComboBox2.setSelectedIndex(0);
        View_CompanyBind();}catch(Exception e){}
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        jComboBox1.setSelectedIndex(0);
         jComboBox2.setSelectedIndex(0);
        
        View_DivisionBind();
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
             String msg=jTextField3.getText();
      String date= jTextField4.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:

        String sql= "SELECT * FROM inventory_allocation where (inventory_division ='"+jTextField1.getText()+"' "
        + "&& Location_Status='ON_TRANSIT')" ;
        String sql1= "SELECT * FROM inventory_transfer where (inventory_ToDiv ='"+jTextField1.getText()+"' "
        + "&& Location_Status='ON_TRANSIT')" ;
        try{  sqlconnect sc=new sqlconnect();
            Statement stat= sc.sqlconnect_stat();
            ResultSet rs=stat.executeQuery(sql);
            if(rs.next()==true){
                JOptionPane.showMessageDialog(null,
                    "The Selected Division has item transfers to other locations,Check in trasfer table & ask recepient company to accept or reject the transfer to continue with"
                    + "Division Unbinding ","Inane warning",
                    JOptionPane.ERROR_MESSAGE);
                int x=0/0;

            }

            ResultSet rs1=stat.executeQuery(sql1);
            if(rs1.next()==true){
                JOptionPane.showMessageDialog(null,
                    "The choosen Division has reception for items from other locations,Check in trasfer table & either accept or reject the transfers to continue with"
                    + "Division  Unbinding ","Inane warning",
                    JOptionPane.ERROR_MESSAGE);
                int x=0/0;

            }

            unbinddivision();
            divisionUpdateToNo_Company_ForDiv();

        }
        catch(Exception e){
            System.out.println("Unbinding failed");
        }

    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(CompanyAndDivision_Binding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompanyAndDivision_Binding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompanyAndDivision_Binding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompanyAndDivision_Binding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompanyAndDivision_Binding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
