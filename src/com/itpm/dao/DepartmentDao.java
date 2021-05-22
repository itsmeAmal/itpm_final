/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.Department;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface DepartmentDao {

    public boolean addDepartment(Department department) throws SQLException;

    public boolean updateDepartment(Department department) throws SQLException;

    public boolean deleteDepartment(int id) throws SQLException;

    public ResultSet getAllDepartments() throws SQLException;

    public ResultSet getDepartmentByOneAttribute(String attribute, String condition, String value) throws SQLException;

}
