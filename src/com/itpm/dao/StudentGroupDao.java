/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.StudentGroup;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface StudentGroupDao {

    public boolean addStudentGroup(StudentGroup studentGroup) throws SQLException;

    public boolean updateStudentGroup(StudentGroup studentGroup) throws SQLException;

    public boolean deleteStudentGroup(int id) throws SQLException;

    public ResultSet getAllStudentGroups() throws SQLException;

    public ResultSet getStrudentGroupByOneAttribute(String attribute, String condition, String value) throws SQLException;

}
