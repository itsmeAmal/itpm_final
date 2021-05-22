/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.Faculty;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface FacultyDao {

    public boolean addFaculty(Faculty faculty) throws SQLException;

    public boolean updateFaculty(Faculty faculty) throws SQLException;

    public boolean deleteFaculty(int facultyId) throws SQLException;
    
    public ResultSet getAllFaculty()throws SQLException;
    
    public ResultSet getFacultyByOneAttribute()throws SQLException;

}
