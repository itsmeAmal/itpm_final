/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.core.CommonConstants;
import com.itpm.dao.impl.NotAvailableTimeAllocationDaoImpl;
import com.itpm.model.NotAvailableTimeAllocation;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class NotAvailableTimeAllocationController {

    public static boolean addNotAvailableTimeAllocation(String lecturer, String group,
            String subGroup, String sessionId, String time) throws SQLException {
        NotAvailableTimeAllocation notAvailableTimeAllocation = new NotAvailableTimeAllocation();
        notAvailableTimeAllocation.setLectureName(lecturer);
        notAvailableTimeAllocation.setGroupName(group);
        notAvailableTimeAllocation.setSubGroupName(subGroup);
        notAvailableTimeAllocation.setSessionIdString(sessionId);
        notAvailableTimeAllocation.setDetail(time);
        return new NotAvailableTimeAllocationDaoImpl().addNotAvailableTimeAllocation(notAvailableTimeAllocation);
    }

    public static boolean updateNotAvailableTimeAllocation(int id, String lecturer, String group,
            String subGroup, String sessionId, String time) throws SQLException {
        NotAvailableTimeAllocation notAvailableTimeAllocation = new NotAvailableTimeAllocation();
        notAvailableTimeAllocation.setLectureName(lecturer);
        notAvailableTimeAllocation.setGroupName(group);
        notAvailableTimeAllocation.setSubGroupName(subGroup);
        notAvailableTimeAllocation.setSessionIdString(sessionId);
        notAvailableTimeAllocation.setDetail(time);
        notAvailableTimeAllocation.setId(id);
        return new NotAvailableTimeAllocationDaoImpl().updateNotAvailableTimeAllocation(notAvailableTimeAllocation);
    }

    public static ResultSet getAllNotAvailableTimeAllocations() throws SQLException {
        return new NotAvailableTimeAllocationDaoImpl().getAllNotAvailableTimeAllocations();
    }

    public static NotAvailableTimeAllocation getObjectById(int id) throws SQLException {
        ResultSet rset = new NotAvailableTimeAllocationDaoImpl().getResultSetByOneAttribute("id",
                CommonConstants.sql.EQUAL, Integer.toString(id));
        NotAvailableTimeAllocation notAvailableTimeAllocation = null;
        while (rset.next()) {
            notAvailableTimeAllocation = new NotAvailableTimeAllocation();
            notAvailableTimeAllocation.setId(rset.getInt("id"));
            notAvailableTimeAllocation.setLectureName(rset.getString("lecturer_name"));
            notAvailableTimeAllocation.setDetail(rset.getString("detail"));
            notAvailableTimeAllocation.setGroupName(rset.getString("group_name"));
            notAvailableTimeAllocation.setSessionIdString(rset.getString("session_id_string"));
            notAvailableTimeAllocation.setSubGroupName(rset.getString("sub_group_name"));
        }
        return notAvailableTimeAllocation;
    }
}
