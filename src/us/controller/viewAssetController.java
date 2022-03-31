package us.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.itemDAO;

/**
 * Servlet implementation class viewAssetController
 */
@WebServlet("/viewAssetController")
public class viewAssetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW = "/viewAsset.jsp";
	private itemDAO dao;  

    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAssetController() {
        super();
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
        
		if (action.equalsIgnoreCase("viewAsset")){			        	
        	String productCode = (request.getParameter("productCode"));        	
        	forward = VIEW;
        	request.setAttribute("i", dao.getItemByPC(productCode));
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
