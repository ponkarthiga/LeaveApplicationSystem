package com.pactera.bean;

public class LeaveEntitlementBean {
	private int leaveEntitlementId;
	private String leaveType;
	private int criteriaFrom;
	private int criteriaUntil;
	private String empGrade;
	private int days;
	
	public int getLeaveEntitlementId() {
		return leaveEntitlementId;
	}
	public void setLeaveEntitlementId(int leaveEntitlementId) {
		this.leaveEntitlementId = leaveEntitlementId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public int getCriteriaFrom() {
		return criteriaFrom;
	}
	public void setCriteriaFrom(int criteriaFrom) {
		this.criteriaFrom = criteriaFrom;
	}
	public int getCriteriaUntil() {
		return criteriaUntil;
	}
	public void setCriteriaUntil(int criteriaUntil) {
		this.criteriaUntil = criteriaUntil;
	}
	public String getEmpGrade() {
		return empGrade;
	}
	public void setEmpGrade(String empGrade) {
		this.empGrade = empGrade;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	
	
}
