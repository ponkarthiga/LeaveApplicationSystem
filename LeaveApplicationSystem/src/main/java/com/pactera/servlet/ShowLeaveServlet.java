package com.pactera.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pactera.bean.LeaveBean;
import com.pactera.bean.UserBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.LeaveDao;

/**
 * Servlet implementation class UpdateLeaveServlet
 */
public class ShowLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowLeaveServlet() {
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
		//request.getRequestDispatcher("leave.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		System.out.println("LEAVEDAO ==> " + leaveDao.toString());
//		System.out.println("lDATE ==> " + request.getParameter("ldate"));
		
		LeaveDao leaveDao = daoFactory.getLeaveDao();
		//request.getAttribute(leave);
		
		LeaveBean leave = leaveDao.retrieveLeave(Integer.parseInt(request.getParameter("leaveId")));
		
		request.setAttribute("leave", leave);
		request.getRequestDispatcher("showall.jsp").forward(request,response);
		
		
	}

}
