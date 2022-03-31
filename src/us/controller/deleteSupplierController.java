package us.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.supplierDAO;

/**
 * Servlet implementation class deleteSupplierController
 */
@WebServlet("/deleteSupplierController")
public class deleteSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String DELETE = "/listSupplier.jsp";
    private supplierDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSupplierController() {
        super();
        dao = new supplierDAO();
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

        if (action.equalsIgnoreCase("delete")){
        	    String supid = (request.getParameter("supid"));
	            dao.deleteSupplier(supid);
	            forward = DELETE;
	            request.setAttribute("Lsup", dao.getAllSupplier());    
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
