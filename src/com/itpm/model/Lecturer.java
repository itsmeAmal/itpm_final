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
public class Lecturer {
//lecturer_id, lecturer_name, lecturer_level, Rank

    private int lecturerId;
    private String lectuerName;
    private String level;
    private String rank;

    /**
     * @return the lecturerId
     */
    public int getLecturerId() {
        return lecturerId;
    }

    /**
     * @param lecturerId the lecturerId to set
     */
    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    /**
     * @return the lectuerName
     */
    public String getLectuerName() {
        return lectuerName;
    }

    /**
     * @param lectuerName the lectuerName to set
     */
    public void setLectuerName(String lectuerName) {
        this.lectuerName = lectuerName;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }
    
    

}
