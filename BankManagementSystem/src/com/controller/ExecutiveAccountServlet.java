package com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.entities.Account;
import com.services.AccountsService;


/**
 * Servlet implementation class ExecutiveAccountServlet
 */
public class ExecutiveAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecutiveAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside get");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		AccountsService service = new AccountsService();
		String action = request.getParameter("action");
		System.out.println("action"+action);
		if(action.equalsIgnoreCase("update"))
		{
		String accId=request.getParameter("accountId");
		String status = request.getParameter("status");
		service.updateAccStatus(accId, status);
		Account account = service.findById(accId);
		response.sendRedirect(request.getContextPath()+ "/customers/view?id="+account.getCustomerId());
		
		}
		else if(action.equalsIgnoreCase("show"))
		{
			String idString = request.getParameter("customerId");
			System.out.println("show"+idString);
			if(idString != null) {
				
				Account account = new Account();
				account.setCustomerId(idString);
				session.setAttribute("account", account);
				response.sendRedirect(request.getContextPath()+ "/jsp/pages/createAccount.jsp");
				//request.getRequestDispatcher("../jsp/pages/createAccount.jsp").forward(request,response);
			}
		}
		else if(action.equalsIgnoreCase("save")) {
			String custId =  request.getParameter("customerId");
			String accId = request.getParameter("accountId");
			String accType = request.getParameter("accountType");
			double balance = Double.parseDouble(request.getParameter("balance"));
			LocalDateTime date = LocalDateTime.now();
			date.toString().replace('T', ' ');
			Timestamp timestamp = Timestamp.valueOf(date);
			Account acc = new Account();
			acc.setAccountType(accType);
			acc.setBalance(balance);
			acc.setLastTransaction(timestamp);
			acc.setCustomerId(custId);
			acc.setStatus("Open");
			acc.setAccountId(accId);
			System.out.println("New Account: "+acc.toString());
			Account account = service.save(acc);
			response.sendRedirect(request.getContextPath()+ "/customers/view?id="+account.getCustomerId());
		}
	}

}
