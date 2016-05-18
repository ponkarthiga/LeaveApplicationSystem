package com.pactera.dao;

//import java.util.Date;
import java.util.List;

import com.pactera.bean.LeaveBean;

public interface LeaveDao {
	public abstract boolean createLeave(LeaveBean leave);
	public abstract LeaveBean retrieveLeave(int leaveId);
	public abstract boolean updateLeave(int leaveId,String leaveDate,String leaveFrom,String leaveTo);
	public abstract List<LeaveBean> retrieveLeaves();
	public abstract boolean deleteLeave(int leaveId);

}
