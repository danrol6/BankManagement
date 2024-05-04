package com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Account;
import com.entities.Customer;
import com.services.AccountsService;
import com.services.CustomersService;

/**
 * Servlet implementation class CustomersWriteServlet
 */
public class CustomersWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomersWriteServlet() {
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
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String ssn = request.getParameter("ssn");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dob = request.getParameter("dob");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		Timestamp lastUpdated = new Timestamp(System.currentTimeMillis());
		
		String action = request.getParameter("action");
		
		Customer customer = new Customer();
		
		customer.setId(id);
		customer.setSsn(ssn);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setDob(dob);
		customer.setAddressLine1(addressLine1);
		customer.setAddressLine2(addressLine2);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipcode(zipcode);
		customer.setLastUpdate(lastUpdated);
		
		System.out.println(customer);
		
		CustomersService service = new CustomersService();
		
		if (action.equals("add")) {
			service.save(customer);
			System.out.println("Added!");
			
			request.getRequestDispatcher("/customers/view").forward(request, response);
		}
		else if(action.equals("update")) {
			System.out.println("update servlet");
			//changes
			AccountsService acctService = new AccountsService();
			customer.setId(request.getParameter("id"));
			Customer newCustomer = new Customer();
			newCustomer = service.findById(customer.getId());
			customer.setCustomerStatus(newCustomer.getCustomerStatus());
			System.out.println("Update " + customer);
			service.update(customer);
			
			ArrayList<Account> accounts = acctService.findAccByCustomerId(customer.getId());
			System.out.println("List: "+accounts);
			session = request.getSession();
			session.setAttribute("message", "customer updated.");
			session.setAttribute("accounts", accounts);
			request.getRequestDispatcher("../jsp/pages/editCustomerAsExecutive.jsp").forward(request, response);
		}
			
	}

}
