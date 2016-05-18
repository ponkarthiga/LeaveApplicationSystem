package com.pactera.bean;

import java.sql.Date;

public class LeaveBean {
	private int leaveId;
	private String leaveType;
	private String frwdAppl;
	private String leaveDur;
	private String leaveDate;
	private String leavePeriod;
	private String leaveFrom;
	private String leaveTo;
	private String leaveReason;
	private String dateCreated;
	private String dateUpdated;
	private String approvalStatus;
	
	public int getLeaveId() {
		return leaveId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getFrwdAppl() {
		return frwdAppl;
	}
	public void setFrwdAppl(String frwdAppl) {
		this.frwdAppl = frwdAppl;
	}
	public String getLeaveDur() {
		return leaveDur;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public void setLeaveDur(String leaveDur) {
		this.leaveDur = leaveDur;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getLeavePeriod() {
		return leavePeriod;
	}
	public void setLeavePeriod(String leavePeriod) {
		this.leavePeriod = leavePeriod;
	}
	public String getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(String leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public String getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(String leaveTo) {
		this.leaveTo = leaveTo;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	


	

}
