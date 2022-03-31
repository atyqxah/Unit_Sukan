package us.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.inventoryDAO;

/**
 * Servlet implementation class invLogViewController
 */
@WebServlet("/invLogViewController")
public class invLogViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_ALL = "/listLog.jsp";
	 private inventoryDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public invLogViewController() {
        super();
        // TODO Auto-generated constructor stub
       
        dao = new inventoryDAO();
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
        	request.setAttribute("Linventory", dao.getAllInventory());
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
