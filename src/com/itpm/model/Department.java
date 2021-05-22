/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.model;

/**
 *
 * @author Amal
 */
public class Department {

    private int departmentId;
    private String departmentName;
    private int departmentRelatedFacultyId;

    /**
     * @return the departmentId
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the departmentRelatedFacultyId
     */
    public int getDepartmentRelatedFacultyId() {
        return departmentRelatedFacultyId;
    }

    /**
     * @param departmentRelatedFacultyId the departmentRelatedFacultyId to set
     */
    public void setDepartmentRelatedFacultyId(int departmentRelatedFacultyId) {
        this.departmentRelatedFacultyId = departmentRelatedFacultyId;
    }

}
