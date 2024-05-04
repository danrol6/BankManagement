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

import com.entities.Account;
import com.services.AccountsService;

/**
 * Servlet implementation class AccountsWriteServlet
 */
public class AccountsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AccountsWriteServlet() {
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
				
		//timestamp string to timestamp type
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss.SSS");
		Date parsedDate = null;
		try {
			parsedDate = (Date)dateFormat.parse(request.getParameter("lastTransaction"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(parsedDate.getTime());
		
		Account account = new Account();
		account.setAccountId(request.getParameter("accountId"));
		account.setCustomerId(request.getParameter("customerId"));
		account.setAccountType(request.getParameter("accountType"));
		account.setStatus(request.getParameter("status"));
		account.setBalance(Double.parseDouble(request.getParameter("balance")));
		account.setLastTransaction(timestamp);
		
		// cancel or doTransaction
		// cancel goes back to teller view customer
		// do transaction update money
		String action = request.getParameter("action");
		
		AccountsService service = new AccountsService();
		
		// grab action values and create methods for withdraw and transaction
		//	withdrawAmount & transactionAmount
		if(action.contentEquals("Save")){
			service.save(account);
			session.setAttribute("message", "Create New Account");
			
			request.getRequestDispatcher("accounts/view").forward(request, response);
		} else if(action.contentEquals("cancel")){
			session.setAttribute("message", "Cancel");
			
			request.getRequestDispatcher("accounts/view").forward(request, response);
		} else {
			session.setAttribute("error", "Account "+action+" failed");
			
			request.getRequestDispatcher("jsp/Error.jsp").forward(request, response);
		}
	}

}
