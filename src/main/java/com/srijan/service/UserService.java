package com.srijan.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.srijan.common.DBConnection;
import com.srijan.model.User;

public class UserService implements Serializable{
	
	public User getUserByEmailId(String emailId) throws SQLException, ClassNotFoundException {
		
        User user = null;
        String sql = "SELECT * FROM users WHERE email_id = ?";

        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, emailId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
        	int id = resultSet.getInt("user_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String emialId = resultSet.getString("email_id");
            String password = resultSet.getString("password");
            int roleId = resultSet.getInt("role_id");

            user = new User(id, firstName, lastName, emailId, password,roleId);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }

}
