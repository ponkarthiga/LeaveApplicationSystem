package com.pactera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.pactera.bean.LeaveEntitlementBean;

public class MySqlLeaveEntitlementDao implements LeaveEntitlementDao {

	public List<LeaveEntitlementBean> retrieveAllUser() {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT * FROM leave_entitlement";
		LeaveEntitlementBean user = null;

		List<LeaveEntitlementBean> listOfLeave = new Vector<LeaveEntitlementBean>();

		try {
			statement = connection.prepareStatement(sqlStatement);

			result = statement.executeQuery();
			while (result.next()) {
				user = new LeaveEntitlementBean();
				user.setLeaveEntitlementId(result.getInt(1));
				user.setLeaveType(result.getString(2));
				user.setCriteriaFrom(result.getInt(3));
				user.setCriteriaUntil(result.getInt(4));
				user.setEmpGrade(result.getString(5));
				user.setDays(result.getInt(6));

				listOfLeave.add(user);
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
		return listOfLeave;
	}

	public LeaveEntitlementBean retrieveLeaveEntitlement(String leave_id) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;

		String sqlStatement = "SELECT leave_entitlement_id, leave_type, criteria_from, criteria_until, employee_grade, days"
				+ " FROM leave_entitlement WHERE leave_entitlement_id=?";

		LeaveEntitlementBean leave = null;
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, leave_id);

			result = statement.executeQuery();

			if (result.next()) {
				leave = new LeaveEntitlementBean();
				leave.setLeaveEntitlementId(result.getInt(1));
				leave.setLeaveType(result.getString(2));
				leave.setCriteriaFrom(result.getInt(3));
				leave.setCriteriaUntil(result.getInt(4));
				leave.setEmpGrade(result.getString(5));
				leave.setDays(result.getInt(6));
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
		return leave;

	}

	public boolean updateLeaveEntitlement(int leaveId, int criteriaFrom, int criteriaUntil, String empGrade,
			int days) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		String sqlStatement = "UPDATE leave_entitlement SET criteria_from = ?, criteria_until = ?, employee_grade = ?,"
				+ " days = ? WHERE leave_entitlement_id = ?";
				
		try {			
			statement = connection.prepareStatement(sqlStatement);
			//statement.setString(1, leaveType);
			statement.setInt(1, criteriaFrom);
			statement.setInt(2, criteriaUntil);
			statement.setString(3, empGrade);
			statement.setInt(4, days);
			statement.setInt(5, leaveId);

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

	public boolean createLeaveEntitlement(String leaveType, int criteriaFrom, int criteriaUntil, String empGrade, int days) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		
		String sqlStatement = "INSERT INTO leave_entitlement (leave_type, "
				+ "criteria_from, criteria_until, employee_grade, days) VALUES (?, ?, ?, ?, ?)";
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, leaveType);
			statement.setInt(2, criteriaFrom);
			statement.setInt(3, criteriaUntil);
			statement.setString(4, empGrade);
			statement.setInt(5, days);

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
}
