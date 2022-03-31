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
 * Servlet implementation class updateSupplierController
 */
@WebServlet("/updateSupplierController")
public class updateSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private supplierDAO dao;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateSupplierController() {
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
		supplier x = new supplier();
		x.setSupid(request.getParameter("supid"));
		System.out.println(request.getParameter("supid"));
		
		x.setSupname(request.getParameter("supname"));
		System.out.println(request.getParameter("supname"));
		
		
		x.setSupemail(request.getParameter("supemail"));
		System.out.println(request.getParameter("supemail"));
		
		
		x.setSupcontact(Integer.parseInt((request.getParameter("supcontact"))));
		System.out.println(request.getParameter("supcontact"));
		
		
		x.setSupaddress(request.getParameter("supaddress"));
		System.out.println(request.getParameter("supaddress"));
		
		
		 dao.updateSupplier(x);

		    response.sendRedirect("listSupplier.jsp");
	}

}
