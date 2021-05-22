/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.ui;

import com.itpm.controller.CommonController;
import com.itpm.core.Validations;
import com.itpm.dao.impl.WorkingDayDaoImpl;
import com.itpm.model.WorkingDay;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anjula
 */
public class add_view_working_days_hours extends javax.swing.JFrame {

    int id;

    /**
     * Creates new form A
     */
    public add_view_working_days_hours() {
        initComponents();
        loadDataToTable();
    }

    private void setValues() {
        try {
            WorkingDay workingDay = new WorkingDayDaoImpl().getWorkingDayById(1);
            spinnerWorkingDays.setValue(workingDay.getNoOfWorkingDays());
            chkMonday.setSelected(workingDay.isMonday());
            chkTuesday.setSelected(workingDay.isTuesday());
            chkWednesday.setSelected(workingDay.isWednesday());
            chkThursday.setSelected(workingDay.isThursday());
            chkFriday.setSelected(workingDay.isFriday());
            chkSaturday.setSelected(workingDay.isSaturday());
            chkSunday.setSelected(workingDay.isSunday());
            spinnerHoursPerDay.setValue(workingDay.getHours());
            spinnerMinutesPerday.setValue(workingDay.getMinutes());
            txtAmount.setText(workingDay.getDayAmount().toString());
        } catch (SQLException ex) {
            Logger.getLogger(add_view_working_days_hours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void updateWornkgdaysAndHours() {
        try {
            WorkingDay workday = new WorkingDay();
            workday.setDayAmount(Validations.getBigDecimalOrZeroFromString(txtAmount.getText().trim()));
            workday.setNoOfWorkingDays(Validations.getIntOrZeroFromString(spinnerWorkingDays.getValue().toString()));
            workday.setHours(Validations.getIntOrZeroFromString(spinnerHoursPerDay.getValue().toString()));
            workday.setMinutes(Validations.getIntOrZeroFromString(spinnerMinutesPerday.getValue().toString()));
            workday.setMonday(chkMonday.isSelected());
            workday.setTuesday(chkTuesday.isSelected());
            workday.setWednesday(chkWednesday.isSelected());
            workday.setThursday(chkThursday.isSelected());
            workday.setFriday(chkFriday.isSelected());
            workday.setSaturday(chkSunday.isSelected());
            workday.setSunday(chkSaturday.isSelected());
            workday.setId(id);
            new WorkingDayDaoImpl().updateWorkingHoursAnddays(workday);
        } catch (SQLException ex) {
            Logger.getLogger(add_view_working_days_hours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addWorkingDaysAndHours() {
        try {
            WorkingDay workday = new WorkingDay();
            workday.setDayAmount(Validations.getBigDecimalOrZeroFromString(txtAmount.getText().trim()));
            workday.setNoOfWorkingDays(Validations.getIntOrZeroFromString(spinnerWorkingDays.getValue().toString()));
            workday.setHours(Validations.getIntOrZeroFromString(spinnerHoursPerDay.getValue().toString()));
            workday.setMinutes(Validations.getIntOrZeroFromString(spinnerMinutesPerday.getValue().toString()));
            workday.setMonday(chkMonday.isSelected());
            workday.setTuesday(chkTuesday.isSelected());
            workday.setWednesday(chkWednesday.isSelected());
            workday.setThursday(chkThursday.isSelected());
            workday.setFriday(chkFriday.isSelected());
            workday.setSaturday(chkSunday.isSelected());
            workday.setSunday(chkSaturday.isSelected());
            new WorkingDayDaoImpl().addWorkingHoursAnddays(workday);
        } catch (SQLException ex) {
            Logger.getLogger(add_view_working_days_hours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToTable() {
        try {
            ResultSet rset = new WorkingDayDaoImpl().getAllRecords();
            String columnList[] = {"working_day_id", "working_day_monday", "working_day_tuesday", "working_day_wednesday",
                "working_day_thursday", "working_day_friday", "working_day_saturday", "working_day_sunday",
                "working_day_no_work_days", "working_day_hours", "working_day_minutes", "working_day_amount"};
            CommonController.loadDataToTable(tblWorkingHours, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(add_view_working_days_hours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearData() {
        spinnerWorkingDays.setValue(0);
        chkMonday.setSelected(false);
        chkTuesday.setSelected(false);
        chkWednesday.setSelected(false);
        chkThursday.setSelected(false);
        chkFriday.setSelected(false);
        chkSaturday.setSelected(false);
        chkSunday.setSelected(false);
        spinnerHoursPerDay.setValue(0);
        spinnerMinutesPerday.setValue(0);
        txtAmount.setText("0");
    }

    private void deleteData() {
        int selectedRw = tblWorkingHours.getSelectedRow();
        if (selectedRw != -1) {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tblWorkingHours.getModel();
                new WorkingDayDaoImpl().deleteWorkingHoursAnddays(
                        Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 0).toString()));
            } catch (SQLException ex) {
                Logger.getLogger(add_view_working_days_hours.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btUpdate = new javax.swing.JButton();
        spinnerWorkingDays = new javax.swing.JSpinner();
        spinnerHoursPerDay = new javax.swing.JSpinner();
        spinnerMinutesPerday = new javax.swing.JSpinner();
        chkMonday = new javax.swing.JCheckBox();
        chkWednesday = new javax.swing.JCheckBox();
        chkTuesday = new javax.swing.JCheckBox();
        chkFriday = new javax.swing.JCheckBox();
        chkThursday = new javax.swing.JCheckBox();
        chkSaturday = new javax.swing.JCheckBox();
        chkSunday = new javax.swing.JCheckBox();
        txtAmount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkingHours = new javax.swing.JTable();
        btUpdate1 = new javax.swing.JButton();
        btUpdate2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Working Days And Hours");
        setMaximumSize(new java.awt.Dimension(1272, 681));
        setMinimumSize(new java.awt.Dimension(1272, 681));
        setPreferredSize(new java.awt.Dimension(1272, 681));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("No of Working Days");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 39, 152, 29));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Working Days");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 109, 152, 31));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Working Time Per Day");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 29));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hours");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 394, 75, 29));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Minutes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 434, 75, 29));

        btUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btUpdate.setText("Save");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 100, 40));

        spinnerWorkingDays.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(spinnerWorkingDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 39, 120, 29));

        spinnerHoursPerDay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(spinnerHoursPerDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 394, 152, 29));

        spinnerMinutesPerday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(spinnerMinutesPerday, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 434, 152, 29));

        chkMonday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkMonday.setText("Monday");
        jPanel1.add(chkMonday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 110, 120, 29));

        chkWednesday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkWednesday.setText("Wednesday");
        chkWednesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkWednesdayActionPerformed(evt);
            }
        });
        jPanel1.add(chkWednesday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 174, 120, 29));

        chkTuesday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkTuesday.setText("Tuesday");
        jPanel1.add(chkTuesday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 142, 120, 29));

        chkFriday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkFriday.setText("Friday");
        chkFriday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFridayActionPerformed(evt);
            }
        });
        jPanel1.add(chkFriday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 238, 120, 29));

        chkThursday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkThursday.setText("Thursday");
        jPanel1.add(chkThursday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 206, 120, 29));

        chkSaturday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkSaturday.setText("Saturday");
        jPanel1.add(chkSaturday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 270, 120, 29));

        chkSunday.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chkSunday.setText("Sunday");
        jPanel1.add(chkSunday, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 302, 120, 29));
        jPanel1.add(txtAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 240, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Amount");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 29));

        tblWorkingHours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Working Days", "Hours", "Minutes", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWorkingHours.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWorkingHoursMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblWorkingHours);
        if (tblWorkingHours.getColumnModel().getColumnCount() > 0) {
            tblWorkingHours.getColumnModel().getColumn(0).setMinWidth(0);
            tblWorkingHours.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblWorkingHours.getColumnModel().getColumn(0).setMaxWidth(0);
            tblWorkingHours.getColumnModel().getColumn(1).setResizable(false);
            tblWorkingHours.getColumnModel().getColumn(2).setResizable(false);
            tblWorkingHours.getColumnModel().getColumn(3).setResizable(false);
            tblWorkingHours.getColumnModel().getColumn(4).setResizable(false);
            tblWorkingHours.getColumnModel().getColumn(5).setResizable(false);
            tblWorkingHours.getColumnModel().getColumn(6).setResizable(false);
            tblWorkingHours.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 850, 550));

        btUpdate1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btUpdate1.setText("Update");
        btUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdate1ActionPerformed(evt);
            }
        });
        jPanel1.add(btUpdate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 100, 40));

        btUpdate2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btUpdate2.setText("Delete");
        btUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdate2ActionPerformed(evt);
            }
        });
        jPanel1.add(btUpdate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chkWednesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkWednesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkWednesdayActionPerformed

    private void chkFridayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFridayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkFridayActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        addWorkingDaysAndHours();
        loadDataToTable();
        clearData();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void btUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdate1ActionPerformed
        updateWornkgdaysAndHours();
        loadDataToTable();
        clearData();
    }//GEN-LAST:event_btUpdate1ActionPerformed

    private void btUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdate2ActionPerformed
        deleteData();
        clearData();
        loadDataToTable();
    }//GEN-LAST:event_btUpdate2ActionPerformed

    private void tblWorkingHoursMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWorkingHoursMouseClicked
        int selectedRw = tblWorkingHours.getSelectedRow();
        if (selectedRw != -1) {
            //name = city.getName() == null ? city.getName() : "N/A"
            DefaultTableModel dtm = (DefaultTableModel) tblWorkingHours.getModel();
            spinnerWorkingDays.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 8).toString()));
            chkMonday.setSelected(dtm.getValueAt(selectedRw, 1).toString().equalsIgnoreCase("1") ? true : false);
            chkTuesday.setSelected(dtm.getValueAt(selectedRw, 2).toString().equalsIgnoreCase("1") ? true : false);
            chkWednesday.setSelected(dtm.getValueAt(selectedRw, 3).toString().equalsIgnoreCase("1") ? true : false);
            chkThursday.setSelected(dtm.getValueAt(selectedRw, 4).toString().equalsIgnoreCase("1") ? true : false);
            chkFriday.setSelected(dtm.getValueAt(selectedRw, 5).toString().equalsIgnoreCase("1") ? true : false);
            chkSaturday.setSelected(dtm.getValueAt(selectedRw, 6).toString().equalsIgnoreCase("1") ? true : false);
            chkSunday.setSelected(dtm.getValueAt(selectedRw, 7).toString().equalsIgnoreCase("1") ? true : false);
            spinnerHoursPerDay.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 9).toString()));
            spinnerMinutesPerday.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 10).toString()));
            txtAmount.setText(dtm.getValueAt(selectedRw, 11).toString());
            id = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 0).toString());
        }
    }//GEN-LAST:event_tblWorkingHoursMouseClicked

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
            java.util.logging.Logger.getLogger(add_view_working_days_hours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_view_working_days_hours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_view_working_days_hours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_view_working_days_hours.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new add_view_working_days_hours().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btUpdate1;
    private javax.swing.JButton btUpdate2;
    private javax.swing.JCheckBox chkFriday;
    private javax.swing.JCheckBox chkMonday;
    private javax.swing.JCheckBox chkSaturday;
    private javax.swing.JCheckBox chkSunday;
    private javax.swing.JCheckBox chkThursday;
    private javax.swing.JCheckBox chkTuesday;
    private javax.swing.JCheckBox chkWednesday;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerHoursPerDay;
    private javax.swing.JSpinner spinnerMinutesPerday;
    private javax.swing.JSpinner spinnerWorkingDays;
    private javax.swing.JTable tblWorkingHours;
    private javax.swing.JTextField txtAmount;
    // End of variables declaration//GEN-END:variables
}
