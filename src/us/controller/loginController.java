package us.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import us.DAO.staffDAO;
import us.connection.connectionmanagers;
import us.model.staff;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginController() {
		super();
		dao = new staffDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String staffID = request.getParameter("staffID");
		String staffPassword = request.getParameter("staffPassword");
		HttpSession session = request.getSession(true);//declare session
		connectionmanagers cm = new connectionmanagers();
		staff s = null;
		
		//System.out.println(staffID);
		//System.out.println(staffPassword);
		
		try {
			s = cm.login(staffID, staffPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (s ==null) {
			request.setAttribute("fail", "Invalid ID and/or Password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		else if (s.getStaffRole().equals("admin")){
			
			session.setAttribute("role","admin");
			session.setAttribute("name",s.getStaffName());
			session.setAttribute("id",s.getStaffID());
			
			request.getRequestDispatcher("listItem.jsp").forward(request, response);
		}
		else if (s.getStaffRole().equals("staff")){
				
			session.setAttribute("role","staff");
			session.setAttribute("name",s.getStaffName());
			session.setAttribute("id",s.getStaffID());
			
			request.getRequestDispatcher("listItem.jsp").forward(request, response);
		}



		/*
		 * //HttpSession session = request.getSession(true);
		 * 
		 * staff z = new staff(); //creating object for LoginBean class, which is a
		 * normal java class, contains just setters and getters. Bean classes are
		 * efficiently used in java to access user information wherever required in the
		 * application.
		 * 
		 * z.setStaffID(staffID); //setting the username and password through the
		 * loginBean object then only you can get it in future.
		 * z.setStaffPassword(staffPassword);
		 * 
		 * staffDAO dao = new staffDAO(); //creating object for LoginDao. This class
		 * contains main logic of the application.
		 * 
		 * HttpSession session = null; String login = dao.login(z,session); //Calling
		 * login function
		 * 
		 * if(login.equalsIgnoreCase("admin")) //If function returns success string then
		 * user will be rooted to Home page {
		 * 
		 * 
		 * response.sendRedirect("listStaff.jsp"); //request.setAttribute("stud_ic",
		 * stud_ic); //with setAttribute() you can define a "key" and value pair so that
		 * you can get it in future using getAttribute("key")
		 * //request.getRequestDispatcher("studInformation.jsp").forward(request,
		 * response);//RequestDispatcher is used to send the control to the invoked
		 * page. } else if(login.equalsIgnoreCase("staff")) //If function returns
		 * success string then user will be rooted to Home page {
		 * 
		 * 
		 * response.sendRedirect("listStaff.jsp"); //request.setAttribute("stud_ic",
		 * stud_ic); //with setAttribute() you can define a "key" and value pair so that
		 * you can get it in future using getAttribute("key")
		 * //request.getRequestDispatcher("studInformation.jsp").forward(request,
		 * response);//RequestDispatcher is used to send the control to the invoked
		 * page. } else { request.setAttribute("errMessage", login); //If
		 * authenticateUser() function returnsother than SUCCESS string it will be sent
		 * to Login page again. Here the error message returned from function has been
		 * stored in a errMessage key.
		 * request.getRequestDispatcher("login.jsp").forward(request,
		 * response);//forwarding the request }


	}*/

	}
}
