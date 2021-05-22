/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.dao.LectureSessionDao;
import com.itpm.model.LectureSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class LectureSessionDaoImpl implements LectureSessionDao {

    private String selectQuery = "select lecture_session_id, lecture_session_group_id, "
            + " lecture_session_group_name, lecture_session_no_of_students, lecture_session_duration, lecture_session_detail from lecture_sessions";

    @Override
    public boolean addLectureSession(LectureSession lectureSession) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into lecture_sessions(lecture_session_group_id,"
                + " lecture_session_group_name, lecture_session_no_of_students, lecture_session_duration,"
                + " lecture_session_detail) values (?,?,?,?,?)");
        ps.setInt(1, lectureSession.getGroupId());
        ps.setString(2, lectureSession.getGroupName());
        ps.setString(3, lectureSession.getNoOfStudents());
        ps.setString(4, lectureSession.getDuration());
        ps.setString(5, lectureSession.getDetail());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updateLectureSession(LectureSession lectureSession) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update lecture_sessions set lecture_session_group_id=?, "
                + " lecture_session_group_name=?, lecture_session_no_of_students=?, lecture_session_duration=?,"
                + " lecture_session_detail=? where lecture_session_id=?");
        ps.setInt(1, lectureSession.getGroupId());
        ps.setString(2, lectureSession.getGroupName());
        ps.setString(3, lectureSession.getNoOfStudents());
        ps.setString(4, lectureSession.getDuration());
        ps.setString(5, lectureSession.getDetail());
        ps.setInt(6, lectureSession.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deleteLectureSession(int lectureSessionId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from lecture_sessions where lecture_session_id=?");
        ps.setInt(1, lectureSessionId);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAllLectureSessions() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    public ResultSet getLectureSessionByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
