/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.Tag;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface TagDao {
    
    public  boolean addTag(Tag tag) throws SQLException;
    
    
    
}
