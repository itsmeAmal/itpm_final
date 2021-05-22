/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.model;

import java.sql.Date;

/**
 *
 * @author root_user
 */
public class Session {

    private int id;
    private int tagId;
    private String tagName;
    private String day;
    private String startTimeHour;
    private String startTimeMinutes;
    private String startTimeAmPm;
    private String endTimeHour;
    private String endTimeMinutes;
    private String endTimeAmPm;
    private String status;
    private String detail;
    private String sessionType;
    private int sessionId;
    private String sessionIdString;
    private String category;
    private String module;

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
     * @return the tagId
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * @param tagId the tagId to set
     */
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /**
     * @return the tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName the tagName to set
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the startTimeHour
     */
    public String getStartTimeHour() {
        return startTimeHour;
    }

    /**
     * @param startTimeHour the startTimeHour to set
     */
    public void setStartTimeHour(String startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    /**
     * @return the startTimeMinutes
     */
    public String getStartTimeMinutes() {
        return startTimeMinutes;
    }

    /**
     * @param startTimeMinutes the startTimeMinutes to set
     */
    public void setStartTimeMinutes(String startTimeMinutes) {
        this.startTimeMinutes = startTimeMinutes;
    }

    /**
     * @return the startTimeAmPm
     */
    public String getStartTimeAmPm() {
        return startTimeAmPm;
    }

    /**
     * @param startTimeAmPm the startTimeAmPm to set
     */
    public void setStartTimeAmPm(String startTimeAmPm) {
        this.startTimeAmPm = startTimeAmPm;
    }

    /**
     * @return the endTimeHour
     */
    public String getEndTimeHour() {
        return endTimeHour;
    }

    /**
     * @param endTimeHour the endTimeHour to set
     */
    public void setEndTimeHour(String endTimeHour) {
        this.endTimeHour = endTimeHour;
    }

    /**
     * @return the endTimeMinutes
     */
    public String getEndTimeMinutes() {
        return endTimeMinutes;
    }

    /**
     * @param endTimeMinutes the endTimeMinutes to set
     */
    public void setEndTimeMinutes(String endTimeMinutes) {
        this.endTimeMinutes = endTimeMinutes;
    }

    /**
     * @return the endTimeAmPm
     */
    public String getEndTimeAmPm() {
        return endTimeAmPm;
    }

    /**
     * @param endTimeAmPm the endTimeAmPm to set
     */
    public void setEndTimeAmPm(String endTimeAmPm) {
        this.endTimeAmPm = endTimeAmPm;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * @return the sessionType
     */
    public String getSessionType() {
        return sessionType;
    }

    /**
     * @param sessionType the sessionType to set
     */
    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * @return the sessionId
     */
    public int getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
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
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /**
     * @param module the module to set
     */
    public void setModule(String module) {
        this.module = module;
    }

}
