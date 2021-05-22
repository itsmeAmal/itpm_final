/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class RoomDaoImpl {

    private String selectQuery = "select * from rooms";

    public ResultSet getAlldata() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    public ResultSet getDataByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

    public int getDataCount() throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("select count(room_id) as room_count from rooms");
        ResultSet rset = ps.executeQuery();
        int count = 0;
        while (rset.next()) {
            count = rset.getInt("room_count");
        }
        return count;
    }

}
