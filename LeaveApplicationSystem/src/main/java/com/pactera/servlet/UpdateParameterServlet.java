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
 * Servlet implementation class UpdateParameterServlet
 */
public class UpdateParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateParameterServlet() {
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
		
		String parameter_id = request.getParameter("parameter_id");
		ParameterDao paramDao = daoFactory.getParameterDao();
		
		ParameterBean paramBean = paramDao.retrieveParam(Integer.parseInt(parameter_id));
		request.setAttribute("paramBean", paramBean);
		
		request.getRequestDispatcher("update_system_parameter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParameterDao paramDao = daoFactory.getParameterDao();
		
		int parameterId = Integer.parseInt(request.getParameter("parameter_id"));
		String parameterType = request.getParameter("parameterType");
		String parameterCode = request.getParameter("parameterCode");
		String desc = request.getParameter("parameterDescription");
		
		paramDao.updateParameter(parameterId, parameterType, parameterCode, desc);
		
		//response.sendRedirect("system_parameter.jsp");
		//doGet(request, response);
	
		List<ParameterBean> listOfParam = (List<ParameterBean>) paramDao.retrieveAllParam();
	
		request.setAttribute("listOfParam", listOfParam);
		
		request.getRequestDispatcher("system_parameter.jsp").forward(request, response);
	
	}

}
