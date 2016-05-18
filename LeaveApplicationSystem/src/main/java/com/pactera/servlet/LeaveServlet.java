package com.pactera.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pactera.bean.LeaveBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.LeaveDao;



/**
 * Servlet implementation class AppLeaveServlet
 */
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = null;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("leave.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		LeaveDao leaveDao = daoFactory.getLeaveDao();
		
		LeaveBean leaveBean    =    new LeaveBean();
		String ltype           =    request.getParameter("type");
		String forwardTo       = 	request.getParameter("frwd");
		String ldur            =    request.getParameter("dur");
		String ldate           =    request.getParameter("date");
		String lperiod         =    request.getParameter("period");
		String lfrom           =    request.getParameter("from");
		String lto             =    request.getParameter("to");
		String reason          =    request.getParameter("reason");
		String apprvlStatus    =    request.getParameter("status");
		
				
		leaveBean.setLeaveType(ltype);
		leaveBean.setFrwdAppl(forwardTo);
		leaveBean.setLeaveDate(ldate);
		leaveBean.setLeaveDur(ldur);
		leaveBean.setLeavePeriod(lperiod);
		leaveBean.setLeaveFrom(lfrom);
		leaveBean.setLeaveTo(lto);
		leaveBean.setLeaveReason(reason);
		leaveBean.setApprovalStatus(apprvlStatus);
		
		Boolean foo = leaveDao.createLeave(leaveBean);
		
		//request.getRequestDispatcher("leaveapply.jsp").forward(request, response);
        //LeaveDao leaveDao = daoFactory.getLeaveDao();
		//request.getAttribute(leave);
		
		List<LeaveBean> leaves = leaveDao.retrieveLeaves();
		
		request.setAttribute("leaves", leaves);
		request.getRequestDispatcher("showall.jsp").forward(request,response);
		
			
	}

}
