package com.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import com.dao.CustomersDao;
import com.entities.Customer;

public class CustomersDemo {
	private static CustomersDao dao = new CustomersDao();

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		Timestamp timestamp = new Timestamp(date.getTime());
		
		// Select all
		System.out.println("Displaying all customers");
		ArrayList<Customer> customers = dao.findAll();
		displayStocks(customers);
		
		// Select all active customers
		System.out.println("\nDisplaying all active customers");
		ArrayList<Customer> activeCustomers = dao.findAllActive();
		displayStocks(activeCustomers);
		
		// Find by ID
		System.out.println("\nFinding customer by id");
		Customer customer = dao.findById("100000100");
		System.out.println(customer);
		
		// Add new
		Customer customer2 = new Customer();
		customer2.setId("100000100");
		customer2.setSsn("123456789");
		customer2.setFirstName("First123");
		customer2.setLastName("LasttEst123");
		customer2.setDob("01/01/2000");
		customer2.setAddressLine1("123 test address");
		customer2.setAddressLine2("Apt 2");
		customer2.setCity("Chicago");
		customer2.setState("IL");
		customer2.setZipcode("60025");
		customer2.setCustomerStatus("active");
		customer2.setLastUpdate(timestamp);
		System.out.println("\nAdding a new Customer...");
		dao.save(customer2);
		
		// Update customer
		System.out.println("\nUpdating a record...");
		customer2.setFirstName("UpdatedTestFirstName");
		dao.update(customer2);
		
		// Delete customer
		System.out.println("\nDeleting a record...");
		System.out.println(dao.findByCustomerId("100000100"));
		dao.delete("100000100");
		System.out.println("\nDisplaying updated list...");
		customers = dao.findAll();
		displayStocks(customers);
		
		// Search by last name
		System.out.println("\nSearching by Last name...");
		ArrayList<Customer> searchByLastName = dao.findByLastName("test");
		displayStocks(searchByLastName);
		
		// Search by SSN
		System.out.println("\nSearching by SSN...");
		Customer searchBySsn = dao.findBySsn("123-45-7890");
		System.out.println(searchBySsn);
		
		// Search by CustomerID
		System.out.println("\nSearching by Customer ID...");
		Customer searchByCustomerId = dao.findByCustomerId("000000002");
		System.out.println(searchByCustomerId);
	}
	
	private static void displayStocks(ArrayList<Customer> customers) {
		for (Customer customer: customers) {
			System.out.println(customer);
		}
	}
	
	
	

}
