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
 * Servlet implementation class LeaveEntitlementServlet
 */
public class LeaveEntitlementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoFactory daoFactory = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveEntitlementServlet() {
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
		LeaveEntitlementDao leaveDao = daoFactory.getLeaveEntitlementDao();
		List<LeaveEntitlementBean> listOfLeave = (List<LeaveEntitlementBean>) leaveDao.retrieveAllUser();
	
		request.setAttribute("listOfLeave", listOfLeave);
		
		request.getRequestDispatcher("leave_entitlement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
