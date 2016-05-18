package com.pactera.servlet;

import java.io.IOException;
//import java.util.Date;
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
 * Servlet implementation class ShowLeaveServlet
 */
public class UpdateLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLeaveServlet() {
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
		LeaveDao leaveDao = daoFactory.getLeaveDao();
		String step = request.getParameter("step");
		if (step.equals("edit")){
			String editLeave = (String) request.getParameter("leave_id");
			editLeave = (editLeave == null) ? "0" : editLeave;
		
			LeaveBean leaveBean = leaveDao.retrieveLeave(Integer.parseInt(editLeave));
			request.setAttribute("leaveBean", leaveBean);
			request.getRequestDispatcher("editleave.jsp").forward(request, response);
//			response.getWriter().append("Served at: ").append(request.getContextPath());
		
		}
		else {
			int leaveid = Integer.parseInt(request.getParameter("leave_id"));
			Boolean foo = leaveDao.deleteLeave(leaveid);
			
			List<LeaveBean> leaves = leaveDao.retrieveLeaves();
			
			request.setAttribute("leaves", leaves);
			request.getRequestDispatcher("showall.jsp").forward(request,response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveDao leaveDao 	= 	daoFactory.getLeaveDao();
		int leaveId       	= 	Integer.parseInt(request.getParameter("leaveId"));
		String leaveDate  	= 	request.getParameter("ldate");
		String leaveFrom  	= 	request.getParameter("leavefrom");
		String leaveTo    	=	request.getParameter("leaveto");
		Boolean foo = leaveDao.updateLeave(leaveId, leaveDate, leaveFrom, leaveTo);
		
		//LeaveBean leaveBean = leaveDao.retrieveLeave(leaveId);
		//request.setAttribute("leaveBean", leaveBean);
		
		System.out.println("Record update status.."+foo);
		//request.getRequestDispatcher("showall.jsp").forward(request,response);
		
		
		List<LeaveBean> leaves = leaveDao.retrieveLeaves();
		
		request.setAttribute("leaves", leaves);
		request.getRequestDispatcher("showall.jsp").forward(request,response);
	}

}
