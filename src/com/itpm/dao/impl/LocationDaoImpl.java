/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.LocationDao;
import com.itpm.model.Location;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anjula
 */
public class LocationDaoImpl implements LocationDao {

    private String selectQuery = "select * from rooms";
    //room_id, room_type, room_capacity, room_related_building_name, room_name

    @Override
    public boolean addLocation(Location location) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into rooms(room_type,room_capacity,room_related_building_name, room_name) values(?,?,?,?)");
        ps.setString(1, location.getRoomType());
        ps.setInt(2, location.getRoomCapacity());
        ps.setString(3, location.getBuildingName());
        ps.setString(4, location.getRoomName());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean updateLocation(Location location) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update rooms set room_type=?, room_capacity=?, "
                + "room_related_building_name=?, room_name=? where room_id=?");
        ps.setString(1, location.getRoomType());
        ps.setInt(2, location.getRoomCapacity());
        ps.setString(3, location.getBuildingName());
        ps.setString(4, location.getRoomName());
        ps.setInt(5, location.getRoomId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean deleteLocation(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from rooms where room_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public ResultSet getAllLocations() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }
}
