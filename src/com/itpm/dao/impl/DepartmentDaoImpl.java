/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.CommonDao;
import com.itpm.dao.DepartmentDao;
import com.itpm.model.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class DepartmentDaoImpl implements DepartmentDao {

    private String selectQuery = "select * from department";
    //department_id, department_name, department_related_faculty_id

    private CommonDao commonDao;

    @Override
    public boolean addDepartment(Department department) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into department"
                + "(department_name, department_related_faculty_id) values (?,?)");
        ps.setString(1, department.getDepartmentName());
        ps.setInt(2, department.getDepartmentRelatedFacultyId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateDepartment(Department department) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update department set department_name=?, "
                + " department_related_faculty_id=? where department_id=?");
        ps.setString(1, department.getDepartmentName());
        ps.setInt(2, department.getDepartmentRelatedFacultyId());
        ps.setInt(3, department.getDepartmentId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteDepartment(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from department where department_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllDepartments() throws SQLException {
        return commonDao.getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getDepartmentByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return commonDao.getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
