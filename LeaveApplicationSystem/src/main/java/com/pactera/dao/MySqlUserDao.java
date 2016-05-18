package com.pactera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.pactera.bean.UserBean;

public class MySqlUserDao implements UserDao {
	public boolean createUser(UserBean user) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		
		String sqlStatement = "INSERT INTO employee (employee_id, employee_name, "
				+ "employee_email, manager_name, department_name, hire_date, al_taken,"
				+"al_balance,el_taken,mc_taken,mc_balance,unpaid_taken,) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, user.getEmpId());
			statement.setString(2, user.getEmpName());
			statement.setString(3, user.getEmpEmail());
			statement.setString(4, user.getManagerName());
			statement.setString(5, user.getEmpDepartment());
			statement.setDate(6, (java.sql.Date) user.getHireDate());
			statement.setInt(7, user.getAlTaken());
			statement.setInt(8, user.getAlBalance());
			statement.setInt(9, user.getElTaken());
			statement.setInt(10, user.getMcTaken());
			statement.setInt(11, user.getMcBalance());
			statement.setInt(12, user.getUnpaidTaken());

		
//		String sqlStatement = "INSERT INTO lar_user (user_name, user_pass, "
//				+ "first_name, middle_name, last_name,) VALUES (?, ?, ?, ?, ?)";
//		try {
//			statement = connection.prepareStatement(sqlStatement);
//			statement.setString(1, user.getUserName());
//			statement.setString(2, user.getPassword());
//			statement.setString(3, user.getFname());
//			statement.setString(4, user.getMname());
//			statement.setString(5, user.getLname());

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

	public UserBean retrieveUser(String employeeId) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		String sqlStatement = "SELECT employee_id, employee_name, employee_email, manager_name, department_name, hire_date," +
				"al_taken,al_balance,el_taken,mc_taken,mc_balance,unpaid_taken"
				+ " FROM employee WHERE employee_id=?";
		
		UserBean user = null;
		try{
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, employeeId);
		
			result = statement.executeQuery();
			
			if(result.next()){
				user = new UserBean();
				user.setEmpId(result.getString(1));
				user.setEmpName(result.getString(2));
				user.setEmpEmail(result.getString(3));
				user.setManagerName(result.getString(4));
				user.setEmpDepartment(result.getString(5));
				user.setHireDate(result.getDate(6));
				user.setAlTaken(result.getInt(7));
				user.setAlBalance(result.getInt(8));
				user.setElTaken(result.getInt(9));
				user.setMcTaken(result.getInt(10));
				user.setMcBalance(result.getInt(11));
				user.setUnpaidTaken(result.getInt(12));
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

	public boolean updateUser(int userId, String firstName) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		String sqlStatement = "UPDATE lar_user SET first_name = ? "
				+ "WHERE user_id = ?";
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, firstName);
			statement.setInt(2, userId);

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
	
	public List<UserBean> retrieveAllUser() {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT * FROM employee";
		UserBean user = null;
		
		List<UserBean> listOfUsers = new Vector<UserBean>();
		
		try {
			statement = connection.prepareStatement(sqlStatement);

			result = statement.executeQuery();
			while (result.next()) {
				user = new UserBean();
				user.setEmpId(result.getString(1));
				user.setEmpName(result.getString(2));
				user.setEmpEmail(result.getString(3));
				user.setManagerName(result.getString(4));
				user.setEmpDepartment(result.getString(5));
				user.setHireDate(result.getDate(6));
				user.setAlTaken(result.getInt(7));
				user.setAlBalance(result.getInt(8));
				user.setElTaken(result.getInt(9));
				user.setMcTaken(result.getInt(10));
				user.setMcBalance(result.getInt(11));
				user.setUnpaidTaken(result.getInt(12));
				
				listOfUsers.add(user);
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
		return listOfUsers;
	}
	
	public List<String> autoCompleteUser(String query) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT employee_id FROM employee";
		List<String> listOfMatchedId = new ArrayList<String>();
		query = query.toLowerCase();
		
		try {
			statement = connection.prepareStatement(sqlStatement);

			result = statement.executeQuery();
			while (result.next()) {
				String id = result.getString(1).toLowerCase();
				if(id.startsWith(query)) {
					listOfMatchedId.add(result.getString(1).trim());
				}
			}
		}catch (SQLException e) {
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
		return listOfMatchedId;
	}

	public List<UserBean> searchUser(String employeeId, String employeeName) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT * FROM employee WHERE employee_id LIKE '%" +employeeId+ "%' AND employee_name LIKE '%"+ employeeName +"%' ";
		UserBean user = null;
		
		List<UserBean> listOfUsers = new Vector<UserBean>();
		
		try {
			statement = connection.prepareStatement(sqlStatement);
			
			result = statement.executeQuery();
			while (result.next()) {
				user = new UserBean();
				user.setEmpId(result.getString(1));
				user.setEmpName(result.getString(2));
				user.setEmpEmail(result.getString(3));
				user.setManagerName(result.getString(4));
				user.setEmpDepartment(result.getString(5));
				user.setHireDate(result.getDate(6));
				user.setAlTaken(result.getInt(7));
				user.setAlBalance(result.getInt(8));
				user.setElTaken(result.getInt(9));
				user.setMcTaken(result.getInt(10));
				user.setMcBalance(result.getInt(11));
				user.setUnpaidTaken(result.getInt(12));
				
				listOfUsers.add(user);
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
		return listOfUsers;
	}
}
