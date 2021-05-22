/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.SessionRoomDao;
import com.itpm.model.SessionRoom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class SessionRoomDaoImpl implements SessionRoomDao {

    private String selectQuery = "select id, session_id, room_name, detail from session_rooms";

    @Override
    public boolean addSessionRoom(SessionRoom sessionRoom) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into session_rooms (session_id, room_name, detail) values (?,?,?)");
        ps.setString(1, sessionRoom.getSessionid());
        ps.setString(3, sessionRoom.getRoomName());
        ps.setString(3, sessionRoom.getDetail());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateSessionRoom(SessionRoom sessionRoom) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update session_rooms set session_id=?, room_name=?, detail=? where id=?");
        ps.setString(1, sessionRoom.getSessionid());
        ps.setString(3, sessionRoom.getRoomName());
        ps.setString(3, sessionRoom.getDetail());
        ps.setInt(4, sessionRoom.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteSessionRoom(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from session_rooms where id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllSessionRooms() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

}
