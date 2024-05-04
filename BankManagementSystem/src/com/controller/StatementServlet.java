package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.Transaction;
import com.services.AccountsService;

/**
 * Servlet implementation class StatementServlet
 */
public class StatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AccountsService service = new AccountsService();
		ArrayList<Transaction> transactions = null;
		String accountId = request.getParameter("accountId");
		
		String type = request.getParameter("searchType");
		
		if(type.contentEquals("latest")) {
			String num = request.getParameter("lastNumber");
			transactions = service.recentTransaction(accountId, Integer.parseInt(num));
			
		}else if(type.contentEquals("range")) {		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date startDate = null;
			Date endDate = null;
			try {
				startDate = (Date)dateFormat.parse(request.getParameter("start"));
				endDate = (Date)dateFormat.parse(request.getParameter("end"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Timestamp timestampStart = new Timestamp(startDate.getTime());
			Timestamp timestampEnd = new Timestamp(endDate.getTime());
			transactions = service.findByStartEndDate(accountId, timestampStart, timestampEnd);
		}
		
		session.setAttribute("transactions", transactions);
		request.getRequestDispatcher("../jsp/pages/accountStatement.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
