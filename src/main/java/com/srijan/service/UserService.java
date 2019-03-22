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

            user = new User(id, firstName, lastName, emailId, password);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return user;
    }

    public boolean addUser(User user) throws SQLException, ClassNotFoundException{

        String sql = "INSERT INTO users (first_name, last_name, email_id, password) VALUES (?, ?, ?, ?)";
        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmailId());
        statement.setString(4, user.getPassword());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        connection.close();
        return rowInserted;
    }

}
