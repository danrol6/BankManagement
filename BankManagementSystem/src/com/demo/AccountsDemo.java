package com.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import com.dao.AccountsDao;
import com.entities.Account;

public class AccountsDemo {

	private static AccountsDao dao = new AccountsDao();
	
	public static void main(String[] args) {
		// Select All
		System.out.println("Displaying Table:");
		ArrayList<Account> items = dao.findAll();
		displayTable(items);
		
		// Save a new item
		System.out.println();
		Account newItem = new Account();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		newItem.setAccountId("900006969");
		newItem.setCustomerId("100000100");
		newItem.setAccountType("Checking");
		newItem.setStatus("Closed");
		newItem.setBalance(1000.00);
		newItem.setLastTransaction(ts);
		System.out.println("New item for table:");
		System.out.println(newItem);
		dao.save(newItem);
		System.out.println("\nUpdated table:");
		items = dao.findAll();
		displayTable(items);
		
		// Fetch item by item id
		System.out.println("\nFinding...");
		Account item1 = dao.findById("900006969");
		System.out.println(item1);
		
		// Update item
		System.out.println();
		System.out.println("\nFinding item to update...");
		Account item2 = dao.findById("900006969");
		item2.setBalance(2000.00);
		dao.update(item2);
		System.out.println("\nUpdated table:");
		items = dao.findAll();
		displayTable(items);
		
		// Delete item
		System.out.println("\nDeleting:");
		System.out.println(dao.findById("900006969"));
		dao.deleteByAccountId("900006969");
		System.out.println("\nUpdated table:");
		items = dao.findAll();
		displayTable(items);
	}
	
	private static void displayTable(ArrayList<Account> accounts) {
		for(Account account: accounts) {
			System.out.println(account);
		}
	}
}
