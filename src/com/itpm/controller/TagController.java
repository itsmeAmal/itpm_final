/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.dao.impl.TagDaoImpl;
import com.itpm.model.Tag;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anjula
 */
public class TagController {

    public static boolean addTag(String code, String tagName, String relatedTag) throws SQLException {
        Tag tag = new Tag();
        tag.setTagCode(code);
        tag.setTagName(tagName);
        tag.setRelatedTagName(relatedTag);
        return new TagDaoImpl().addTag(tag);
    }

    public static ResultSet getAllTags() throws SQLException {
        return new TagDaoImpl().getAllTags();
    }

    public static boolean updateTag(String code, String tagName, String relatedTag, int tagId) throws SQLException {
        Tag tag = new Tag();
        tag.setTagCode(code);
        tag.setTagName(tagName);
        tag.setRelatedTagName(relatedTag);
        tag.setTagId(tagId);
        return new TagDaoImpl().updateTag(tag);
    }

    public static boolean deleteTag(int code) throws SQLException {
        return new TagDaoImpl().deleteTag(code);
    }

    public static Tag getTagObjectByTagId(int id, String attribute, String condition) throws SQLException {
//       ResultSet rs= new TagDaoImpl().getTagObjectByTagId(id,attribute,condition);
        Tag tag = new Tag();
//       while(rs.next()){
//       tag.setTagCode(rs.getInt("tag_code"));
//       tag.setTagName(rs.getString("tag_name"));
//       tag.setRelatedTagName(rs.getString("tag_related_name"));
//       }
        return tag;
    }
}
