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
import com.pactera.dao.ParameterDao;

/**
 * Servlet implementation class SystemParameterServlet
 */
public class SystemParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoFactory daoFactory = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemParameterServlet() {
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
		ParameterDao paramDao = daoFactory.getParameterDao();
		List<ParameterBean> listOfParam = (List<ParameterBean>) paramDao.retrieveAllParam();
	
		request.setAttribute("listOfParam", listOfParam);
		
		request.getRequestDispatcher("system_parameter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
