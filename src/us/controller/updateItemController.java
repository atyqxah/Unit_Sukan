package us.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.itemDAO;
import us.model.item;

/**
 * Servlet implementation class updateItemController
 */
@WebServlet("/updateItemController")
public class updateItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private itemDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateItemController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new itemDAO();
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
		item z = new item();
		z.setProductCode(request.getParameter("productCode"));
		
		z.setNote(request.getParameter("note"));
		
		z.setQuantity(Integer.parseInt((request.getParameter("quantity"))));
		
		 dao.updateItem(z);

		    response.sendRedirect("listItem.jsp");
	}

}
