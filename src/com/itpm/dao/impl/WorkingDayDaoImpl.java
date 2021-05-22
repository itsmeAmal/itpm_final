/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itpm.dao.impl;

import com.itpm.connection.DatabaseConnection;
import com.itpm.core.CommonConstants;
import com.itpm.model.WorkingDay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class WorkingDayDaoImpl {

    private String selectQuery = "select * from working_days";

    public boolean updateWorkingHoursAnddays(WorkingDay workingDay) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update working_days set working_day_no_work_days=?, "
                + "working_day_hours=?, working_day_minutes=?, working_day_amount=?, working_day_monday=?, "
                + "working_day_tuesday=?, working_day_wednesday=?, working_day_thursday=?, working_day_friday=?, "
                + "working_day_saturday=?, working_day_sunday=? where working_day_id=?");
        System.out.println(workingDay);
        ps.setInt(1, workingDay.getNoOfWorkingDays());
        ps.setInt(2, workingDay.getHours());
        ps.setInt(3, workingDay.getMinutes());
        ps.setBigDecimal(4, workingDay.getDayAmount());
        ps.setBoolean(5, workingDay.isMonday());
        ps.setBoolean(6, workingDay.isTuesday());
        ps.setBoolean(7, workingDay.isWednesday());
        ps.setBoolean(8, workingDay.isThursday());
        ps.setBoolean(9, workingDay.isFriday());
        ps.setBoolean(10, workingDay.isSaturday());
        ps.setBoolean(11, workingDay.isSunday());
        ps.setInt(12, workingDay.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean addWorkingHoursAnddays(WorkingDay workingDay) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into working_days(working_day_no_work_days, "
                + "working_day_hours, working_day_minutes, working_day_amount, working_day_monday, working_day_tuesday, "
                + "working_day_wednesday, working_day_thursday, working_day_friday, working_day_saturday, "
                + "working_day_sunday) values (?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, workingDay.getNoOfWorkingDays());
        ps.setInt(2, workingDay.getHours());
        ps.setInt(3, workingDay.getMinutes());
        ps.setBigDecimal(4, workingDay.getDayAmount());
        ps.setBoolean(5, workingDay.isMonday());
        ps.setBoolean(6, workingDay.isTuesday());
        ps.setBoolean(7, workingDay.isWednesday());
        ps.setBoolean(8, workingDay.isThursday());
        ps.setBoolean(9, workingDay.isFriday());
        ps.setBoolean(10, workingDay.isSaturday());
        ps.setBoolean(11, workingDay.isSunday());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public boolean deleteWorkingHoursAnddays(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from working_days where working_day_id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    public WorkingDay getWorkingDayById(int id) throws SQLException {
        ResultSet rset = new CommonDaoImpl().getResultByAttribute(selectQuery,
                "working_day_id", CommonConstants.sql.EQUAL, Integer.toString(id));
        WorkingDay wrkday = null;
        while (rset.next()) {
            wrkday = new WorkingDay();
            wrkday.setId(rset.getInt("working_day_id"));
            wrkday.setNoOfWorkingDays(rset.getInt("working_day_no_work_days"));
            wrkday.setHours(rset.getInt("working_day_hours"));
            wrkday.setMinutes(rset.getInt("working_day_minutes"));
            wrkday.setDayAmount(rset.getBigDecimal("working_day_amount"));
            wrkday.setMonday(rset.getBoolean("working_day_monday"));
            wrkday.setTuesday(rset.getBoolean("working_day_tuesday"));
            wrkday.setWednesday(rset.getBoolean("working_day_wednesday"));
            wrkday.setThursday(rset.getBoolean("working_day_thursday"));
            wrkday.setFriday(rset.getBoolean("working_day_friday"));
            wrkday.setSaturday(rset.getBoolean("working_day_saturday"));
            wrkday.setSunday(rset.getBoolean("working_day_sunday"));
        }
        return wrkday;
    }

    public ResultSet getAllRecords() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }
}
