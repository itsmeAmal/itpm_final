/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.ui;

import com.itpm.controller.CommonController;
import com.itpm.controller.SubjectController;
import com.itpm.core.Validations;
import com.itpm.dao.impl.SubjectDaoImpl;
import com.itpm.model.Subject;
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
public class add_view_subjects extends javax.swing.JFrame {

    int id;

    /**
     * Creates new form A
     */
    public add_view_subjects() {
        initComponents();
        loadDataToTable();
    }

    private void clearSubjectDetails() {
        comboOfferedYear.setSelectedIndex(-1);
        txtSubjectCode.setText("");
        txtSubjectName.setText("");
        spinnerLectuerHours.setValue(Integer.valueOf(0));
        spinnerTutorialHours.setValue(Integer.valueOf(0));
        spinnerLabHours.setValue(Integer.valueOf(0));
        spinnerEvaluationHours.setValue(0);
        radioSemster1.setSelected(false);
        radioSemster2.setSelected(false);
    }

    private void addSubject() {
        try {
            int offeredSemester = 0;
            if (radioSemster1.isSelected()) {
                offeredSemester = 1;
            }
            if (radioSemster2.isSelected()) {
                offeredSemester = 2;
            }
            if (comboOfferedYear.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Please select the subject offered Year", "Error !!", JOptionPane.ERROR_MESSAGE);
            }
            if (txtSubjectName.getText().trim() == null | txtSubjectName.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Subject Name");
            }
            if (txtSubjectCode.getText().trim() == null | txtSubjectCode.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please Enter the Suject Code", "Error !", JOptionPane.ERROR_MESSAGE);
            }

            boolean status = SubjectController.addSubject(txtSubjectCode.getText().trim(),
                    txtSubjectName.getText().trim(),
                    Validations.getIntOrZeroFromString(comboOfferedYear.getSelectedItem().toString().trim()),
                    offeredSemester, Integer.parseInt(spinnerLectuerHours.getValue().toString()),
                    Integer.parseInt(spinnerTutorialHours.getValue().toString()),
                    Integer.parseInt(spinnerLabHours.getValue().toString()),
                    Integer.parseInt(spinnerEvaluationHours.getValue().toString()));
            if (status) {
                JOptionPane.showMessageDialog(this, "Subject Added Sucessfully!!!!", "sucess !", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(add_view_subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToTable() {
        try {
            ResultSet rs = SubjectController.getAllSubjects();
            String[] columnList = {"subject_id", "subject_name", "subject_code", "subject_offered_year", "subject_offered_semester", "subject_lecture_hours_amount", "subject_tutorial_hours", "subject_lab_hours", "subject_evaluation_hours"};
            CommonController.loadDataToTable(tblSubjects, rs, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(add_view_subjects.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void deleteSubject() {
        int selectedRw = tblSubjects.getSelectedRow();
        if (selectedRw != -1) {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tblSubjects.getModel();
                new SubjectDaoImpl().deleteSubject(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 0).toString()));
            } catch (SQLException ex) {
                Logger.getLogger(add_view_subjects.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateSubject() {
        try {
            int offeredSemester = 0;
            if (radioSemster1.isSelected()) {
                offeredSemester = 1;
            }
            if (radioSemster2.isSelected()) {
                offeredSemester = 2;
            }
            Subject subject = new Subject();
            subject.setEvaluationHours(Validations.getIntOrZeroFromString(spinnerEvaluationHours.getValue().toString()));
            subject.setLabHours(Validations.getIntOrZeroFromString(spinnerLabHours.getValue().toString()));
            subject.setTutorialHours(Validations.getIntOrZeroFromString(spinnerTutorialHours.getValue().toString()));
            subject.setLectureHours(Validations.getIntOrZeroFromString(spinnerLectuerHours.getValue().toString()));
            subject.setOfferedSemester(offeredSemester);
            subject.setOfferedYear(Validations.getIntOrZeroFromString(comboOfferedYear.getSelectedItem().toString()));
            subject.setSubjectName(txtSubjectName.getText());
            subject.setSubjectCode(txtSubjectCode.getText());
            new SubjectDaoImpl().updateSubject(subject);
        } catch (SQLException ex) {
            Logger.getLogger(add_view_subjects.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSubjectCode = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubjects = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        txtSubjectName = new javax.swing.JTextField();
        comboOfferedYear = new javax.swing.JComboBox<>();
        radioSemster1 = new javax.swing.JRadioButton();
        radioSemster2 = new javax.swing.JRadioButton();
        spinnerLabHours = new javax.swing.JSpinner();
        spinnerTutorialHours = new javax.swing.JSpinner();
        spinnerEvaluationHours = new javax.swing.JSpinner();
        spinnerLectuerHours = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add/View  Subjects");
        setMaximumSize(new java.awt.Dimension(1368, 718));
        setMinimumSize(new java.awt.Dimension(1368, 718));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Number of Evaluation Hours");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Offerd Year");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Offed Semester");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Subject Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Number of Lab Hours");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Number of Lecture Hours");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Nmber of Tutorial Hours");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Subject Code");

        txtSubjectCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSave.setText("SAVE");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        tblSubjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Subject Name", "Subject Code", "Offerd Year", "Offered Semester", "Lecture Hours", "Tutorial Hours", "Lab Hours", "Evaluation Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubjectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSubjects);
        if (tblSubjects.getColumnModel().getColumnCount() > 0) {
            tblSubjects.getColumnModel().getColumn(0).setMinWidth(0);
            tblSubjects.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblSubjects.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSubjects.getColumnModel().getColumn(1).setResizable(false);
            tblSubjects.getColumnModel().getColumn(2).setResizable(false);
            tblSubjects.getColumnModel().getColumn(3).setResizable(false);
            tblSubjects.getColumnModel().getColumn(4).setResizable(false);
            tblSubjects.getColumnModel().getColumn(5).setResizable(false);
            tblSubjects.getColumnModel().getColumn(6).setResizable(false);
            tblSubjects.getColumnModel().getColumn(7).setResizable(false);
            tblSubjects.getColumnModel().getColumn(8).setResizable(false);
        }

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("UPDATE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btDelete.setText("DELETE");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        txtSubjectName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        comboOfferedYear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboOfferedYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" }));

        buttonGroup1.add(radioSemster1);
        radioSemster1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioSemster1.setSelected(true);
        radioSemster1.setText("1 st Semester");

        buttonGroup1.add(radioSemster2);
        radioSemster2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radioSemster2.setText("2 nd Semester");

        spinnerLabHours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        spinnerTutorialHours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        spinnerEvaluationHours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        spinnerLectuerHours.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioSemster1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioSemster2))
                            .addComponent(comboOfferedYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSubjectName)
                            .addComponent(txtSubjectCode))
                        .addGap(143, 143, 143)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerTutorialHours, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerLabHours, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerEvaluationHours, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerLectuerHours, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboOfferedYear, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerLectuerHours, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioSemster1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioSemster2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerTutorialHours, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerLabHours, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSubjectCode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerEvaluationHours, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

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

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        deleteSubject();
        clearSubjectDetails();
        loadDataToTable();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        updateSubject();
        clearSubjectDetails();
        loadDataToTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        addSubject();
        loadDataToTable();
        clearSubjectDetails();
    }//GEN-LAST:event_btSaveActionPerformed

    private void tblSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubjectsMouseClicked
        int selectedRw = tblSubjects.getSelectedRow();
        if (selectedRw != -1) {
            DefaultTableModel dtm = (DefaultTableModel) tblSubjects.getModel();
            comboOfferedYear.setSelectedItem(dtm.getValueAt(selectedRw, 3).toString());
            txtSubjectCode.setText(dtm.getValueAt(selectedRw, 2).toString());
            txtSubjectName.setText(dtm.getValueAt(selectedRw, 1).toString());
            spinnerLectuerHours.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 5).toString()));
            spinnerTutorialHours.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 6).toString()));
            spinnerLabHours.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 7).toString()));
            spinnerEvaluationHours.setValue(Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 8).toString()));
            radioSemster1.setSelected(true);
            radioSemster2.setSelected(false);
            id = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRw, 0).toString());
        }
    }//GEN-LAST:event_tblSubjectsMouseClicked

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
            java.util.logging.Logger.getLogger(add_view_subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_view_subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_view_subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_view_subjects.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new add_view_subjects().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboOfferedYear;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioSemster1;
    private javax.swing.JRadioButton radioSemster2;
    private javax.swing.JSpinner spinnerEvaluationHours;
    private javax.swing.JSpinner spinnerLabHours;
    private javax.swing.JSpinner spinnerLectuerHours;
    private javax.swing.JSpinner spinnerTutorialHours;
    private javax.swing.JTable tblSubjects;
    private javax.swing.JTextField txtSubjectCode;
    private javax.swing.JTextField txtSubjectName;
    // End of variables declaration//GEN-END:variables
}
