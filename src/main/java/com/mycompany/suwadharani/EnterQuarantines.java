/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.suwadharani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Janitha Theekshana
 */
public class EnterQuarantines extends javax.swing.JFrame {

   
    public EnterQuarantines() {
        initComponents();
        table2();
        delete();
    }
    
     public void clear()
    {
    FID.setText("");
    name.setText("");
    add.setText("");
    dob.setText("");
    buttonGroup1.clearSelection();
    vac1.setText("");
    vac_name.setText("");
    vac_doss.setText("");
    jComboBox1.setSelectedIndex(0);
    start.setCalendar(null);
    end.setCalendar(null);
    }
     
     public void delete()
     {
     try{
          SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();
	String s = dtf.format(date);
         
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddb","root","");
            //PreparedStatement ps = con.prepareStatement("DELETE FROM village_citizen WHERE name = name");
              PreparedStatement ps = con.prepareStatement("DELETE FROM quarantine_people WHERE Quarantine_end_date = 's' ");
              ps.executeUpdate();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
     }

     public void table(){
              DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
              model.setRowCount(0);
              String fid = jTextField1.getText();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddb","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name, address, DOB, gender, vaccinate, vaccine_name,vaccine_doss from village_citizen where family_id='"+fid+"'");
            
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)}) ;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
       }
     
      public void table2()
    {
          DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
              model.setRowCount(0);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddb","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from quarantine_people");
            
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12)}) ;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void ID()
    {
          try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddb","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select count(QP_ID) from quarantine_people");
            if(rs.next())
            {
                int regNo = rs.getInt(1);
                regNo = regNo+1;
                String str = String.valueOf(regNo);
                qid.setText(str);
            }
            else
                qid.setText("1");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        add = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        FID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        vac_doss = new javax.swing.JTextField();
        vac_name = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        male = new javax.swing.JRadioButton();
        start = new com.toedter.calendar.JDateChooser();
        end = new com.toedter.calendar.JDateChooser();
        vac1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        qid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 100));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1260, 640));

        jPanel1.setBackground(new java.awt.Color(27, 155, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 55)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 155, 255));
        jLabel1.setText("Quarantine Peoples Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 70));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("X");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 80, 40, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Family Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 100, 30));

        jButton1.setBackground(new java.awt.Color(255, 0, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Address", "Date of Birth", "Gender", "Vaccinate", "Vaccine Name", "Vaccine Doss"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 940, 140));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 1260, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Vaccine Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 160, 20));

        name.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 240, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText(" Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 160, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Gender");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 443, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText(" Vaccine doss");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 160, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Qurantine People ID : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 160, 20));

        add.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 240, 30));

        dob.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 140, 20));

        FID.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPanel1.add(FID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 70, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("PCR Result");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 160, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Qurantine Start Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Qurantine End Date");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText(" Vaccinate");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 150, 20));

        vac_doss.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPanel1.add(vac_doss, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 140, 20));

        vac_name.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jPanel1.add(vac_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 140, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Q_id", "Family id", "Name", "Address", "DOB", "Gender", "Vaccinate", "Vaccine Name", "Vaccine Doss", "PCR Result", "Q Start Date", "Q End Date"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 830, 270));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Positive", "Negative", "Not Yet" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 140, 20));

        jButton2.setBackground(new java.awt.Color(204, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, -1, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("EDIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, 80, -1));

        jButton4.setBackground(new java.awt.Color(0, 255, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("ENTER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("DOB");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 160, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText(" Address");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 160, 20));

        female.setBackground(new java.awt.Color(27, 155, 255));
        buttonGroup1.add(female);
        female.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        female.setForeground(new java.awt.Color(255, 255, 255));
        female.setText("Female");
        female.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                femaleItemStateChanged(evt);
            }
        });
        jPanel1.add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        male.setBackground(new java.awt.Color(27, 155, 255));
        buttonGroup1.add(male);
        male.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        male.setForeground(new java.awt.Color(255, 255, 255));
        male.setText("Male");
        male.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                maleItemStateChanged(evt);
            }
        });
        jPanel1.add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, -1, -1));
        jPanel1.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, 140, -1));
        jPanel1.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, 140, -1));

        vac1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jPanel1.add(vac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 140, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Family ID");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 160, 20));

        qid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        qid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(qid, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 60, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        
     int a= JOptionPane.showConfirmDialog(this,"Do you really want to close this page","Close",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
     if(a==0)
     {
          setVisible(false);
     }    
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        String id = jTextField1.getText();
        FID.setText(id);
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        name.setText(model.getValueAt(i,0).toString());
        add.setText(model.getValueAt(i,1).toString());
        dob.setText(model.getValueAt(i,2).toString());
        String gender = model.getValueAt(i,3).toString();
         if(gender.equals("Male")){
             male.setSelected(true);
         }
         else{
             female.setSelected(true);
         }
        vac1.setText(model.getValueAt(i,4).toString());
        vac_name.setText(model.getValueAt(i,5).toString());
        vac_doss.setText(model.getValueAt(i,6).toString());
        ID();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String Q_id = qid.getText();
        
        
        String family_id = FID.getText();
        String Name = name.getText();
        String address = add.getText();
        String DOB = dob.getText();
        String vaccinate = vac1.getText();
        String vaccine_name = vac_name.getText();
        String vaccine_doss = vac_doss.getText();
        String Result = (String)jComboBox1.getSelectedItem();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
        String SDate = sdf1.format(start.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        String EDate = sdf.format(end.getDate());
        
         try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection con = (java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddb","root","");
            PreparedStatement ps = con.prepareStatement("INSERT INTO quarantine_people VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, Q_id);
            ps.setString(2, family_id);
            ps.setString(3, Name);
            ps.setString(4, address);
            ps.setString(5, DOB);
            ps.setString(6, gender);
            ps.setString(7, vaccinate);
            ps.setString(8, vaccine_name);
            ps.setString(9, vaccine_doss);
             ps.setString(10, Result);
            ps.setString(11, SDate);
            ps.setString(12, EDate);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            clear();
            table2();
            ID();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void maleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_maleItemStateChanged
        // TODO add your handling code here:
        gender = "Male";
    }//GEN-LAST:event_maleItemStateChanged

    private void femaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_femaleItemStateChanged
        // TODO add your handling code here:
        gender = "Female";
    }//GEN-LAST:event_femaleItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         int a= JOptionPane.showConfirmDialog(this,"Do you really want to clear all rows","Clear",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
     if(a==0)
     {
          clear();
     }    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        qid.setText(model.getValueAt(i,0).toString());
        FID.setText(model.getValueAt(i,1).toString());
        name.setText(model.getValueAt(i,2).toString());
        add.setText(model.getValueAt(i,3).toString());
        dob.setText(model.getValueAt(i,4).toString());
        String gender = model.getValueAt(i,5).toString();
         if(gender.equals("Male")){
             male.setSelected(true);
         }
         else{
             female.setSelected(true);
         }
         vac1.setText(model.getValueAt(i,6).toString());
         vac_name.setText(model.getValueAt(i,7).toString());
         vac_doss.setText(model.getValueAt(i,8).toString());
         String result = model.getValueAt(i, 9).toString();
            switch(result){
                case "Positive":
                        jComboBox1.setSelectedIndex(0);
                        break;
                case "Negative":
                        jComboBox1.setSelectedIndex(1);
                        break;
                default:
                        jComboBox1.setSelectedIndex(2);
            }
        try { 
            java.util.Date date1 =new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 10).toString());
            start.setDate(date1);
        } catch (ParseException ex) {
            Logger.getLogger(EnterAllCitizenDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        try { 
            java.util.Date date2 =new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i, 11).toString());
            end.setDate(date2);
        } catch (ParseException ex) {
            Logger.getLogger(EnterAllCitizenDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterQuarantines().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FID;
    private javax.swing.JTextField add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dob;
    private com.toedter.calendar.JDateChooser end;
    private javax.swing.JRadioButton female;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField name;
    private javax.swing.JLabel qid;
    private com.toedter.calendar.JDateChooser start;
    private javax.swing.JTextField vac1;
    private javax.swing.JTextField vac_doss;
    private javax.swing.JTextField vac_name;
    // End of variables declaration//GEN-END:variables
    private String gender;
}
