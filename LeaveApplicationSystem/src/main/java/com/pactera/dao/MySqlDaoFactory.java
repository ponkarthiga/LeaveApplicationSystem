package com.pactera.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory extends DaoFactory {
	/** The JDBC driver for MySQL. */
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/** The MySQL database URL. */
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/lar";

	/** The MySQL database username. */
	private static final String DATABASE_USER = "root";

	/** The MySQL database password. */
	private static final String DATABASE_PASSWORD = "root";

	/**
	 * Opens a connection to a MySQL database.
	 *
	 * @return a MySQL connection on success, or <code>null</code> on failure
	 */
	public static Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
    /**
     * Returns the DAO for <code>UserBean</code> object instances.
     *
     * @return  the DAO for <code>UserBean</code>
     */
    public UserDao getUserDao() {
        return new MySqlUserDao();
    }
}
