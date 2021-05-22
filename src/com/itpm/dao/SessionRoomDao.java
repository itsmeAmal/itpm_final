/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.SessionRoom;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface SessionRoomDao {

    public boolean addSessionRoom(SessionRoom sessionRoom) throws SQLException;

    public boolean updateSessionRoom(SessionRoom sessionRoom) throws SQLException;

    public boolean deleteSessionRoom(int id) throws SQLException;

    public ResultSet getAllSessionRooms() throws SQLException;
}
