/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface CommonDao {

    public ResultSet getAllRecords(String selectQuery) throws SQLException;

    public ResultSet getResultByAttribute(String selectQuery, String attribute, String condition, String value) throws SQLException;

}
