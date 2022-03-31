package us.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class itemController
 */
@WebServlet("/itemController")
public class itemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String VIEW_ASSET = "viewAsset.jsp";
	private static String VIEW_NONASSET = "viewNonAsset.jsp";
	private static String UPDATE_ASSET = "updateAsset.jsp";
	private static String UPDATE_NONASSET = "updateNonAsset.jsp";
	private static String LIST_ITEM = "itemList.jsp";
	private static String UPDATE_ITEM = "updateItem.jsp";
	private static String VIEW_ITEM = "viewItem.jsp";

	private itemDAO dao;
	private assetDAO Adao;
	private nonAssetDAO Ndao;
    
	String forward="";	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public itemController() {
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
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listItem")) {

			forward = LIST_ITEM;
			request.setAttribute("item", dao.getAllItem());

		} else if (action.equalsIgnoreCase("deleteItem")) {

			String productCode= request.getParameter("productCode");

			item i = new item();
			i = dao.getItemById(productCode);
			
			forward = LIST_ITEM;
			request.setAttribute("item", dao.getAllItem());

			dao.deleteItem(productCode);

			if (i.getType().contentEquals("asset")) {

				Adao.deleteAsset(productCode);

			} else if (i.getType().contentEquals("nonAsset")) {

				Ndao.deleteNonAsset(productCode);

			}

			forward = LIST_ITEM;
			request.setAttribute("item", dao.getAllItem()); 

		} else if (action.equalsIgnoreCase("updateItem")) {	

			String productCode= request.getParameter("productCode");

			item i = new item();
			i = dao.getItemById(productCode);
			
			forward = UPDATE_ITEM;
			request.setAttribute("i", i);
			
			if (i.getType().contentEquals("asset")) {

				asset a = new asset();
				a = Adao.getAssetById(i);
				forward = UPDATE_ASSET;
				request.setAttribute("asset", a); 

			} else if (i.getType().contentEquals("nonAsset")) {

				nonAsset na = new nonAsset();
				na = Ndao.getNonAssetById(i);
				forward = UPDATE_NONASSET;
				request.setAttribute("nonAsset", na); 
			} 


		} else if (action.equalsIgnoreCase("viewItem")) {

			String productCode= request.getParameter("productCode");

			item i = new item();
			i = dao.getItemById(productCode); 
			
			forward = VIEW_ITEM;       		
			request.setAttribute("i", i); 
			

			if (i.getType().contentEquals("asset")) {

				asset a = new asset();
				a = Adao.getAssetById(i);
				forward = VIEW_ASSET;
				request.setAttribute("asset", a); 

			} else if (i.getType().contentEquals("nonAsset")) {

				nonAsset na = new nonAsset();
				na = Ndao.getNonAssetById(i);
				forward = VIEW_NONASSET;
				request.setAttribute("nonAsset", na); 
			}      	
			forward = VIEW_ITEM;       		
			request.setAttribute("i", i); 
			
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		if(!i.isValid()){
			System.out.println("adding");
			dao.add(i);

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
	}else {

		System.out.println("product already exist");
		dao.updateItem(i);

		if (type.equalsIgnoreCase("Organic")) {
			asset a = new asset (productCode, description, brand, model, note, buydate, quantity, price, type, false, assetID, expiredDate);
			Adao.updateAsset(a);

			RequestDispatcher view = request.getRequestDispatcher(VIEW_ASSET);
			request.setAttribute("Asset", Adao.getAssetById(i));
			view.forward(request, response);


		} else if (type.equalsIgnoreCase("nonAsset")) {
			nonAsset na = new nonAsset(productCode, description, brand, model, note, buydate, quantity, price, type, false, nonAssetID, locations, conditions);
			Ndao.updateNonAsset(na);


			RequestDispatcher view = request.getRequestDispatcher(VIEW_NONASSET);
			request.setAttribute("NonAsset", Ndao.getNonAssetById(i));
			view.forward(request, response);


		}
	}

	}

}
