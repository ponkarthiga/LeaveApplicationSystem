package com.pactera.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pactera.bean.LeaveBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.LeaveDao;

/**
 * Servlet implementation class LeaveListServlet
 */
public class LeaveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoFactory daoFactory = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveListServlet() {
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
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LeaveDao leaveDao = daoFactory.getLeaveDao();
		//System.out.println(request.getParameter("leaveId"));
		//LeaveBean leave = leaveDao.retrieveLeave(Integer.parseInt(request.getParameter("leaveId")));
		
		List<LeaveBean> listofleaves = new ArrayList<LeaveBean>();
		listofleaves = (List<LeaveBean>) leaveDao.retrieveLeaves();
		 request.setAttribute("leaves", listofleaves);
		 request.getRequestDispatcher("showall.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LeaveDao leaveDao = daoFactory.getLeaveDao();
		//System.out.println(request.getParameter("leaveId"));
		//LeaveBean leave = leaveDao.retrieveLeave(Integer.parseInt(request.getParameter("leaveId")));
		
		List<LeaveBean> listofleaves = new ArrayList<LeaveBean>();
		listofleaves = (List<LeaveBean>) leaveDao.retrieveLeaves();
		 request.setAttribute("leaves", listofleaves);
		 request.getRequestDispatcher("showall.jsp").forward(request,response);
	}

}
