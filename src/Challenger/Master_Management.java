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

/**
 *
 * @author Admin
 */
public class Master_Management extends javax.swing.JFrame {

    /**
     * Creates new form Master_Management
     */
    public Master_Management() {
        initComponents();
    }
 public Master_Management(String msg,String date) {
        initComponents();
           jTextField7.setText(msg);
        jTextField8.setText(date);
        fillcomboAll();
        
    }
 public void delete_Company_from_DBTable_user_ittranscnprevilege() throws Exception{
 
    String sql = "DELETE FROM user_ittranscnprevilege where AllowedCompany='"+jComboBox3.getSelectedItem()+"' " ;
    
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
   "Entered Company has no bind to any IT_user  for removal \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
    int g=0/0;
                   
    }else {
    JOptionPane.showMessageDialog(null,
   "Entered Company's bind to the all IT_user is succesfully  DELETED\n ","plain message",
    JOptionPane.INFORMATION_MESSAGE);
    
    }
 
    
   System.out.println("5");
   
  System.out.println("6");
    }catch(SQLException e){System.out.println("Exception");}


       
        
        
                                        
    }                                     
public void delete_Company_from_DBTable_companydivisionbind()throws Exception{
 
    String sql = "DELETE FROM companydivisionbind where company_Name='"+jComboBox3.getSelectedItem()+"' " ;
    
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
   "Entered Company has no bind to any division  for removal in companydivisionbind DB table\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
     int h=0/0;
    }else {
    JOptionPane.showMessageDialog(null,
   "Entered Company's bind to the all divisions is succesfully  DELETED & removed\n ","plain message",
    JOptionPane.INFORMATION_MESSAGE);}
 
    
   System.out.println("5");
   
  System.out.println("6");
    }catch(SQLException e){System.out.println("Exception");}


       
        
        
                                        
    } 


