/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.core.CommonConstants;
import com.itpm.dao.impl.SessionsDaoImpl;
import com.itpm.model.Session;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class SessionManagementController {

    public static boolean addSession(String sessionId, String tag, String dayName, String startTimeHour, String startTimeMinutes, String startTimeAmPm,
            String endTimeHour, String enndTimeMinues, String endTimeAmPm, String type, String category, String module) throws SQLException {
        Session session = new Session();
        session.setSessionIdString(sessionId);
        session.setTagName(tag);
        session.setDay(dayName);
        session.setStartTimeHour(startTimeHour);
        session.setStartTimeMinutes(startTimeMinutes);
        session.setStartTimeAmPm(startTimeAmPm);
        session.setEndTimeHour(endTimeHour);
        session.setEndTimeMinutes(enndTimeMinues);
        session.setEndTimeAmPm(endTimeAmPm);
        session.setSessionType(type);
        session.setCategory(category);
        session.setModule(module);
        return new SessionsDaoImpl().addSession(session);
    }

    public static boolean updateSession(int Id, String sessionId, String tag, String dayName, String startTimeHour, String startTimeMinutes,
            String startTimeAmPm, String endTimeHour, String enndTimeMinues, String endTimeAmPm, String type, String category,
            String module) throws SQLException {
        Session session = new Session();
        session.setSessionIdString(sessionId);
        session.setTagName(tag);
        session.setDay(dayName);
        session.setStartTimeHour(startTimeHour);
        session.setStartTimeMinutes(startTimeMinutes);
        session.setStartTimeAmPm(startTimeAmPm);
        session.setEndTimeHour(endTimeHour);
        session.setEndTimeMinutes(enndTimeMinues);
        session.setEndTimeAmPm(endTimeAmPm);
        session.setSessionType(type);
        session.setCategory(category);
        session.setModule(module);
        session.setId(Id);
        return new SessionsDaoImpl().updateSession(session);
    }

    public static boolean deleteSession(int id) throws SQLException {
        return new SessionsDaoImpl().deleteSession(id);
    }

    public static ResultSet getAllSessions() throws SQLException {
        return new SessionsDaoImpl().getAllSessions();
    }

    public static Session getSessionBySessionId(int sessionId) throws SQLException {
        ResultSet rset = new SessionsDaoImpl().getSessionByOneAttribute("consecutive_sessions_id", CommonConstants.sql.EQUAL, Integer.toString(sessionId));
        Session ses = null;
        while (rset.next()) {
            ses = new Session();
            ses.setId(rset.getInt("consecutive_sessions_id"));
            ses.setTagId(rset.getInt("consecutive_sessions_tag_id"));
            ses.setTagName(rset.getString("consecutive_sessions_tag_name"));
            ses.setDay(rset.getString("consecutive_sessions_day"));
            ses.setStartTimeHour(rset.getString("consecutive_sessions_start_time_hour"));
            ses.setStartTimeMinutes(rset.getString("consecutive_sessions_start_time_minutes"));
            ses.setStartTimeAmPm(rset.getString("consecutive_sessions_start_time_am_pm"));
            ses.setEndTimeHour(rset.getString("consecutive_sessions_end_time_hour"));
            ses.setEndTimeMinutes(rset.getString("consecutive_sessions_end_time_minutes"));
            ses.setEndTimeAmPm(rset.getString("consecutive_sessions_end_time_am_pm"));
            ses.setStatus(rset.getString("consecutive_sessions_status"));
            ses.setDetail(rset.getString("consecutive_sessions_detail"));
            ses.setSessionType(rset.getString("consecutive_sessions_session_type"));
            ses.setSessionId(rset.getInt("consecutive_sessions_session_id"));
            ses.setSessionIdString(rset.getString("consecutive_sessions_session_id_string"));
            ses.setCategory(rset.getString("consecutive_sessions_category"));
            ses.setModule(rset.getString("consecutive_sessions_module"));
        }
        return ses;
    }
}
