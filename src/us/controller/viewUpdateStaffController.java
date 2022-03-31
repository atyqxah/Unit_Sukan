package us.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.staffDAO;
import us.model.staff;

/**
 * Servlet implementation class viewUpdateStaffController
 */
@WebServlet("/viewUpdateStaffController")
public class viewUpdateStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String UPDATE = "/updateStaff.jsp";
	private staffDAO dao;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewUpdateStaffController() {
        super();
        dao = new staffDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String forward="";
        String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("viewStaffDetail")){			        	
        	String staffID = (request.getParameter("staffID"));        	
        	forward = UPDATE;
        	request.setAttribute("i", dao.getStaffById(staffID));
        }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//staff s = new staff();
		//s.setStaffID(request.getParameter("staffID"));
		//s.setStaffPassword(request.getParameter("staffPassword"));
		//s.setStaffName(request.getParameter("staffName"));
		//s.setStaffContact(request.getParameter("staffContact"));
		//s.setStaffEmail(request.getParameter("staffEmail"));
		//s.setStaffRole(request.getParameter("staffRole"));
		//s.setStaffStatus(request.getParameter("staffStatus"));
		
		 //dao.updateStaff(s);
		 //String staffID = request.getParameter("staffID");
		 response.sendRedirect("listStaff.jsp");
	}

}
