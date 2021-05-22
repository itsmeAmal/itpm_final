/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.dao.impl.LecturerDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author root_user
 */
public class LecturerController {

    //lecturer_id, lecturer_name, lecturer_level, Rank
    public static ResultSet getAllData() throws SQLException {
        return new LecturerDaoImpl().getAllLecturers();
    }

    public static void loadLecNamesToCombo(JComboBox combo) throws SQLException {
        ResultSet rset = new LecturerDaoImpl().getAllLecturers();
        CommonController.loadDataToComboBox(combo, rset, "lecturer_name");
    }

    public static int getAllCount() throws SQLException {
        return new LecturerDaoImpl().getAllCount();
    }

}
