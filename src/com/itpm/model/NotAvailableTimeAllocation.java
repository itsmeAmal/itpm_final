/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.model;

/**
 *
 * @author root_user
 */
public class NotAvailableTimeAllocation {

    ///id, lecturer_name, group_name, sub_group_name, session_id_string, detail
    private int id;
    private String lectureName;
    private String groupName;
    private String subGroupName;
    private String sessionIdString;
    private String detail;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the lectureName
     */
    public String getLectureName() {
        return lectureName;
    }

    /**
     * @param lectureName the lectureName to set
     */
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the subGroupName
     */
    public String getSubGroupName() {
        return subGroupName;
    }

    /**
     * @param subGroupName the subGroupName to set
     */
    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    /**
     * @return the sessionIdString
     */
    public String getSessionIdString() {
        return sessionIdString;
    }

    /**
     * @param sessionIdString the sessionIdString to set
     */
    public void setSessionIdString(String sessionIdString) {
        this.sessionIdString = sessionIdString;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

}
