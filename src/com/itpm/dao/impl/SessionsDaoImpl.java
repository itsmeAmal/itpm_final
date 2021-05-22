/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.SessionsDao;
import com.itpm.model.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class SessionsDaoImpl implements SessionsDao {

    private String selectQuery = "select * from sessions";

    @Override
    public boolean addSession(Session session) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into sessions (consecutive_sessions_tag_id, "
                + "consecutive_sessions_tag_name, consecutive_sessions_day, consecutive_sessions_start_time_hour, "
                + "consecutive_sessions_start_time_minutes, consecutive_sessions_start_time_am_pm, "
                + "consecutive_sessions_end_time_hour, consecutive_sessions_end_time_minutes, "
                + "consecutive_sessions_end_time_am_pm, consecutive_sessions_status, consecutive_sessions_detail, "
                + "consecutive_sessions_session_type, consecutive_sessions_session_id, "
                + "consecutive_sessions_session_id_string, consecutive_sessions_category, "
                + "consecutive_sessions_module) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, session.getTagId());
        ps.setString(2, session.getTagName());
        ps.setString(3, session.getDay());
        ps.setString(4, session.getStartTimeHour());
        ps.setString(5, session.getStartTimeMinutes());
        ps.setString(6, session.getStartTimeAmPm());
        ps.setString(7, session.getEndTimeHour());
        ps.setString(8, session.getEndTimeMinutes());
        ps.setString(9, session.getEndTimeAmPm());
        ps.setString(10, session.getStatus());
        ps.setString(11, session.getDetail());
        ps.setString(12, session.getSessionType());
        ps.setInt(13, session.getSessionId());
        ps.setString(14, session.getSessionIdString());
        ps.setString(15, session.getCategory());
        ps.setString(16, session.getModule());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateSession(Session session) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update sessions set consecutive_sessions_tag_id=?, "
                + "consecutive_sessions_tag_name=?, consecutive_sessions_day=?, consecutive_sessions_start_time_hour=?, "
                + "consecutive_sessions_start_time_minutes=?, consecutive_sessions_start_time_am_pm=?,"
                + " consecutive_sessions_end_time_hour=?, consecutive_sessions_end_time_minutes=?, "
                + "consecutive_sessions_end_time_am_pm=?, consecutive_sessions_status=?, "
                + "consecutive_sessions_detail=?, consecutive_sessions_session_type=?, consecutive_sessions_session_id=?,"
                + " consecutive_sessions_session_id_string=?, consecutive_sessions_category=?, "
                + "consecutive_sessions_module=? where consecutive_sessions_id=?");
        ps.setInt(1, session.getTagId());
        ps.setString(2, session.getTagName());
        ps.setString(3, session.getDay());
        ps.setString(4, session.getStartTimeHour());
        ps.setString(5, session.getStartTimeMinutes());
        ps.setString(6, session.getStartTimeAmPm());
        ps.setString(7, session.getEndTimeHour());
        ps.setString(8, session.getEndTimeMinutes());
        ps.setString(9, session.getEndTimeAmPm());
        ps.setString(10, session.getStatus());
        ps.setString(11, session.getDetail());
        ps.setString(12, session.getSessionType());
        ps.setInt(13, session.getSessionId());
        ps.setString(14, session.getSessionIdString());
        ps.setString(15, session.getCategory());
        ps.setString(16, session.getModule());
        ps.setInt(17, session.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteSession(int sessionId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from sessions where consecutive_sessions_id=?");
        ps.setInt(1, sessionId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllSessions() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getSessionByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
