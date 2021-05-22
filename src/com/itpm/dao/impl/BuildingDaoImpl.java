/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.BuildingDao;
import com.itpm.dao.CommonDao;
import com.itpm.model.Building;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class BuildingDaoImpl implements BuildingDao {

    private CommonDao commonDao;

    private String selectQuery = "select * from buildings";
    //buliding_id, building_name

    @Override
    public boolean addBuilding(Building building) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into buildings(building_name) values(?)");
        ps.setString(1, building.getBuildingName());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean updateBuilding(Building building) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update buildings set building_name=? where buliding_id=?");
        ps.setString(1, building.getBuildingName());
        ps.executeUpdate();
        return true;
    }

    @Override
    public boolean deleteBuilding(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from buildings where buliding_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        return true;
    }

    @Override
    public ResultSet getAllBuildings() throws SQLException {
        return commonDao.getAllRecords(selectQuery);
    }

    @Override

    public ResultSet getBuildingByOneAttribute(String attribute, String cindition, String value) throws SQLException {
        return commonDao.getResultByAttribute(selectQuery, attribute, cindition, value);
    }

}
