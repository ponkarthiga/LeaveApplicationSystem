package com.pactera.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pactera.bean.UserBean;
import com.pactera.dao.DaoFactory;
import com.pactera.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   /** The DAO factory. */
    DaoFactory daoFactory = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Called by the servlet container to indicate to a servlet that the servlet
     * is being placed into service.
     *
     * @param   config the servlet configuration
     * @throws  ServletException if a servlet exception occurred
     */
    public void init(ServletConfig config) throws ServletException {
        // initialize DAO factory
        daoFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = daoFactory.getUserDao();
		
		UserBean user = userDao.retrieveUser(request.getParameter("user"));
		List<UserBean> listOfUsers = (List<UserBean>) userDao.retrieveUsers();
		
		if (user.getPassword().equals(request.getParameter("pass"))) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        request.setAttribute("userA", user);
	        request.setAttribute("listOfUsers", listOfUsers);
	        request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
	}

}
