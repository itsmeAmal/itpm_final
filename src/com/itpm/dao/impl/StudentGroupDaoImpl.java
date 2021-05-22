/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.CommonDao;
import com.itpm.dao.StudentGroupDao;
import com.itpm.model.StudentGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class StudentGroupDaoImpl implements StudentGroupDao {

    private CommonDao commonDao;

    private String selectQuery = "select * from student_groups";
    //student_id, student_group_no, student_sub_group_no, student_group_id, 
    //student_sub_group_id, student_academic_year_and_sem, student_programme, detail

    @Override
    public boolean addStudentGroup(StudentGroup studentGroup) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into student_groups (student_group_no, student_sub_group_no,"
                + " student_group_id, student_sub_group_id, student_academic_year_and_sem, student_programme) values (?,?,?,?,?,?)");
        ps.setString(1, studentGroup.getGroupNoString());
        ps.setString(2, studentGroup.getSubGroupNoString());
        ps.setString(3, studentGroup.getGroupIdString());
        ps.setString(4, studentGroup.getSubGroupIdString());
        ps.setString(5, studentGroup.getAcademiYearSemester());
        ps.setString(6, studentGroup.getProgram());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateStudentGroup(StudentGroup studentGroup) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update student_groups set student_group_no=?, "
                + "student_sub_group_no=?, student_academic_year_and_sem=?, student_programme=?,"
                + "  student_group_id=?, student_sub_group_id=? where student_id=?");
        ps.setString(1, studentGroup.getGroupNoString());
        ps.setString(2, studentGroup.getSubGroupNoString());
        ps.setString(3, studentGroup.getGroupIdString());
        ps.setString(4, studentGroup.getSubGroupIdString());
        ps.setString(5, studentGroup.getAcademiYearSemester());
        ps.setString(6, studentGroup.getProgram());
        ps.setInt(7, studentGroup.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteStudentGroup(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from student_groups where student_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public int getAllCount() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(student_id) as stu_g_count from student_groups");
        ResultSet rset = ps.executeQuery();
        int count = 0;
        while (rset.next()) {
            count = rset.getInt("stu_g_count");
        }
        return count;
    }

    @Override
    public ResultSet getAllStudentGroups() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getStrudentGroupByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return commonDao.getResultByAttribute(selectQuery, attribute, condition, value);
    }
}
