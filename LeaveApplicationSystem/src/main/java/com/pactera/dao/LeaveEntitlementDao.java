package com.pactera.dao;

import java.util.List;

import com.pactera.bean.LeaveEntitlementBean;

public interface LeaveEntitlementDao {
	public abstract boolean createLeaveEntitlement(String leaveType, int criteriaFrom, int criteriaUntil, String empGrade, int days);
	public abstract List<LeaveEntitlementBean> retrieveAllUser();
	public abstract LeaveEntitlementBean retrieveLeaveEntitlement(String leave_id);
	public abstract boolean updateLeaveEntitlement(int leaveId, int criteriaFrom, int criteriaUntil, String empGrade, int days);
}
