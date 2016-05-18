package com.pactera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.pactera.bean.ParameterBean;

public class MySqlParameterDao implements ParameterDao{

	public ParameterBean retrieveParam(int parameterId) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		String sqlStatement = "SELECT parameter_id, parameter_type, parameter_code, parameter_desc"
				+ " FROM system_parameter WHERE parameter_id=?";
		
		ParameterBean parameter = null;
		try{
			statement = connection.prepareStatement(sqlStatement);
			statement.setInt(1, parameterId);
		
			result = statement.executeQuery();
			
			if(result.next()){
				parameter = new ParameterBean();
				parameter.setParameterId(result.getInt(1));
				parameter.setParameterType(result.getString(2));
				parameter.setParameterCode(result.getString(3));
				parameter.setDesc(result.getString(4));
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
		return parameter;
	}

	public boolean updateParameter(int parameterId, String parameterType, String parameterCode, String desc) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		String sqlStatement = "UPDATE system_parameter SET parameter_type = ?, parameter_code = ?, parameter_desc = ?"
				+ " WHERE parameter_id = ?";
				
		try {			
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, parameterType);
			statement.setString(2, parameterCode);
			statement.setString(3, desc);
			statement.setInt(4, parameterId);

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

	public List<ParameterBean> retrieveAllParam() {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		String sqlStatement = "SELECT * FROM system_parameter";
		ParameterBean parameter = null;

		List<ParameterBean> listOfParam = new Vector<ParameterBean>();

		try {
			statement = connection.prepareStatement(sqlStatement);

			result = statement.executeQuery();
			while (result.next()) {
				parameter = new ParameterBean();
				parameter.setParameterId(result.getInt(1));
				parameter.setParameterType(result.getString(2));
				parameter.setParameterCode(result.getString(3));
				parameter.setDesc(result.getString(4));

				listOfParam.add(parameter);
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
		return listOfParam;
	}

	public boolean createParameter(String paramType, String paramCode, String desc) {
		Connection connection = MySqlDaoFactory.createConnection();
		PreparedStatement statement = null;
		int rows = 0;
		
		String sqlStatement = "INSERT INTO system_parameter (parameter_type, "
				+ "parameter_code, parameter_desc) VALUES (?, ?, ?)";
		try {
			statement = connection.prepareStatement(sqlStatement);
			statement.setString(1, paramType);
			statement.setString(2, paramCode);
			statement.setString(3, desc);

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
