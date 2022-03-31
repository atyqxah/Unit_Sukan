package us.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import us.DAO.assetDAO;
import us.DAO.itemDAO;
import us.DAO.nonAssetDAO;
import us.model.asset;
import us.model.item;
import us.model.nonAsset;

/**
 * Servlet implementation class additemController
 */
@WebServlet("/additemController")
public class additemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private itemDAO dao; 
	private assetDAO Adao;
	private nonAssetDAO Ndao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public additemController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new itemDAO();
        Adao = new assetDAO();
        Ndao = new nonAssetDAO();
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
		String productCode = request.getParameter("productCode");
		String description = request.getParameter("description");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String note = request.getParameter("note");
		String buydate = request.getParameter("buydate");
		int quantity = Integer.parseInt((request.getParameter("quantity")));
		double price = Double.parseDouble((request.getParameter("price")));
		String type = request.getParameter("type");
		
		String assetID = request.getParameter("assetID");
		String expiredDate = request.getParameter("expiredDate");
		String nonAssetID = request.getParameter("nonAssetID");
		String locations = request.getParameter("locations");
		String conditions = request.getParameter("conditions");
		
		item i = new item(productCode, description,  brand, model, note, buydate, quantity, price, type);
		//i = itemDAO.getItem(i);
		
		if(!i.isValid()){
			//System.out.println("adding");
			dao.add(i);
			//daoProduct.add(product);

			if (type.equalsIgnoreCase("asset")) {

				asset a = new asset(productCode, description, brand, model, note, buydate, quantity, price, type, false, assetID, expiredDate);

				try {
					Adao.add(a);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}else if (type.equalsIgnoreCase("nonAsset")) {

				nonAsset na = new nonAsset(productCode, description, brand, model, note, buydate, quantity, price, type, false, nonAssetID, locations, conditions);

				try {
					Ndao.add(na);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
			}
			

		    response.sendRedirect("listItem.jsp");
	}

	}

}
