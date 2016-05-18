package com.pactera.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.pactera.bean.LeaveBean;
import com.pactera.bean.UserBean;

public class MySqlLeaveDao implements LeaveDao {

	public boolean createLeave(LeaveBean leave) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		Calendar calendar = Calendar.getInstance();
	    java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	      
		String sqlStatement = "INSERT INTO leave_apply (leave_type, frwd_appl, leave_dur, leave_date, "
				+ "leave_period, leave_from, leave_to, leave_reason, date_created, approval_status)"
				+ " VALUES (?, ?, ?, str_to_date(?, '%m/%d/%Y'), ?, str_to_date(?,'%m/%d/%Y'), str_to_date(?,'%m/%d/%Y'), ?, sysdate(), ?)";
		try{
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, leave.getLeaveType());
			statement.setString(2, leave.getFrwdAppl());
			statement.setString(3, leave.getLeaveDur());
			
			statement.setString(4, leave.getLeaveDate());
			statement.setString(5, leave.getLeavePeriod());
			statement.setString(6, leave.getLeaveFrom());
			
			statement.setString(7, leave.getLeaveTo());
			statement.setString(8, leave.getLeaveReason());
		
			statement.setString(9, leave.getApprovalStatus());

			rows = statement.executeUpdate();
			}catch(SQLException e){
			e.printStackTrace();
			}finally{
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
		return(1 == rows);
		
	}

	public LeaveBean retrieveLeave(int leaveId) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT leave_id,leave_type,frwd_appl,leave_dur,leave_date,leave_period,"
				+"leave_from,leave_to,leave_reason FROM leave_apply where leave_id=?";
		LeaveBean leave = null;
		try{
			statement = connection.prepareStatement(sqlStatement);
			statement.setInt(1, leaveId);
			result = statement.executeQuery();
			if (result.next()) {
				leave = new LeaveBean();
				leave.setLeaveId(result.getInt(1)); ;
				leave.setLeaveType(result.getString(2));
				leave.setFrwdAppl(result.getString(3));
				leave.setLeaveDur(result.getString(4));
				leave.setLeaveDate(result.getString(5));
				leave.setLeavePeriod(result.getString(6));
				leave.setLeaveFrom(result.getString(7));
				leave.setLeaveTo(result.getString(8));
				leave.setLeaveReason(result.getString(9));
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

//	public boolean updateLeave(int leaveId, Date leaveDate,String leaveFrom,String leaveTo) {
//		Connection connection = MySqlDaoFactory.createConnection();
//		PreparedStatement statement = null;
//		int rows = 0;
//		String sqlStatement = "UPDATE leave_appl SET leave_date = ?,leave_from = ? ,leave_to = ?"
//				+ "WHERE leave_id = ?";
//		try {
//			statement = connection.prepareStatement(sqlStatement);
//			statement.setDate(1, leaveDate);
//			statement.setInt(2, leaveId);
//			statement.setString(3, leaveFrom);
//			statement.setString(4, leaveTo);
//
//			rows = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (null != statement) {
//				try {
//					statement.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (null != connection) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return (1 == rows);
//	}
	
	public List<LeaveBean> retrieveLeaves() {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT *  FROM leave_apply where approval_status != 'Deleted'";
		LeaveBean leave = null;
		
		List<LeaveBean> listOfLeaves = new Vector<LeaveBean>();
		
		try {
			statement = connection.prepareStatement(sqlStatement);

			result = statement.executeQuery();
			while (result.next()) {
				leave = new LeaveBean();
				leave.setLeaveId(result.getInt(1));
				leave.setLeaveType(result.getString(2));
				leave.setFrwdAppl(result.getString(3));
				leave.setLeaveDate(result.getString(4));
				leave.setLeavePeriod(result.getString(5));
				leave.setLeaveDur(result.getString(6));
				leave.setLeaveFrom(result.getString(7));
				leave.setLeaveTo(result.getString(8));
				leave.setLeaveReason(result.getString(9));
				leave.setDateCreated(result.getString(10));
				leave.setDateUpdated(result.getString(11));
				leave.setApprovalStatus(result.getString(12));
				listOfLeaves.add(leave);
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
		return listOfLeaves;
	}

	public boolean updateLeave(int leaveId, String leaveDate, String leaveFrom, String leaveTo) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		String sqlStatement = "UPDATE leave_apply SET leave_date = str_to_date(?, '%m/%d/%Y'),leave_from = str_to_date(?, '%m/%d/%Y') ,"
				+"leave_to = str_to_date(?, '%m/%d/%Y'),date_updated=sysdate()"
				+ "WHERE leave_id = ?";
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, leaveDate);
			statement.setString(2, leaveFrom);
			statement.setString(3, leaveTo);
			statement.setInt(4, leaveId);

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
	public boolean deleteLeave(int leaveId) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		//int rows = 0;
		String sqlStatement = "update leave_apply set approval_status='Deleted' WHERE leave_id = ?";
		try {
			statement = connection.prepareStatement(sqlStatement);
			
			statement.setInt(1, leaveId);

			statement.executeUpdate();
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
		return true;
	}

}
