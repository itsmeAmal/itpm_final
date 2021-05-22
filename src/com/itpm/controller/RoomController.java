/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.dao.impl.RoomDaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class RoomController {

    public static ResultSet getAllData() throws SQLException {
        return new RoomDaoImpl().getAlldata();
    }

    public static int getDataCount() throws SQLException {
        return new RoomDaoImpl().getDataCount();
    }

}
