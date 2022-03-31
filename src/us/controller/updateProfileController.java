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
 * Servlet implementation class updateProfileController
 */
@WebServlet("/updateProfileController")
public class updateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateProfileController() {
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
		staff u = new staff();
		u.setStaffID(request.getParameter("staffID"));
		u.setStaffPassword(request.getParameter("staffPassword"));
		u.setStaffName(request.getParameter("staffName"));
		u.setStaffContact(request.getParameter("staffContact"));
		u.setStaffEmail(request.getParameter("staffEmail"));
		u.setStaffRole(request.getParameter("staffRole"));
		u.setStaffStatus(request.getParameter("staffStatus"));
		//System.out.println(request.getParameter("staffID"));
		 dao.updateStaff(u);

		    response.sendRedirect("listStaff.jsp");
	}

}
