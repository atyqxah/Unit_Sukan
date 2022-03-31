package us.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.staffDAO;

/**
 * Servlet implementation class listStaffController
 */
@WebServlet("/listStaffController")
public class listStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_ALL = "/listStaff.jsp";
	private staffDAO dao;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listStaffController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new staffDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String forward="";
        String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("listStaff")){
        	forward = LIST_ALL;
        	request.setAttribute("Lstaff", dao.getAllStaff());
        }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
