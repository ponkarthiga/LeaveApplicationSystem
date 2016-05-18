package com.pactera.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pactera.bean.ParameterBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.LeaveEntitlementDao;
import com.pactera.dao.ParameterDao;

/**
 * Servlet implementation class AddSystemParameterServlet
 */
public class AddSystemParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DaoFactory daoFactory = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSystemParameterServlet() {
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
		request.getRequestDispatcher("add_system_parameter.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParameterDao paramDao = daoFactory.getParameterDao();
		
		String paramType = request.getParameter("paramType");
		String code = request.getParameter("paramCode");
		String desc = request.getParameter("desc");
		
		paramDao.createParameter(paramType, code, desc);
		
		List<ParameterBean> listOfParam = (List<ParameterBean>) paramDao.retrieveAllParam();
		
		request.setAttribute("listOfParam", listOfParam);
		
		request.getRequestDispatcher("system_parameter.jsp").forward(request, response);
	}

}