public void divisionUpdateToNo_Company() throws Exception{
try{sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
        
            String query = "update inventory_allocation set inventory_company='NO Parent Company' where inventory_company='"+jComboBox3.getSelectedItem()+"' ";
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
public void divisionUpdateToNo_Company_ForDiv() throws Exception{
try{sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
        
            String query = "update inventory_allocation set inventory_company='NO Parent Company' where inventory_division='"+jComboBox6.getSelectedItem()+"' ";
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
public void Company_Deletion_update()throws Exception{
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update company set Status_Active='NO' where company_Name='"+jComboBox3.getSelectedItem()+"' ";
       
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered Company '" +jComboBox3.getSelectedItem()+ "' is succesfully updated for deletion process in company master db table","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(SQLException e){
JOptionPane.showMessageDialog(null,
   " Entered Company '" +jComboBox3.getSelectedItem()+ "' is failed to update for deletion process in company master db table","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}
}
 public void fillcomboAll(){
    String sql = "SELECT * FROM company where company_Name !='' && Status_Active='YES'" ;
    String sql1 = "SELECT * FROM division_name WHERE iddivision_Name !='' && Status_Active='YES'";
   String sql2 = "SELECT * FROM item_brandmaster WHERE item_brandName !='' " ;
    String sql3 = "SELECT * FROM item_typemaster WHERE item_typeName !='' "  ;  
    String sql4 = "SELECT * FROM user_master where user_Name !='' "  ;
     String sql5 = "SELECT * FROM department WHERE department_Name !='' ";
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
   
         PreparedStatement pst1=con.prepareStatement(sql1);
    ResultSet rs1=pst1.executeQuery();
 // int y=0;   //System.out.println("2");
    while(rs1.next()){
      
  String division_Name= rs1.getString("division_Name");
//jComboBox2.addItem(division_Name);
jComboBox6.addItem(division_Name);

   // System.out.println("3");
    }

   

        
      PreparedStatement pst2=con.prepareStatement(sql2);
    ResultSet rs2=pst2.executeQuery();
 // int y=0;   //System.out.println("2");
    while(rs2.next()){
      
  String item_brandName= rs2.getString("item_brandName");
//jComboBox2.addItem(division_Name);
jComboBox4.addItem(item_brandName);

   // System.out.println("3");
    }

    PreparedStatement pst3=con.prepareStatement(sql3);
    ResultSet rs3=pst3.executeQuery();
 // int y=0;   //System.out.println("2");
    while(rs3.next()){
      
  String item_typeName= rs3.getString("item_typeName");
//jComboBox2.addItem(division_Name);
jComboBox5.addItem(item_typeName);

   // System.out.println("3");
    }
    
     PreparedStatement pst4=con.prepareStatement(sql4);
    ResultSet rs4=pst4.executeQuery();
 // int y=0;   //System.out.println("2");
    while(rs4.next()){
      
  String user_Name= rs4.getString("user_Name");
//jComboBox2.addItem(division_Name);
jComboBox2.addItem(user_Name);

   // System.out.println("3");
    }
    
     PreparedStatement pst5=con.prepareStatement(sql5);
    ResultSet rs5=pst5.executeQuery();
 // int y=0;   //System.out.println("2");
    while(rs5.next()){
      
  String department_Name= rs5.getString("department_Name");
//jComboBox2.addItem(division_Name);
jComboBox1.addItem(department_Name);

   // System.out.println("3");
    }
    
    }catch(Exception e){System.out.println("Error in filling combobox");}
   
        
        

        
    }
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        
   
 
 }
    
   public void setActiveStatusCompany(){
     String sql1 = "SELECT company.Status_Active from company where company.company_Name='"+jComboBox3.getSelectedItem()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Status_Active");
   jTextField3.setText(x);
   }
    

    }catch(Exception e){
         jTextField3.setText("");
        System.out.println("Item not found)");}

}
   
   
   public void delete_Division_from_DBTable_user_ittranscnprevilege() throws Exception{
 
    String sql = "DELETE FROM user_ittranscnprevilege where AllowedDivision='"+jComboBox6.getSelectedItem()+"' " ;
    
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
   "Entered Division has no bind to any IT_user  for removal \n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
    
    }else {
    JOptionPane.showMessageDialog(null,
   "Entered Division's bind to the all IT_user is succesfully  DELETED\n ","plain message",
    JOptionPane.INFORMATION_MESSAGE);}
 
    
   System.out.println("5");
   
  System.out.println("6");
    }catch(SQLException e){System.out.println("Exception");}


       
        
        
                                        
    }                                     
public void delete_Division_from_DBTable_companydivisionbind()throws Exception{
 
    String sql = "DELETE FROM companydivisionbind where division_Name='"+jComboBox6.getSelectedItem()+"' " ;
    
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
   "Entered division has no bind to any Company  for removal in companydivisionbind DB table\n ","Inane warning",
    JOptionPane.ERROR_MESSAGE); 
    
    }else {
    JOptionPane.showMessageDialog(null,
   "Entered Division's bind to the all Company is succesfully  DELETED & Removed\n ","plain message",
    JOptionPane.INFORMATION_MESSAGE);}
 
    
   System.out.println("5");
   
  System.out.println("6");
    }catch(SQLException e){System.out.println("Exception");}


       
        
        
                                        
    }    

