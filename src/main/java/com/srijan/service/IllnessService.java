package com.srijan.service;

import com.srijan.common.DBConnection;
import com.srijan.model.Illness;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IllnessService implements Serializable {

    public List<Illness> getAll() throws SQLException, ClassNotFoundException {

        List<Illness> list = new ArrayList<>();

        String sql = "SELECT * FROM illnes_table";

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String illnessType = resultSet.getString("illness_type");
            String description = resultSet.getString("description");
            Illness illness = new Illness(illnessType, description);
            list.add(illness);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return list;
    }
}
