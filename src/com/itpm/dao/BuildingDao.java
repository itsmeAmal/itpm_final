/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.Building;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Amal
 */
public interface BuildingDao {

    public boolean addBuilding(Building building) throws SQLException;

    public boolean updateBuilding(Building building) throws SQLException;

    public boolean deleteBuilding(int id) throws SQLException;

    public ResultSet getAllBuildings() throws SQLException;

    public ResultSet getBuildingByOneAttribute(String attribute, String cindition, String value) throws SQLException;
}
