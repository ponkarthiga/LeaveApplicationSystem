package com.pactera.dao;

import com.pactera.bean.UserBean;

public interface UserDao {
	public abstract boolean createUser(UserBean user);
	public abstract UserBean retrieveUser(String username);
	public abstract boolean updateUser(int userId, String firstName);
}
