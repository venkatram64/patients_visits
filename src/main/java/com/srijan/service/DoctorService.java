package com.srijan.service;

import com.srijan.common.DBConnection;
import com.srijan.model.Doctor;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorService implements Serializable {

    public List<Doctor> getAll() throws SQLException, ClassNotFoundException {

        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String email = resultSet.getString("email_id");
            String specialist = resultSet.getString("specialist");
            Doctor doctor = new  Doctor(name, email, specialist);
            list.add(doctor);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return list;
    }
}
