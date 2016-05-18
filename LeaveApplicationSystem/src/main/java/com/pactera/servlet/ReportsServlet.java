package com.pactera.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pactera.convert.CsvFileWriter;
import com.pactera.bean.ParameterBean;
import com.pactera.bean.UserBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.ParameterDao;
import com.pactera.dao.UserDao;

/**
 * Servlet implementation class ReportsServlet
 */
public class ReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DaoFactory daoFactory = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsServlet() {
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
		UserDao employeeDao = daoFactory.getUserDao();
		
		List<ParameterBean> listOfParam= (List<ParameterBean>) paramDao.retrieveAllParam();
		request.setAttribute("listOfParam", listOfParam);
		
		List<UserBean> listOfEmployee= null;
		
		try{
			String buttonClicked = request.getParameter("clicked");
			if(buttonClicked.equals("0")){
				String employeeId = request.getParameter("empId");
				String employeeName = request.getParameter("empName");
				
				listOfEmployee = (List<UserBean>) employeeDao.searchUser(employeeId, employeeName);
				
				DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HH_mm_ss");
				Date date = new Date();
				String todaysDate = (String)dateFormat.format(date);
				
				String fileName = System.getProperty("user.home")+"/desktop/reports"+todaysDate+".csv";
				
				CsvFileWriter.writeCsvFile(fileName,listOfEmployee);
				
				request.setAttribute("empId", employeeId);
				request.setAttribute("empName", employeeName);
				request.setAttribute("listOfEmployee", listOfEmployee);
			}	
		}catch(NullPointerException e){
			listOfEmployee= (List<UserBean>) employeeDao.retrieveAllUser();
			request.setAttribute("listOfEmployee", listOfEmployee);
		}		
		request.getRequestDispatcher("reports.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParameterDao paramDao = daoFactory.getParameterDao();
		UserDao userDao = daoFactory.getUserDao();
		
		String employeeId = request.getParameter("empId");
		String employeeName = request.getParameter("empName");	
		
		List<UserBean> listOfEmployee = (List<UserBean>) userDao.searchUser(employeeId, employeeName);
		List<ParameterBean> listOfParam= (List<ParameterBean>) paramDao.retrieveAllParam();
		
		request.setAttribute("empId", employeeId);
		request.setAttribute("empName", employeeName);
		request.setAttribute("listOfEmployee", listOfEmployee);
		request.setAttribute("listOfParam", listOfParam);
		request.getRequestDispatcher("reports.jsp").forward(request, response);
	}

}
