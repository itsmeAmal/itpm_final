/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao;

import com.itpm.model.LectureSession;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface LectureSessionDao {
    
    public boolean addLectureSession(LectureSession lectureSession)throws SQLException;
    
    public boolean updateLectureSession(LectureSession lectureSession)throws SQLException;
    
    public boolean deleteLectureSession(int lectureSessionId)throws SQLException;
    
    public ResultSet getAllLectureSessions()throws SQLException;
    
}
