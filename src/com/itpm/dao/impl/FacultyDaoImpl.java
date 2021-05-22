/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.FacultyDao;
import com.itpm.model.Faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class FacultyDaoImpl implements FacultyDao {

    private String selectQuery = "select * from faculties";
    //faculty_id, faculty_name

    @Override
    public boolean addFaculty(Faculty faculty) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into faculties(faculty_name) values (?)");
        ps.setString(1, faculty.getFacultyName());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateFaculty(Faculty faculty) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update faculties set faculty_name=? where faculty_id=?");
        ps.setString(1, faculty.getFacultyName());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteFaculty(int facultyId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllFaculty() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getFacultyByOneAttribute() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
