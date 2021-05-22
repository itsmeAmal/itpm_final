/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.model.Lecturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class LecturerDaoImpl {

    private String selectQuery = "select *  from lecturers";

    //lecturer_id, lecturer_name, lecturer_level, Rank
    public boolean addLecturer(Lecturer lecturer) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into lecturers (lecturer_name, lecturer_level, Rank) values (?,?,?)");
        ps.setString(1, lecturer.getLectuerName());
        ps.setString(2, lecturer.getLevel());
        ps.setString(3, lecturer.getRank());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean updateLecturer(Lecturer lecturer) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update lecturers set lecturer_name=?, lecturer_level=?, Rank=? where lecturer_id=?");
        ps.setString(1, lecturer.getLectuerName());
        ps.setString(2, lecturer.getLevel());
        ps.setString(3, lecturer.getRank());
        ps.setInt(4, lecturer.getLecturerId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean deleteLecturer(int lecId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from lecturers where lecturer_id=?");
        ps.setInt(1, lecId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public int getAllCount() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(lecturer_id) as lec_count from lecturers");
        ResultSet rset = ps.executeQuery();
        int count = 0;
        while (rset.next()) {
            count = rset.getInt("lec_count");
        }
        return count;
    }

    public ResultSet getAllLecturers() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

}
