/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.ui;

import com.itpm.controller.CommonController;
import com.itpm.core.Validations;
import com.itpm.dao.impl.StudentGroupDaoImpl;
import com.itpm.model.StudentGroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anjula
 */
public class add_view_student_groups extends javax.swing.JFrame {

    int id;

    /**
     * Creates new form B
     */
    public add_view_student_groups() {
        initComponents();
        loaddataToTable();
    }

    private void addStudentGroup() {
        try {
            StudentGroup studentgroup = new StudentGroup();
            studentgroup.setGroupIdString(spinnerGroupNo.getValue().toString());
            studentgroup.setGroupNoString(txtGroupIdString.getText().trim());
            studentgroup.setSubGroupNoString(spinnerSubGroupNo.getValue().toString());
            studentgroup.setSubGroupIdString(txtSubGroupIdString.getText().trim());
            studentgroup.setAcademiYearSemester(txtAcademicYrSem.getText().trim());
            studentgroup.setProgram(comboProgram.getSelectedItem().toString());
            boolean status = new StudentGroupDaoImpl().addStudentGroup(studentgroup);
            if (status) {
                JOptionPane.showMessageDialog(this, "Student Group created successfully !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(add_view_student_groups.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loaddataToTable() {
        try {
            ResultSet rset = new StudentGroupDaoImpl().getAllStudentGroups();
            String columnList[] = {"student_id", "student_academic_year_and_sem", "student_programme", "student_group_no", "student_sub_group_no", "student_group_id", "student_sub_group_id"};
            CommonController.loadDataToTable(tblStudentGroupDetails, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(add_view_student_groups.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteStudentGroup() {
        int selectedRaw = tblStudentGroupDetails.getSelectedRow();
        if (selectedRaw != -1) {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tblStudentGroupDetails.getModel();
                int id = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
                new StudentGroupDaoImpl().deleteStudentGroup(id);
            } catch (SQLException ex) {
                Logger.getLogger(add_view_student_groups.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void cleardata() {
        txtAcademicYrSem.setText("");
        txtGroupIdString.setText("");
        txtSubGroupIdString.setText("");
        spinnerGroupNo.setValue(0);
        spinnerSubGroupNo.setValue(0);
        comboProgram.setSelectedIndex(0);
    }

    private void updateStudentGroup() {
        int selectedRaw = tblStudentGroupDetails.getSelectedRow();
        if (id != 0 && selectedRaw != -1) {
            try {
//                DefaultTableModel dtm = (DefaultTableModel) tblStudentGroupDetails.getModel();
//                int id = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
//                txtAcademicYrSem.setText(dtm.getValueAt(selectedRaw, 1).toString());
//                txtGroupIdString.setText(dtm.getValueAt(selectedRaw, 5).toString());
//                txtSubGroupIdString.setText(dtm.getValueAt(selectedRaw, 6).toString());
//                spinnerGroupNo.setValue(dtm.getValueAt(selectedRaw, 3).toString());
//                spinnerSubGroupNo.setValue(dtm.getValueAt(selectedRaw, 1).toString());
//                comboProgram.setSelectedItem(dtm.getValueAt(selectedRaw, 2).toString());

                StudentGroup studentgroup = new StudentGroup();
                studentgroup.setGroupIdString(spinnerGroupNo.getValue().toString());
                studentgroup.setGroupNoString(txtGroupIdString.getText().trim());
                studentgroup.setSubGroupIdString(spinnerSubGroupNo.getValue().toString());
                studentgroup.setSubGroupNoString(txtSubGroupIdString.getText().trim());
                studentgroup.setAcademiYearSemester(txtAcademicYrSem.getText().trim());
                studentgroup.setProgram(comboProgram.getSelectedItem().toString());
                studentgroup.setId(id);

                boolean status = new StudentGroupDaoImpl().updateStudentGroup(studentgroup);
                if (status) {
                    JOptionPane.showMessageDialog(this, "Student Group updated successfully !");
                }
            } catch (SQLException ex) {
                Logger.getLogger(add_view_student_groups.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAcademicYrSem = new javax.swing.JTextField();
        comboProgram = new javax.swing.JComboBox<>();
        spinnerGroupNo = new javax.swing.JSpinner();
        spinnerSubGroupNo = new javax.swing.JSpinner();
        txtSubGroupIdString = new javax.swing.JTextField();
        txtGroupIdString = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudentGroupDetails = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Student Groups");
        setMaximumSize(new java.awt.Dimension(1368, 718));
        setMinimumSize(new java.awt.Dimension(1368, 718));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Acedemic Year Semester");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Programme");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Group Number");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sub Group Number");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Group ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Sub Group ID");

        txtAcademicYrSem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboProgram.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboProgram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Programme 1 ", "Programme 2", "Programme 3", "Programme 4", "Programme 5", "Programme 6", "Programme 7", " " }));

        spinnerGroupNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        spinnerSubGroupNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSubGroupIdString.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtGroupIdString.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtGroupIdString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGroupIdStringActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblStudentGroupDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Academic Year Sem", "Programme", "Group No", "Sub Group No", "Group ID", "Sub Group ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudentGroupDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentGroupDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudentGroupDetails);
        if (tblStudentGroupDetails.getColumnModel().getColumnCount() > 0) {
            tblStudentGroupDetails.getColumnModel().getColumn(0).setMinWidth(0);
            tblStudentGroupDetails.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblStudentGroupDetails.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboProgram, javax.swing.GroupLayout.Alignment.LEADING, 0, 211, Short.MAX_VALUE)
                                    .addComponent(txtAcademicYrSem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerGroupNo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtGroupIdString, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerSubGroupNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(txtSubGroupIdString))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(spinnerSubGroupNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(txtGroupIdString, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSubGroupIdString, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAcademicYrSem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboProgram, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerGroupNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateStudentGroup();
        loaddataToTable();
        cleardata();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addStudentGroup();
        loaddataToTable();
        cleardata();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtGroupIdStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGroupIdStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGroupIdStringActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        deleteStudentGroup();
        loaddataToTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tblStudentGroupDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentGroupDetailsMouseClicked
        int selectedRaw = tblStudentGroupDetails.getSelectedRow();

        if (selectedRaw != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tblStudentGroupDetails.getModel();
            id = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
            txtAcademicYrSem.setText(dtm.getValueAt(selectedRaw, 1).toString());
            txtGroupIdString.setText(dtm.getValueAt(selectedRaw, 3).toString());
            txtSubGroupIdString.setText(dtm.getValueAt(selectedRaw, 4).toString());
            spinnerGroupNo.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 5).toString()));
            spinnerSubGroupNo.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 6).toString()));
            comboProgram.setSelectedItem(dtm.getValueAt(selectedRaw, 2).toString());
        }
    }//GEN-LAST:event_tblStudentGroupDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(add_view_student_groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_view_student_groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_view_student_groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_view_student_groups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_view_student_groups().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboProgram;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerGroupNo;
    private javax.swing.JSpinner spinnerSubGroupNo;
    private javax.swing.JTable tblStudentGroupDetails;
    private javax.swing.JTextField txtAcademicYrSem;
    private javax.swing.JTextField txtGroupIdString;
    private javax.swing.JTextField txtSubGroupIdString;
    // End of variables declaration//GEN-END:variables
}
