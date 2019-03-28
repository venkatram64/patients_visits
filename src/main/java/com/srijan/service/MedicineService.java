package com.srijan.service;

import com.srijan.common.DBConnection;
import com.srijan.model.Illness;
import com.srijan.model.Medicine;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineService implements Serializable {

    public List<Medicine> getMedicineByIllness(String illnessType) throws SQLException, ClassNotFoundException {

        List<Medicine> list = new ArrayList<>();

        String sql = "SELECT * FROM medicine_table where illness_type = ?";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, illnessType);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String illnessType_ = resultSet.getString("illness_type");
            String name = resultSet.getString("name");
            String prevention = resultSet.getString("prevention");
            Medicine illness = new Medicine(illnessType_, name, prevention);
            list.add(illness);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return list;
    }
}
