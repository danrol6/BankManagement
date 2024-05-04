package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UsersDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UsersDao dao = new UsersDao();

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		if(dao.checkDatabase(username, password)) {
			// Success
			response.getWriter().append("Login successful!");
			System.out.println("Success!");
			
			String role = dao.getRole(username, password);	// grabs the role of the valid user
			
			if(role.contentEquals("Teller")) {
				// leads you to teller landing page
				System.out.println("Teller");
				// request.getRequestDispatcher("jsp/pages/viewActiveCustomersAsTeller.jsp").forward(request, response);
				request.getRequestDispatcher("/accounts/view").forward(request, response);
			} else if(role.contentEquals("Executive")){
				// leads you to executive landing page
				System.out.println("Executive");
				// request.getRequestDispatcher("jsp/pages/viewAllCustomersAsExecutive.jsp").forward(request, response);
				request.getRequestDispatcher("/customers/view").forward(request, response);
			} else {
				// error there was no executive or teller role in username
				request.getRequestDispatcher("jsp/Error.jsp").forward(request, response);
				
			}
			
		} else {
			// failure, alerts the user
			System.out.println("Login Failed");
			String loginError = "Login Failed";
			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<script type=\"text/javascript\">alert(" +loginError+ ");</script>");
			out.print("</head><body></body></html>");
		}
	}

}
