package com.controller;

import java.io.IOException;
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
 * Servlet implementation class AccountsReadServlet
 */
public class AccountsReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AccountsReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String idString = request.getParameter("customerId");
		AccountsService accountService = new AccountsService();
		CustomersService customerService = new CustomersService();
		
		if(idString != null) {
			Customer customer = null;
			customer = customerService.findById(idString);
			ArrayList<Account> accounts = null;
			
			accounts = accountService.findAccByCustomerId(idString);
			// spits out in the console just to see if it works
			for(Account account: accounts) {
				System.out.println(account);
			}
			
			session.setAttribute("customer", customer);
			session.setAttribute("accounts", accounts);
			
			response.setHeader("Refresh", "0; URL=../jsp/pages/viewCustomerAsTeller.jsp");
			//request.getRequestDispatcher("../jsp/pages/viewCustomerAsTeller.jsp").forward(request,response);
		} else {
			ArrayList<Customer> customers = null;
			customers = customerService.findAllActive();
			for(Customer customer: customers) {
				System.out.println(customer);
			}
			session.setAttribute("customers", customers);
			request.getRequestDispatcher("../jsp/pages/viewActiveCustomersAsTeller.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
