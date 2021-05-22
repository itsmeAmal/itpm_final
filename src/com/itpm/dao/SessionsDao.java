/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.Session;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface SessionsDao {
    
    public boolean addSession(Session session)throws SQLException;
    
    public boolean updateSession(Session session)throws SQLException;
    
    public boolean deleteSession(int sessionId)throws SQLException;
    
    public ResultSet getAllSessions()throws SQLException;
    
    public ResultSet getSessionByOneAttribute(String attribute, String condition, String value) throws SQLException;
}
