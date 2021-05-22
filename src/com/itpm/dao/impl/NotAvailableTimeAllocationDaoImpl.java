/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.NotAvailableTimeAllocationDao;
import com.itpm.model.NotAvailableTimeAllocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class NotAvailableTimeAllocationDaoImpl implements NotAvailableTimeAllocationDao {

    ///id, lecturer_name, group_name, sub_group_name, session_id_string, detail
    private String selectQuery = "select id, lecturer_name, group_name, sub_group_name, session_id_string, detail from not_available_time_allocations";

    @Override
    public boolean addNotAvailableTimeAllocation(NotAvailableTimeAllocation notAvailableTimeAllocation) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into not_available_time_allocations(lecturer_name, group_name, sub_group_name,"
                + " session_id_string, detail) values (?,?,?,?,?)");
        ps.setString(1, notAvailableTimeAllocation.getLectureName());
        ps.setString(2, notAvailableTimeAllocation.getGroupName());
        ps.setString(3, notAvailableTimeAllocation.getSubGroupName());
        ps.setString(4, notAvailableTimeAllocation.getSessionIdString());
        ps.setString(5, notAvailableTimeAllocation.getDetail());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateNotAvailableTimeAllocation(NotAvailableTimeAllocation notAvailableTimeAllocation) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update not_available_time_allocations set"
                + " lecturer_name=?, group_name=?, sub_group_name=?, session_id_string=?, detail=? where id=?");
        ps.setString(1, notAvailableTimeAllocation.getLectureName());
        ps.setString(2, notAvailableTimeAllocation.getGroupName());
        ps.setString(3, notAvailableTimeAllocation.getSubGroupName());
        ps.setString(4, notAvailableTimeAllocation.getSessionIdString());
        ps.setString(5, notAvailableTimeAllocation.getDetail());
        ps.setInt(6, notAvailableTimeAllocation.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteNotAvailableTimeAllocation(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from not_available_time_allocations set where id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllNotAvailableTimeAllocations() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    public ResultSet getResultSetByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
