/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.dao.impl.StudentGroupDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author root_user
 */
public class StudentGroupController {

    public static ResultSet getAllData() throws SQLException {
        return new StudentGroupDaoImpl().getAllStudentGroups();
    }

    public static void loadGroupNoToCombo(JComboBox combo) throws SQLException {
        ResultSet rset = getAllData();
        CommonController.loadDataToComboBox(combo, rset, "student_group_no");
    }

    public static void loadSubGroupNoToCombo(JComboBox combo) throws SQLException {
        ResultSet rset = getAllData();
        CommonController.loadDataToComboBox(combo, rset, "student_sub_group_no");
    }

    public static int getDataCount() throws SQLException {
        return new StudentGroupDaoImpl().getAllCount();
    }

}
