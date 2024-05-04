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
 * Servlet implementation class CustomersReadServlet
 */
public class CustomersReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CustomersReadServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		HttpSession session = request.getSession();
		CustomersService service = new CustomersService();
		
		String action = request.getParameter("action");
		//System.out.println(action);
		
		if(action!=null && action.equals("search")) {
			//System.out.println("here " + action);
			String searchValue = request.getParameter("searchValue"); 
			//System.out.println("here " + searchValue);
			ArrayList<Customer> customers = new ArrayList<Customer>();
			if(request.getParameter("searchBy").equals("SearchByLastName")) {
				customers = service.findByLastName(searchValue);
				for(Customer customer: customers) {
					System.out.println(customer);
				}
				
			}else if(request.getParameter("searchBy").equals("SearchBySSN")) {
				Customer customer = service.findBySsn(searchValue);
				if(customer.getId() != null) {
					customers.add(customer);
				}
				else {
					System.out.println("No Matches found");
				}
				//System.out.println(customer);
				
			}else if(request.getParameter("searchBy").equals("SearchByCustomerId")) {
				Customer customer = service.findByCustomerId(searchValue);
				if(customer.getId() != null) {
					customers.add(customer);
				}
				else {
					System.out.println("No Matches found");
				}
				//System.out.println(customer);
			}
			
			session.setAttribute("customers", customers);
			request.getRequestDispatcher("../jsp/pages/viewAllCustomersAsExecutive.jsp").forward(request, response);
			
		}else if(idString != null && !idString.equals("")) {
			System.out.println(idString);
			if(idString.length()<=9) {
				service = new CustomersService();
				
				Customer customer = service.findById(idString);
				session = request.getSession();
				if(session.getAttribute("accounts") != null)
				{
					session.removeAttribute("accounts");
				}
				session.setAttribute("customer", customer);
				
				request.getRequestDispatcher("../jsp/pages/editCustomerAsExecutive.jsp").forward(request, response);
			}
			else {
				int indexEnd = idString.indexOf("-") + 1;
				System.out.println(idString.substring(0, indexEnd));
				idString = idString.substring(indexEnd, idString.length());
				System.out.println(idString);
				
				AccountsService accountService = new AccountsService();
				//find all accounts that belong to that customer
				ArrayList<Account> customerAccounts = accountService.findAccByCustomerId(idString);
				ArrayList<String> accountsId = new ArrayList<String>();
				for(Account account : customerAccounts) {
					accountsId.add(account.getAccountId());
				}
				
				//find all transactions that belong to that account
				//delete all transactions that belong to that customer		
				for(String accounts : accountsId) {
					accountService.deleteTransactionsByAccountId(accounts);
					System.out.println("deleted");
				}
				
				//delete all the accounts that belong to that customer
				accountService.deleteByCustomerId(idString);
				
				//delete customer
				service.delete(idString);
				
				ArrayList<Customer> customers = service.findAllActive();
				
				session.setAttribute("customers", customers);
				response.setHeader("Refresh", "0; URL=../jsp/pages/viewAllCustomersAsExecutive.jsp");
			}
			
		}
		else { 
			ArrayList<Customer> customers = service.findAllActive();
			for(Customer customer: customers) {
				System.out.println("Test " + customer);
			}
			
			session.setAttribute("customers", customers);
			request.getRequestDispatcher("../jsp/pages/viewAllCustomersAsExecutive.jsp").forward(request, response);
		}
		
		//session.setAttribute("customers", customers);
		//request.getRequestDispatcher("../jsp/viewCustomersExecutives.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
