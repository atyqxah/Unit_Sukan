package us.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.staffDAO;
import us.model.staff;

/**
 * Servlet implementation class addStaffController
 */
@WebServlet("/addStaffController")
public class addStaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addStaffController() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		staff s = new staff();
		s.setStaffID(request.getParameter("staffID"));
		s.setStaffPassword(request.getParameter("staffPassword"));
		s.setStaffName(request.getParameter("staffName"));
		s.setStaffContact(request.getParameter("staffContact"));
		s.setStaffEmail(request.getParameter("staffEmail"));
		s.setStaffRole(request.getParameter("staffRole"));
		s.setStaffStatus(request.getParameter("staffStatus"));
		
		 dao.add(s);

		    response.sendRedirect("listStaff.jsp");
	}

}
