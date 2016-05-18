package com.pactera.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pactera.bean.LeaveEntitlementBean;
import com.pactera.bean.ParameterBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.LeaveEntitlementDao;
import com.pactera.dao.ParameterDao;

/**
 * Servlet implementation class UpdateLeaveEntitlement
 */
public class UpdateLeaveEntitlementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	DaoFactory daoFactory = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLeaveEntitlementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
        // initialize DAO factory
        daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    }

	/**	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String leave_id = request.getParameter("leave_entitlement_id");
		LeaveEntitlementDao leaveDao = daoFactory.getLeaveEntitlementDao();
		ParameterDao paramDao = daoFactory.getParameterDao();
		
		LeaveEntitlementBean leaveBean = leaveDao.retrieveLeaveEntitlement(leave_id);
		
		List<ParameterBean> listOfParam= (List<ParameterBean>) paramDao.retrieveAllParam();
		
		request.setAttribute("listOfParam", listOfParam);
		request.setAttribute("leaveBean", leaveBean);
		
		request.getRequestDispatcher("update_leave_entitlement.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveEntitlementDao leaveDao = daoFactory.getLeaveEntitlementDao();
		
		int leaveId = Integer.parseInt(request.getParameter("leave_entitlement_id"));
		int criteriaFrom = Integer.parseInt(request.getParameter("criteriaFrom"));
		int criteriaUntil = Integer.parseInt(request.getParameter("criteriaUntil"));
		String empGrade = request.getParameter("empGrade");
		int days = Integer.parseInt(request.getParameter("noOfLeaveEntitlement"));
		
		leaveDao.updateLeaveEntitlement(leaveId, criteriaFrom, criteriaUntil, empGrade, days);
		
		List<LeaveEntitlementBean> listOfLeave = (List<LeaveEntitlementBean>) leaveDao.retrieveAllUser();
	
		request.setAttribute("listOfLeave", listOfLeave);
		
		request.getRequestDispatcher("leave_entitlement.jsp").forward(request, response);
		//doGet(request, response);
	}

}
