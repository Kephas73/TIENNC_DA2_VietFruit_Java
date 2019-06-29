/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Employee_Controller;
import Model.Employee_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kephas73
 */
public class frmEmployee extends javax.swing.JInternalFrame {

      Employee_Controller employee_Controller= new  Employee_Controller();
      Employee_Model employee_Model= new Employee_Model();
      boolean Status =false;
    /**
     * Creates new form frmEmployee
     */
    public frmEmployee() throws SQLException {
        initComponents();
        List_Employee();
        Status_bt(true);
        Status_txt(false);
    }

     public void Status_txt(boolean st )
    {
        // txt_Mincode.enable(st);
        txt_name.setEnabled(st);
        cm_Sex.setEnabled(st);
        txt_phone.setEnabled(st);
        txt_idCard.setEnabled(st);
        txt_email.setEnabled(st);
        txt_address.setEnabled(st);
        txt_salary.setEnabled(st);
        cm_position.setEnabled(st);
       // txt_Origin.setEnabled(st);
    }
    public void Remove_txt()
    {
        
        txt_name.setText("");
        txt_phone.setText("");
        txt_salary.setText("");
        txt_idCard.setText("");
        txt_address.setText("");
        txt_email.setText("");        
    }
    public void Status_bt(boolean st)
    {
        btt_Insert.setEnabled(st);
        btt_Update.setEnabled(st);
        btt_Delete.setEnabled(st);
        btt_Save.setEnabled(!st);
        btt_Back.setEnabled(!st);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     public void List_Employee() throws SQLException{
      
        ResultSet rs=employee_Controller.List_Employee();
         String[] arr = {"Min code", "Name","Sex","Date of birth","Phone","ID Card","Salary","Email","Address","Position"};
        DefaultTableModel tableModel = new DefaultTableModel(arr, 0);
          tb_ListEmployee.setModel(tableModel);
         try {
            while (rs.next()) {
                 Vector vt= new Vector();
                 vt.add(rs.getString("MA_NHAN_VIEN"));
                  vt.add(rs.getString("TEN_NHAN_VIEN"));
                   vt.add(rs.getString("GIOI_TINH"));
                    vt.add(rs.getDate("NGAY_SINH"));
                    vt.add(rs.getString("SO_DIEN_THOAI")); 
                     vt.add(rs.getString("SCMND"));
                     vt.add(rs.getFloat("LUONG_CO_BAN"));
                    vt.add(rs.getString("EMAIL"));
                    vt.add(rs.getString("DIA_CHI"));
                    vt.add(rs.getString("TEN_BO_PHAN"));
                tableModel.addRow(vt);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ListEmployee = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btt_Insert = new javax.swing.JButton();
        btt_Update = new javax.swing.JButton();
        btt_Delete = new javax.swing.JButton();
        btt_Save = new javax.swing.JButton();
        btt_Back = new javax.swing.JButton();
        txt_minCode = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_idCard = new javax.swing.JTextField();
        txt_DateB = new com.toedter.calendar.JDateChooser();
        txt_email = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        cm_Sex = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        txt_salary = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cm_position = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cm_Search = new javax.swing.JComboBox();
        txt_Search = new javax.swing.JTextField();
        bttSearch = new javax.swing.JButton();

        setClosable(true);
        setTitle("Employee Management");
        setPreferredSize(new java.awt.Dimension(1191, 590));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " List of employee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(51, 51, 255))); // NOI18N

        tb_ListEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Min code", "Name", "Sex", "Date of bỉrth", "Phone", "ID Card", "Salary", "Email", "Address", "Position"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tb_ListEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ListEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ListEmployee);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Properties", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Min code:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Phone:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sex:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ID Card:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Date of birth:");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(51, 51, 255))); // NOI18N

        btt_Insert.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btt_Insert.setText("Insert");
        btt_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_InsertActionPerformed(evt);
            }
        });

        btt_Update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btt_Update.setText("Update");
        btt_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_UpdateActionPerformed(evt);
            }
        });

        btt_Delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btt_Delete.setText("Delete");
        btt_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_DeleteActionPerformed(evt);
            }
        });

        btt_Save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btt_Save.setText("Save");
        btt_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_SaveActionPerformed(evt);
            }
        });

        btt_Back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btt_Back.setText("Back");
        btt_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btt_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btt_Insert)
                .addGap(18, 18, 18)
                .addComponent(btt_Update)
                .addGap(18, 18, 18)
                .addComponent(btt_Delete)
                .addGap(18, 18, 18)
                .addComponent(btt_Save)
                .addGap(18, 18, 18)
                .addComponent(btt_Back)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btt_Insert)
                    .addComponent(btt_Update)
                    .addComponent(btt_Delete)
                    .addComponent(btt_Save)
                    .addComponent(btt_Back))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        txt_minCode.setEnabled(false);

        txt_DateB.setDateFormatString("dd-MM-yyyy");

        cm_Sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Salary:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Position:");

        cm_position.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cashier", "Stockkeeper" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_minCode))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_idCard))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(3, 3, 3)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cm_Sex, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_DateB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txt_salary)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cm_position, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(45, 45, 45)))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel9)
                        .addComponent(txt_minCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_DateB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cm_Sex, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txt_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_idCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cm_position, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Search:");

        cm_Search.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Min code", "Name" }));

        bttSearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\nguye\\Downloads\\icons8-search-26.png")); // NOI18N
        bttSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cm_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttSearch)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(cm_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bttSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_ListEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ListEmployeeMouseClicked
        // TODO add your handling code here:
         int index=tb_ListEmployee.getSelectedRow();
        txt_minCode.setText(tb_ListEmployee.getValueAt(index, 0).toString());
        txt_name.setText(tb_ListEmployee.getValueAt(index, 1).toString());
        //System.out.println(tb_ListEmployee.getValueAt(index, 2).toString());
        if(tb_ListEmployee.getValueAt(index, 2).toString().compareTo("Nam")==0)
        {
            cm_Sex.setSelectedIndex(0);
        }
        else
        {
            cm_Sex.setSelectedIndex(1);
        }
        txt_DateB.setDate((Date) tb_ListEmployee.getValueAt(index, 3));
        txt_phone.setText(tb_ListEmployee.getValueAt(index, 4).toString());
        txt_idCard.setText(tb_ListEmployee.getValueAt(index, 5).toString());
        txt_salary.setText(tb_ListEmployee.getValueAt(index, 6).toString());
        txt_email.setText(tb_ListEmployee.getValueAt(index, 7).toString());
        txt_address.setText(tb_ListEmployee.getValueAt(index, 8).toString());
        if(tb_ListEmployee.getValueAt(index, 9).toString().compareTo("Thu ngân")==0)
        {
            cm_position.setSelectedIndex(0);
        }
        else
        {
            cm_position.setSelectedIndex(1);
        }
      
    }//GEN-LAST:event_tb_ListEmployeeMouseClicked

    private void btt_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_InsertActionPerformed
       Status_txt(true);
        Status_bt(false);
        txt_minCode.setText(employee_Controller.Auto_Increment_Mincode());
        Remove_txt();
         Status=true;
    }//GEN-LAST:event_btt_InsertActionPerformed

    private void btt_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_UpdateActionPerformed
        // TODO add your handling code here:
         Status_txt(true);
        Status_bt(false);
        Status=false;
       
    }//GEN-LAST:event_btt_UpdateActionPerformed

    private void btt_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_DeleteActionPerformed
        // TODO add your handling code here:
        int window = JOptionPane.showConfirmDialog(
            null, 
            "Do you want to delete the employee", 
            "Notification", 
            JOptionPane.YES_NO_OPTION);
        if(window == JOptionPane.YES_OPTION)
        {
            try {
                employee_Model.setMincode(txt_minCode.getText());
                employee_Controller.Delete_Employee(employee_Model);
                JOptionPane.showMessageDialog(null,"Successfully deleted!");
                List_Employee();
                Status_txt(false);
                Status_bt(true);
            } catch (SQLException ex) {
                Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btt_DeleteActionPerformed

    private void btt_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_SaveActionPerformed

         try {
              // TODO add your handling code here:
                //SimpleDateFormat fm= new SimpleDateFormat("dd-MM-yyyy");
               String Birthday = DateFormat.getDateInstance().format(txt_DateB.getDate());
              // String Expiration = DateFormat.getDateInstance().format(txt_Edate.getDate());
              employee_Model.setMincode(txt_minCode.getText());
              employee_Model.setName(txt_name.getText());
              employee_Model.setBirthday(Birthday);
              
              if(cm_Sex.getSelectedItem().toString().compareTo("Male")==0)
              {
                  employee_Model.setSex("Nam");
              }
              else{
                  employee_Model.setSex("Nữ");
              }
              employee_Model.setPhone(txt_phone.getText());
              employee_Model.setIDCard(txt_idCard.getText());
              employee_Model.setSalary(Float.valueOf(txt_salary.getText()));
              employee_Model.setEmail(txt_email.getText());
              employee_Model.setAddress(txt_address.getText());
              employee_Model.setImage("NULL"); 
               if(cm_position.getSelectedItem().toString().compareTo("Cashier")==0)
              {
                  employee_Model.setPosition("Thu ngân");
              }
              else{
                  employee_Model.setPosition("Quản lý kho");
              }
              if(Status==true)
              {
                  employee_Controller.Add_Employee(employee_Model);
                    JOptionPane.showMessageDialog(null,"Successfully add!");
                  
              }
              else{
                  employee_Controller.Update_Employee(employee_Model);
                    JOptionPane.showMessageDialog(null,"Successfully update!");
              }
              
              List_Employee();
              Status_txt(false);
              Status_bt(true);
              Remove_txt(); 
          } catch (SQLException ex) {
              Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_btt_SaveActionPerformed

    private void btt_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btt_BackActionPerformed
        // TODO add your handling code here:
          try {
              
              List_Employee();
              Status_txt(false);
              Status_bt(true);
              Remove_txt(); 
          } catch (SQLException ex) {
              Logger.getLogger(frmEmployee.class.getName()).log(Level.SEVERE, null, ex);
          }
      
    }//GEN-LAST:event_btt_BackActionPerformed

    private void bttSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSearchActionPerformed
        // TODO add your handling code here:
        
         ResultSet rs = null;
        if(cm_Search.getSelectedItem().toString()=="Name")
        {
              rs=employee_Controller.Search_Name(txt_Search.getText());
        }
        else
        {
              rs=employee_Controller.Search_Mincode(txt_Search.getText());
        }
          String[] arr = {"Min code", "Name","Sex","Date of birth","Phone","ID Card","Salary","Email","Address","Position"};
        DefaultTableModel tableModel = new DefaultTableModel(arr, 0);
          tb_ListEmployee.setModel(tableModel);
         try {
            while (rs.next()) {
                   Vector vt= new Vector();
                 vt.add(rs.getString("MA_NHAN_VIEN"));
                  vt.add(rs.getString("TEN_NHAN_VIEN"));
                   vt.add(rs.getString("GIOI_TINH"));
                    vt.add(rs.getDate("NGAY_SINH"));
                    vt.add(rs.getString("SO_DIEN_THOAI")); 
                     vt.add(rs.getString("SCMND"));
                     vt.add(rs.getFloat("LUONG_CO_BAN"));
                    vt.add(rs.getString("EMAIL"));
                    vt.add(rs.getString("DIA_CHI"));
                    vt.add(rs.getString("TEN_BO_PHAN"));
                tableModel.addRow(vt);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
      
    }//GEN-LAST:event_bttSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttSearch;
    private javax.swing.JButton btt_Back;
    private javax.swing.JButton btt_Delete;
    private javax.swing.JButton btt_Insert;
    private javax.swing.JButton btt_Save;
    private javax.swing.JButton btt_Update;
    private javax.swing.JComboBox cm_Search;
    private javax.swing.JComboBox cm_Sex;
    private javax.swing.JComboBox cm_position;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tb_ListEmployee;
    private com.toedter.calendar.JDateChooser txt_DateB;
    private javax.swing.JTextField txt_Search;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_idCard;
    private javax.swing.JTextField txt_minCode;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_salary;
    // End of variables declaration//GEN-END:variables
}
