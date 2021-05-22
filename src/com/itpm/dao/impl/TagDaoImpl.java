/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.model.Tag;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anjula
 */
public class TagDaoImpl {

    private String selectQuery = "select * from tags";

    public boolean addTag(Tag tag) throws SQLException {

        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into tags(tag_code,tag_name,tag_related_name) values (?,?,?)");
        ps.setString(1, tag.getTagCode());
        ps.setString(2, tag.getTagName());
        ps.setString(3, tag.getRelatedTagName());
        ps.executeUpdate();
        ps.close();
        return true;

    }

    public ResultSet getAllTags() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    public boolean updateTag(Tag tag) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update tags set tag_name=?,tag_related_name=?, tag_code=? where tag_id=? ");
        ps.setString(1, tag.getTagName());
        ps.setString(2, tag.getRelatedTagName());
        ps.setString(3, tag.getTagCode());
        ps.setInt(4, tag.getTagId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean deleteTag(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from tags where tag_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;

    }
}
