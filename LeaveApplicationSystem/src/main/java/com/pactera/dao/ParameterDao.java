package com.pactera.dao;

import java.util.List;

import com.pactera.bean.ParameterBean;

public interface ParameterDao {
	public abstract boolean createParameter(String paramType, String paramCode, String desc);
	public abstract ParameterBean retrieveParam(int parameterId);
	public abstract boolean updateParameter(int parameterId, String parameterType, String parameterCode, String desc);
	public abstract List<ParameterBean> retrieveAllParam();
}
