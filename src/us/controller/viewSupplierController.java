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
 * Servlet implementation class viewSupplierController
 */
@WebServlet("/viewSupplierController")
public class viewSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW = "/viewSupplier.jsp";
	private supplierDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewSupplierController() {
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
        
		if (action.equalsIgnoreCase("viewSupplier")){			        	
        	String supid = (request.getParameter("supid"));        	
        	forward = VIEW;
        	request.setAttribute("i", dao.getSupplierById(supid));
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
