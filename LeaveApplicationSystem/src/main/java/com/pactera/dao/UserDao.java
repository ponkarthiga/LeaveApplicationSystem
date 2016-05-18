package com.pactera.dao;

import java.util.List;

import com.pactera.bean.UserBean;

public interface UserDao {
	public abstract boolean createUser(UserBean user);
	public abstract UserBean retrieveUser(String username);
	public abstract boolean updateUser(int userId, String firstName);
	public abstract List<UserBean> retrieveAllUser();
	public abstract List<String> autoCompleteUser(String query);
	public abstract List<UserBean> searchUser(String employeeId, String employeeName);
}
