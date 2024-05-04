package com.demo;

import java.sql.Timestamp;
import java.util.ArrayList;
import com.dao.UsersDao;
import com.entities.User;

public class UsersDemo {
	
	private static UsersDao dao = new UsersDao();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub// Select All
		System.out.println("Displaying Table:");
		ArrayList<User> items = dao.findAll();
		displayTable(items);
		
		// Save a new item
		System.out.println();
		User newItem = new User();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		
		newItem.setUserId(3);
		newItem.setUsername("drodan123");
		newItem.setPassword("drodan12345");
		newItem.setFirstName("daniel");
		newItem.setLastName("roldan");
		newItem.setRole("Teller");
		newItem.setLastLogin(ts);	
		dao.save(newItem);
		
		items = dao.findAll();
		displayTable(items);
		
		// Fetch item by item id
		System.out.println("\nFinding...");
		User item1 = dao.findById(1);
		System.out.println(item1);
		
		// Update item
		System.out.println();
		User item2 = dao.findById(3);
		item2.setRole("Executive");
		dao.update(item2);
		
		items = dao.findAll();
		displayTable(items);
		
		// Delete item
		System.out.println();
		dao.delete(3);
		items = dao.findAll();
		displayTable(items);
	}
	
	private static void displayTable(ArrayList<User> users) {
		for(User user: users) {
			System.out.println(user);
		}
	}
}
