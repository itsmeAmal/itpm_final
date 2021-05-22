/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.NotAvailableTimeAllocation;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface NotAvailableTimeAllocationDao {

    public boolean addNotAvailableTimeAllocation(NotAvailableTimeAllocation notAvailableTimeAllocation) throws SQLException;

    public boolean updateNotAvailableTimeAllocation(NotAvailableTimeAllocation notAvailableTimeAllocation) throws SQLException;

    public boolean deleteNotAvailableTimeAllocation(int id) throws SQLException;

    public ResultSet getAllNotAvailableTimeAllocations() throws SQLException;

}
