package us.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.supplierDAO;
import us.model.supplier;

/**
 * Servlet implementation class addSupplierController
 */
@WebServlet("/addSupplierController")
public class addSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private supplierDAO dao;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addSupplierController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new supplierDAO();
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
		supplier i = new supplier();
		i.setSupid(request.getParameter("supid"));
		i.setSupname(request.getParameter("supname"));
		i.setSupemail(request.getParameter("supemail"));
		i.setSupcontact(Integer.parseInt((request.getParameter("supcontact"))));
		i.setSupaddress(request.getParameter("supaddress"));
		
		 dao.add(i);

		    response.sendRedirect("listSupplier.jsp");
	}

}
