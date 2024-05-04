package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Transaction;
import com.services.AccountsService;

/**
 * Servlet implementation class TransactionServlet
 */
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountsService service = new AccountsService();
		
		//timestamp string to timestamp type
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date parsedDate = null;
		try {
			parsedDate = (Date)dateFormat.parse(request.getParameter("lastTransaction"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
		
		Transaction tr = new Transaction();
		tr.setTransactionId(request.getParameter("transactionId"));
		tr.setAccountId(request.getParameter("accountId"));
		tr.setDate(timestamp);
		tr.setDescription(request.getParameter("description"));
		tr.setAmount(Double.parseDouble(request.getParameter("amount")));
		tr.setBalance(Double.parseDouble(request.getParameter("balance")));
		
		session.setAttribute("message", "Create Transaction");
		
		String transaction = request.getParameter("transactionType");
		String accountId = request.getParameter("customerAccountNo");
		String amountStr = request.getParameter("customerAccountBalance");
		Double amount = Double.parseDouble(amountStr);
		boolean check = false;
		
		// do if else statement to check transaction type
		if(transaction.contentEquals("withdraw")) {
			check = service.withdraw(accountId, amount);
			if(check) {
				session.setAttribute("message", "Withdrew Amount!");
				System.out.println("Withdrew amount: "+amount);
			} else {
				session.setAttribute("message", "Withdrew Amount!");
				System.out.println("Did not withdrew "+amount);
			}
			
			request.getRequestDispatcher("accounts/view").forward(request, response);
		} else if(transaction.contentEquals("deposit")) {
			check = service.deposit(accountId, amount);
			if(check) {
				session.setAttribute("message", "Deposited Amount!");
				System.out.println("Deposited amount: "+amount);
			} else {
				session.setAttribute("message", "Did not deposit!");
				System.out.println("Did not deposit "+amount);
			}
			
			request.getRequestDispatcher("accounts/view").forward(request, response);
		} else if(transaction.contentEquals("transfer")) {
			String transferId = request.getParameter("transferAccount");
			check = service.transfer(accountId, amount, transferId);
			
			if(check) {
				session.setAttribute("message", "Transfered Amount!");
				System.out.println("Transfered amount: "+amount);
			} else {
				session.setAttribute("message", "Did not transfer!");
				System.out.println("Did not transfer "+amount);
			}
			
			request.getRequestDispatcher("accounts/view").forward(request, response);
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
