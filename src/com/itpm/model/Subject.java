/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.model;

/**
 *
 * @author Anjula
 */
public class Subject {

    private String subjectCode;
    private String subjectName;
    private int offeredYear;
    private int offeredSemester;
    private int LectureHours;
    private int tutorialHours;
    private int labHours;
    private int evaluationHours;
    private int subjectId;

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getOfferedYear() {
        return offeredYear;
    }

    public void setOfferedYear(int offeredYear) {
        this.offeredYear = offeredYear;
    }

    public int getOfferedSemester() {
        return offeredSemester;
    }

    public void setOfferedSemester(int offeredSemester) {
        this.offeredSemester = offeredSemester;
    }

    public int getLectureHours() {
        return LectureHours;
    }

    public void setLectureHours(int LectureHours) {
        this.LectureHours = LectureHours;
    }

    public int getTutorialHours() {
        return tutorialHours;
    }

    public void setTutorialHours(int tutorialHours) {
        this.tutorialHours = tutorialHours;
    }

    public int getLabHours() {
        return labHours;
    }

    public void setLabHours(int labHours) {
        this.labHours = labHours;
    }

    public int getEvaluationHours() {
        return evaluationHours;
    }

    public void setEvaluationHours(int evaluationHours) {
        this.evaluationHours = evaluationHours;
    }

    /**
     * @return the subjectId
     */
    public int getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

}
