package com.pactera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pactera.bean.UserBean;

public class MySqlUserDao implements UserDao {
	public boolean createUser(UserBean user) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		String sqlStatement = "INSERT INTO lar_user (user_name, user_pass, "
				+ "first_name, middle_name, last_name,) VALUES (?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, user.getUserName());
			statement.setString(1, user.getPassword());
			statement.setString(1, user.getFname());
			statement.setString(1, user.getMname());
			statement.setString(1, user.getLname());

			rows = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != statement) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (1 == rows);
	}

	public UserBean retrieveUser(String username) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT user_id, user_name, user_pass, first_name, middle_name, last_name"
				+ " FROM lar_user WHERE username=?";
		UserBean user = null;
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, username);

			result = statement.executeQuery();
			if (result.next()) {
				user = new UserBean();
				user.setUserName(result.getString(1));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != result) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != statement) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != connection) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}
}
