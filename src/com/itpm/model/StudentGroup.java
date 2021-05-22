package com.itpm.model;

public class StudentGroup {

    private int id;
    private String academiYearSemester;
    private String program;
    private String groupNoString;
    private String subGroupNoString;
    private String groupIdString;
    private String subGroupIdString;
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
     * @return the academiYearSemester
     */
    public String getAcademiYearSemester() {
        return academiYearSemester;
    }

    /**
     * @param academiYearSemester the academiYearSemester to set
     */
    public void setAcademiYearSemester(String academiYearSemester) {
        this.academiYearSemester = academiYearSemester;
    }

    /**
     * @return the program
     */
    public String getProgram() {
        return program;
    }

    /**
     * @param program the program to set
     */
    public void setProgram(String program) {
        this.program = program;
    }

    /**
     * @return the groupNoString
     */
    public String getGroupNoString() {
        return groupNoString;
    }

    /**
     * @param groupNoString the groupNoString to set
     */
    public void setGroupNoString(String groupNoString) {
        this.groupNoString = groupNoString;
    }

    /**
     * @return the subGroupNoString
     */
    public String getSubGroupNoString() {
        return subGroupNoString;
    }

    /**
     * @param subGroupNoString the subGroupNoString to set
     */
    public void setSubGroupNoString(String subGroupNoString) {
        this.subGroupNoString = subGroupNoString;
    }

    /**
     * @return the groupIdString
     */
    public String getGroupIdString() {
        return groupIdString;
    }

    /**
     * @param groupIdString the groupIdString to set
     */
    public void setGroupIdString(String groupIdString) {
        this.groupIdString = groupIdString;
    }

    /**
     * @return the subGroupIdString
     */
    public String getSubGroupIdString() {
        return subGroupIdString;
    }

    /**
     * @param subGroupIdString the subGroupIdString to set
     */
    public void setSubGroupIdString(String subGroupIdString) {
        this.subGroupIdString = subGroupIdString;
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
