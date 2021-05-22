/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.controller;

import com.itpm.core.CommonConstants;
import com.itpm.dao.impl.LectureSessionDaoImpl;
import com.itpm.model.LectureSession;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class LectureSessionController {

    public static boolean addLectureSession(String group,
            String subject, String studentCount, String duration) throws SQLException {
        LectureSession lecSes = new LectureSession();
        lecSes.setDetail(subject);
        lecSes.setGroupName(group);
        lecSes.setDuration(duration);
        lecSes.setNoOfStudents(studentCount);
        return new LectureSessionDaoImpl().addLectureSession(lecSes);
    }

    public static boolean updateLectureSessions(int id, String group,
            String subject, String studentCount, String duration) throws SQLException {
        LectureSession lecSes = new LectureSession();
        lecSes.setDetail(subject);
        lecSes.setGroupName(group);
        lecSes.setDuration(duration);
        lecSes.setNoOfStudents(studentCount);
        lecSes.setId(id);
        return new LectureSessionDaoImpl().updateLectureSession(lecSes);
    }

    public static boolean deleteLectureSession(int id) throws SQLException {
        return new LectureSessionDaoImpl().deleteLectureSession(id);
    }

    public static ResultSet getAllLectureSessions() throws SQLException {
        return new LectureSessionDaoImpl().getAllLectureSessions();
    }

    public static LectureSession getLectureSessionObjectById(int id) throws SQLException {
        ResultSet rset = new LectureSessionDaoImpl().getLectureSessionByOneAttribute("lecture_session_id",
                CommonConstants.sql.EQUAL, Integer.toString(id));
        LectureSession lecSes = null;
        while (rset.next()) {
            lecSes = new LectureSession();
            lecSes.setId(rset.getInt("lecture_session_id"));
            lecSes.setGroupName(rset.getString("lecture_session_group_name"));
            lecSes.setDuration(rset.getString("lecture_session_duration"));
            lecSes.setNoOfStudents(rset.getString("lecture_session_no_of_students"));
            lecSes.setDetail(rset.getString("lecture_session_detail"));
        }
        return lecSes;
    }

}
