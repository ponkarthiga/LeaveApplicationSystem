package com.pactera.servlet;

import java.io.IOException;
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
 * Servlet implementation class DeleteLeaveServlet
 */
public class DeleteLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoFactory daoFactory = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLeaveServlet() {
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
		int leaveid = Integer.parseInt(request.getParameter("leave_id"));
		Boolean foo = leaveDao.deleteLeave(leaveid);
		
		List<LeaveBean> leaves = leaveDao.retrieveLeaves();
		
		request.setAttribute("leaves", leaves);
		request.getRequestDispatcher("showall.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