public void Division_Deletion_update()throws Exception{
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update division_name set Status_Active='NO' where division_Name='"+jComboBox6.getSelectedItem()+"' ";
       
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered Division '" +jComboBox6.getSelectedItem()+ "' is succesfully updated for deletion process in division_name master db table","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(SQLException e){
JOptionPane.showMessageDialog(null,
   " Entered Division '" +jComboBox6.getSelectedItem()+ "' is failed to update for deletion process in division_name db table","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}
}
 
    
   public void setActiveStatusDivision(){
     String sql1 = "SELECT division_name.Status_Active from division_name where division_name.division_Name='"+jComboBox6.getSelectedItem()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Status_Active");
   jTextField2.setText(x);
   }
    

    }catch(Exception e){
         jTextField2.setText("");
        System.out.println("Item not found)");}

}
   
   
    public void setActiveStatusUser(){
     String sql1 = "SELECT user_master.Status_Active from user_master where user_master.user_Name='"+jComboBox2.getSelectedItem()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Status_Active");
   jTextField1.setText(x);
   }
    

    }catch(Exception e){
         jTextField1.setText("");
        System.out.println("User not found)");}

}

 public void setActiveStatusDepartment(){
     String sql1 = "SELECT department.Status_Active from department where department.department_Name='"+jComboBox1.getSelectedItem()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Status_Active");
   jTextField5.setText(x);
   }
    

    }catch(Exception e){
         jTextField5.setText("");
        System.out.println("Dept. not found)");}

}

 public void setActiveStatusBrand(){
     String sql1 = "SELECT item_brandmaster.Status_Active from item_brandmaster where item_brandmaster.item_brandName='"+jComboBox4.getSelectedItem()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Status_Active");
   jTextField4.setText(x);
   }
    

    }catch(Exception e){
         jTextField4.setText("");
        System.out.println("brand. not found)");}

}
 public void setActiveStatusType(){
     String sql1 = "SELECT item_typemaster.Status_Active from item_typemaster where item_typemaster.item_typeName='"+jComboBox5.getSelectedItem()+"'";
   
     try{ 
    //    Connection con = DriverManager
     //   .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
       //       + "user=root&password=527482");
         sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
  PreparedStatement pst=con.prepareStatement(sql1);
    ResultSet rs=pst.executeQuery();
   while(rs.next()){
   String x=rs.getString("Status_Active");
   jTextField6.setText(x);
   }
    

    }catch(Exception e){
         jTextField6.setText("");
        System.out.println("Type. not found)");}

}
 public void Userupdate(String x){
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update user_master set Status_Active='"+x+"' where user_Name='"+jComboBox2.getSelectedItem()+"' ";
       System.out.println("Nas");
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered User '" +jTextField2.getText()+ "' is succesfully reflected in User master db table ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(Exception e){
JOptionPane.showMessageDialog(null,
   " Entered User '" +jTextField2.getText()+ "' is failed to reflect in user db table ","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}
}

 public void Deptupdate(String x){
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update department set Status_Active='"+x+"' where department_Name='"+jComboBox1.getSelectedItem()+"' ";
       System.out.println("Nas");
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered Dept. '" +jTextField5.getText()+ "' is succesfully reflected in Dept master db table ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(Exception e){
JOptionPane.showMessageDialog(null,
   " Entered Dept. '" +jTextField5.getText()+ "' is failed to reflect in Dept db table ","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}
}

 public void Brandupdate(String x){
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update item_brandmaster set Status_Active='"+x+"' where item_brandName='"+jComboBox4.getSelectedItem()+"' ";
       System.out.println("Nas");
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered Brandtype '" +jTextField4.getText()+ "' is succesfully reflected in brand master db table ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(Exception e){
JOptionPane.showMessageDialog(null,
   " Entered Brandtype '" +jTextField4.getText()+ "' is failed to reflect in brand master db table ","Inane warning",
    JOptionPane.ERROR_MESSAGE);

}
}

 public void Itemupdate(String x){
  try{  
   //  Connection con = DriverManager
    //    .getConnection("jdbc:mysql://192.168.82.32:3306/inventory?"
           //  + "user=root&password=527482");System.out.println("000");
      sqlconnect sc=new sqlconnect();
      Connection con= sc.sqlconnect_con();
          Statement st=con.createStatement();
            String query = "update  item_typemaster set Status_Active='"+x+"' where item_typeName='"+jComboBox5.getSelectedItem()+"' ";
       System.out.println("Nas");
st.executeUpdate(query);
JOptionPane.showMessageDialog(null,
   " Entered Item type '" +jTextField6.getText()+ "' is succesfully reflected in itemtype master db table ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
    
   }catch(Exception e){
JOptionPane.showMessageDialog(null,
   " Entered item Type '" +jTextField6.getText()+ "' is failed to reflect in itemtype master db table ","Inane warning",
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField5 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jTextField6 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Master Management  Page");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Department Master ");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(new java.awt.Color(0, 102, 102));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Deptment.");

        jComboBox1.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jTextField5.setEditable(false);

        jLabel17.setBackground(new java.awt.Color(0, 102, 102));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Active?");

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Disable");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 102, 102));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Enable");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Company User's  Master");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setBackground(new java.awt.Color(0, 102, 102));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User");

        jComboBox2.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(0, 102, 102));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Active?");

        jTextField1.setEditable(false);

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Disable");
        jButton11.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButton11ItemStateChanged(evt);
            }
        });
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(0, 102, 102));
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Enable Again");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(0, 102, 102));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Companies Master");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Company");

        jComboBox3.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(0, 102, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Active?");

        jTextField3.setEditable(false);

        jButton9.setBackground(new java.awt.Color(0, 102, 102));
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("DELETE FOREVER (Reverse Not Possible)");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Brand Master");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Brand");

        jComboBox4.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jTextField4.setEditable(false);

        jLabel18.setBackground(new java.awt.Color(0, 102, 102));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Active?");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Disable");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Enable Again");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(0, 102, 102));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(0, 102, 102));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Item Type Master");
        jLabel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel11.setBackground(new java.awt.Color(0, 102, 102));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Type");

        jComboBox5.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jTextField6.setEditable(false);

        jLabel19.setBackground(new java.awt.Color(0, 102, 102));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Active?");

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Disable");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Enable Again");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(0, 102, 102));
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Divisions Master");
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setBackground(new java.awt.Color(0, 102, 102));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Division");

        jComboBox6.setBackground(new java.awt.Color(0, 102, 102));
        jComboBox6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select" }));
        jComboBox6.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox6ItemStateChanged(evt);
            }
        });

        jTextField2.setEditable(false);

        jLabel16.setBackground(new java.awt.Color(0, 102, 102));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Active?");

        jButton7.setBackground(new java.awt.Color(0, 102, 102));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("DELETE FOREVER (Reverse Not possible)");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(0, 102, 102));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));

        jButton13.setBackground(new java.awt.Color(0, 102, 102));
        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Go Home Page");
        jButton13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
         String msg,date;
        msg=jTextField7.getText();
       date= jTextField8.getText();
        this.setVisible(false);
        Inventory_Mainpage im=new Inventory_Mainpage(msg,date);
        im.setVisible(true);
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        String sql= "SELECT * FROM inventory_allocation where (inventory_company ='"+jComboBox3.getSelectedItem()+"' "
                + "&& Location_Status='ON_TRANSIT')" ;
        String sql1= "SELECT * FROM inventory_transfer where (inventory_ToCompany ='"+jComboBox3.getSelectedItem()+"' "
                + "&& Location_Status='ON_TRANSIT')" ;
     try{  sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
  ResultSet rs=stat.executeQuery(sql);
   if(rs.next()==true){
 JOptionPane.showMessageDialog(null,
   "The company has item transfers to other locations,Check in trasfer table & ask recepient company to accept or reject the transfer to continue with"
           + "company deletion ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int x=0/0;
    
   }  

   ResultSet rs1=stat.executeQuery(sql1);
   if(rs1.next()==true){
 JOptionPane.showMessageDialog(null,
   "The choosen company has reception for items from other locations,Check in trasfer table & either accept or reject the transfers to continue with"
           + "company deletion ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int x=0/0;
    
}   
   
         
          delete_Company_from_DBTable_user_ittranscnprevilege();
          delete_Company_from_DBTable_companydivisionbind();
     
          divisionUpdateToNo_Company();
          Company_Deletion_update();
        
       
        
        JOptionPane.showMessageDialog(null,
   " Success!!! Entered company '" +jComboBox3.getSelectedItem()+ "' Deletion Process is completed ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
     }catch(Exception e){
     JOptionPane.showMessageDialog(null,
   " Failed!!! Entered company '" +jComboBox3.getSelectedItem()+ "' is failed to update for deletion process in 1 or more db tables,Contact IT Department  ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
     
     }
        
    }//GEN-LAST:event_jButton9MouseClicked

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
      setActiveStatusCompany();  
        
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
      String sql= "SELECT * FROM inventory_allocation where (inventory_division ='"+jComboBox6.getSelectedItem()+"' "
                + "&& Location_Status='ON_TRANSIT')" ;
        String sql1= "SELECT * FROM inventory_transfer where (inventory_ToDiv ='"+jComboBox6.getSelectedItem()+"' "
                + "&& Location_Status='ON_TRANSIT')" ;
        String sql2= "SELECT * FROM inventory_allocation where (inventory_division ='"+jComboBox6.getSelectedItem()+"' "
                + "&& Location_Status='ON_STOCK')" ;
     try{  sqlconnect sc=new sqlconnect();
      Statement stat= sc.sqlconnect_stat();
  ResultSet rs=stat.executeQuery(sql);
   if(rs.next()==true){
 JOptionPane.showMessageDialog(null,
   "The Selected Division has item transfers to other locations,Check in trasfer table & ask recepient company to accept or reject the transfer to continue with"
           + "Division deletion ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int x=0/0;
    
}   

   ResultSet rs1=stat.executeQuery(sql1);
   if(rs1.next()==true){
 JOptionPane.showMessageDialog(null,
   "The choosen Division has reception for items from other locations,Check in trasfer table & either accept or reject the transfers to continue with"
           + "Division deletion ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int x=0/0;
    
}  
    ResultSet rs2=stat.executeQuery(sql2);
   if(rs2.next()==true){
 JOptionPane.showMessageDialog(null,
   "The choosen Division  has active stocks ,Kindly transfer to other locations or write off all stocks before continuing with"
           + "Division deletion ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
   int x=0/0;
    
}     
          
          
          
          delete_Division_from_DBTable_user_ittranscnprevilege();
delete_Division_from_DBTable_companydivisionbind();

          divisionUpdateToNo_Company_ForDiv();
Division_Deletion_update();
       
        
        JOptionPane.showMessageDialog(null,
   " Success!!! Entered Division '" +jComboBox6.getSelectedItem()+ "' Deletion Process is completed ","Inane warning",
    JOptionPane.PLAIN_MESSAGE);
     }catch(Exception e){
     JOptionPane.showMessageDialog(null,
   " Failed!!! Entered Division '" +jComboBox6.getSelectedItem()+ "' is failed to update for deletion process in 1 or more db tables,Contact IT Department  ","Inane warning",
    JOptionPane.ERROR_MESSAGE);
     
     }
    }//GEN-LAST:event_jButton7MouseClicked

    private void jComboBox6ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox6ItemStateChanged
        // TODO add your handling code here:
        setActiveStatusDivision();
    }//GEN-LAST:event_jComboBox6ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        
       setActiveStatusUser(); 
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        setActiveStatusDepartment();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        // TODO add your handling code here:
        setActiveStatusType();
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        // TODO add your handling code here:
        setActiveStatusBrand();
    }//GEN-LAST:event_jComboBox4ItemStateChanged

    private void jButton11ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jButton11ItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton11ItemStateChanged

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
        String x="NO";
        Userupdate(x);
        jComboBox2.setSelectedIndex(0); jTextField1.setText("");
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
          String x="YES";
        Userupdate(x);
        jComboBox2.setSelectedIndex(0);
        jTextField1.setText("");
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        String x="NO";
        Deptupdate(x);
        jComboBox1.setSelectedIndex(0); jTextField5.setText("");
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        String x="NO";
        Brandupdate(x);
        jComboBox4.setSelectedIndex(0); jTextField4.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        String x="YES";
        Brandupdate(x);
        jComboBox4.setSelectedIndex(0);
        jTextField4.setText("");
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        String x="YES";
        Itemupdate(x);
        jComboBox5.setSelectedIndex(0);
        jTextField6.setText("");
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
         String x="YES";
        Deptupdate(x);
        jComboBox1.setSelectedIndex(0);
        jTextField5.setText("");
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        String x="NO";
        Itemupdate(x);
        jComboBox1.setSelectedIndex(0);
        jTextField5.setText("");
    }//GEN-LAST:event_jButton5MouseClicked

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
            java.util.logging.Logger.getLogger(Master_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Master_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Master_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Master_Management.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Master_Management().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
