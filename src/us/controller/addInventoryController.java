package us.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.inventoryDAO;
import us.DAO.staffDAO;
import us.model.inventory;
import us.model.staff;

/**
 * Servlet implementation class addInventoryController
 */
@WebServlet("/addInventoryController")
public class addInventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private inventoryDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addInventoryController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new inventoryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("test");
		inventory i = new inventory();
		i.setStaffID(request.getParameter("staffID"));
		System.out.println(request.getParameter("staffID"));
		i.setProductCode(request.getParameter("productCode"));
		i.setSupID(request.getParameter("supID"));
		i.setLatestDate(request.getParameter("latestDate"));
		 dao.add(i);

		    response.sendRedirect("listInventory.jsp");
	}

}
